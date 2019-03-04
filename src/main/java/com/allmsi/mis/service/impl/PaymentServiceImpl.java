package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.dao.PaymentMapper;
import com.allmsi.mis.model.po.Payment;
import com.allmsi.mis.model.vo.PayDraftedVo;
import com.allmsi.mis.model.vo.PaymentDetailListVo;
import com.allmsi.mis.model.vo.PaymentVo;
import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.mis.service.ProjectService;
import com.allmsi.mis.service.ProjectSpecificService;
import com.allmsi.mis.third.model.vo.AuthDeptVo;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PaymentServiceImpl extends BaseServiceImpl implements PaymentService {

	@Resource
	private PaymentMapper paymentDao;
	@Resource
	private ProjectService projectService;

	@Resource
	private ProjectSpecificService projectSpecificService;

	@Override
	public ListBean draft(String token, String search, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}

		String userId = getAuthUserId(token);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cUserId", userId);
		map.put("search", search);
		List<PayDraftedVo> list = new ArrayList<PayDraftedVo>();
		PageHelper.startPage(page, pageSize);
		List<Payment> payList = paymentDao.draft(map);
		for (Payment pay : payList) {
			list.add(new PayDraftedVo(pay));
		}
		PageInfo<Payment> pageInfo = new PageInfo<Payment>(payList);
		int total = (int) pageInfo.getTotal();
		return new ListBean(total, list);
	}

	@Override
	public List<PaymentVo> selectByProjId(String projId) {
		List<PaymentVo> payVoList = new ArrayList<PaymentVo>();
		if (StrUtil.notEmpty(projId)) {
			List<Payment> payList = paymentDao.selectByProjId(projId);
			for (Payment payment : payList) {
				payVoList.add(new PaymentVo(payment));
			}
		}
		return payVoList;
	}

	@Override
	public PaymentVo selectByPrimaryKey(String id) {
		Payment payment = paymentDao.selectByPrimaryKey(id);
		return new PaymentVo(payment);
	}

	@Override
	public String save(String token, PaymentVo paymentVo) {
		String userId = getAuthUserId(token);
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		Payment payment = new Payment(paymentVo);
		int msg = 0;
		if (StrUtil.isEmpty(paymentVo.getId())) {
			payment.setId(UUIDUtil.getUUID());
			payment.setDraft(0);
			msg = paymentDao.insertSelective(payment);
			insertDataUser(userId, OperationMenu.USER_INSERT, payment.getId());// 添加到datauser表
		} else {
			msg = paymentDao.updateByPrimaryKeySelective(payment);
			insertDataUser(userId, OperationMenu.USER_UPDATE, payment.getId());// 添加到datauser表
		}
		return (msg == 0) ? "" : payment.getId();
	}

	private Payment getPayment(String token, PaymentVo paymentVo) {
		AuthUserVo user = getAuthUser(token);
		String userId = user.getId();
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		// 添加立项人
		paymentVo.setcUserId(userId);
		paymentVo.setManagerId(userId);
		paymentVo.setManagerName(user.getUserName());
		// 获取用户部门
		AuthDeptVo authDeptVo = getUserOnthDept(user.getDeptIds(), user.getDeptNames());
		if (authDeptVo != null) {
			paymentVo.setPayDeptId(authDeptVo.getId());
			paymentVo.setPayDeptName(authDeptVo.getDeptName());
		}
		Payment payment = new Payment(paymentVo);
		return payment;
	}

	@Override
	public String submit(String token, PaymentVo paymentVo, String result) {
		String id = paymentVo.getId();
		if (OperationMenu.SUBMIT.equals(result)) {// 发起流程
			paymentVo.setDraft(1);
			Payment payment = getPayment(token, paymentVo);
			String projId = paymentVo.getProjId();
			if (StrUtil.notEmpty(projId)) {
				ProjectVo vo = projectService.selectByProjId(projId);// 判断projId 是否合法
				if (vo != null && projId.equals(vo.getProjId())) {
					return updatePaymentAndProj(token, paymentVo);// 更新流程、业务数据
				}
			}
			projId = addProj(payment);
			paymentVo.setProjId(projId);
			// 查询业务表中是否有该业务信息
			PaymentVo vo = selectByPrimaryKey(id);
			if (vo != null && StrUtil.notEmpty(vo.getId())) { // 有，更新
				updatePayment(token, paymentVo);
			} else { // 没有，添加
				firstAddPayment(token, paymentVo);
			}
		} else {// 添加草稿
			paymentVo.setDraft(0);
			if (StrUtil.isEmpty(id)) {
				paymentVo.setId(UUIDUtil.getUUID());
				id = firstAddPayment(token, paymentVo);
			} else {// 修改草稿
				id = updatePayment(token, paymentVo);
			}
		}
		return id;
	}

	private String addProj(Payment payment) {
		ProjectVo projVo = new ProjectVo(payment);
		projVo.setContUserId(payment.getcUserId());
		String projId = projectService.insertProject(projVo);
		addCommonData(payment.getcUserId(), OperationMenu.USER_INSERT, projId);
		return projId;
	}

	private String firstAddPayment(String token, PaymentVo paymentVo) {
		Payment payment = getPayment(token, paymentVo);
		int msg = paymentDao.insertSelective(payment);
		insertDataUser(payment.getcUserId(), OperationMenu.USER_INSERT, payment.getId());
		return (msg == 0) ? "" : payment.getId();
	}

	private String updatePaymentAndProj(String token, PaymentVo paymentVo) {
		Payment payment = getPayment(token, paymentVo);
		String projId = projectService.updateEffective(new ProjectVo(paymentVo));
		if (StrUtil.isEmpty(projId)) {
			return "";
		} else {
			payment.setProjId(projId);
			payment.setDraft(1);
			paymentDao.updateByPrimaryKeySelective(payment);// 更新业务信息
			insertDataUser(payment.getcUserId(), OperationMenu.USER_UPDATE, payment.getId());
			addCommonData(payment.getcUserId(), OperationMenu.USER_UPDATE, payment.getId(), projId);
		}
		return payment.getId();
	}

	private String updatePayment(String token, PaymentVo paymentVo) {
		Payment payment = getPayment(token, paymentVo);
		paymentDao.updateByPrimaryKeySelective(payment);
		insertDataUser(payment.getcUserId(), OperationMenu.USER_UPDATE, payment.getId());
		return payment.getId();
	}

	@Override
	public String successful(String id) {
		PaymentVo payVo = selectByPrimaryKey(id);// 流程审核成功后
		String projId = payVo.getProjId();
		List<PaymentVo> list = selectByProjId(projId);// 获取项目下的所有付款列表
		Integer totalExpenses = getTotalExpenses(list);// 计算要同步的数值
		return synProject(projId, totalExpenses, list);// 更新项目台账中的信息
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		paymentDao.deleteByPrimaryKey(id);
		return true;
	}

	private Integer getTotalExpenses(List<PaymentVo> paymentList) {
		Integer totalExpenses = 0;
		if (paymentList.size() > 0) {
			for (PaymentVo paymentVo : paymentList) {
				totalExpenses += paymentVo.getPayAmount();
			}
		}
		return totalExpenses;
	}

	private String synProject(String projId, Integer totalExpenses, List<PaymentVo> list) {
		PaymentVo paymentVo = new PaymentVo();
		paymentVo.setProjId(projId);
		paymentVo.setPayAmount(totalExpenses);
		// 付款要同步到项目台账中的信息
		String msg = projectService.updateEffective(new ProjectVo(paymentVo));// 更新项目总支出
		if (list != null && list.size() > 0) {
			int count = list.size();
			ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
			projectSpecificVo.setProjId(projId);
			projectSpecificVo.setCounts(count);
			projectSpecificService.upDateProjectSpecificList(projectSpecificVo);
		}

		return (StrUtil.isEmpty(msg)) ? "" : msg;
	}

	@Override
	public ListBean selectByProjId(String projId, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<PaymentDetailListVo> payListVo = new ArrayList<PaymentDetailListVo>();
		List<Payment> payList = paymentDao.selectByProjId(projId);
		PageInfo<Payment> pageInfo = new PageInfo<Payment>(payList);
		int total = (int) pageInfo.getTotal();
		for (Payment payment : payList) {
			payListVo.add(new PaymentDetailListVo(payment));
		}
		return new ListBean(total, payListVo);
	}

	@Override
	public List<PaymentVo> selectByIds(List<String> objIds) {
		List<PaymentVo> list = new ArrayList<>();
		if (objIds != null && objIds.size() > 0) {
			List<Payment> payList = paymentDao.selectByIds(objIds);
			for (Payment payment : payList) {
				list.add(new PaymentVo(payment));
			}
		}
		return list;
	}
}
