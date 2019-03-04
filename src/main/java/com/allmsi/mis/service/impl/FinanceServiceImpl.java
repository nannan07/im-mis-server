package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.dao.FinanceContractMapper;
import com.allmsi.mis.dao.FinanceMapper;
import com.allmsi.mis.dao.FinanceRelatedMapper;
import com.allmsi.mis.model.po.Finance;
import com.allmsi.mis.model.po.FinanceContract;
import com.allmsi.mis.model.vo.ChoseVo;
import com.allmsi.mis.model.vo.FinanceDetailListVo;
import com.allmsi.mis.model.vo.FinanceListVo;
import com.allmsi.mis.model.vo.FinanceVo;
import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.mis.service.FinanceService;
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
public class FinanceServiceImpl extends BaseServiceImpl implements FinanceService {

	@Resource
	private FinanceMapper financeDao;
	@Resource
	private FinanceRelatedMapper relatedDao;
	@Resource
	private ProjectService projectService;

	@Resource
	private ProjectSpecificService projectSpecificService;

	@Resource
	private FinanceContractMapper financeContractDao;

	@Override
	public ListBean draft(String token, String search, Integer page, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		String cUserId = getAuthUserId(token);
		map.put("cUserId", cUserId);
		map.put("search", search);
		PageHelper.startPage(page, pageSize);
		List<FinanceListVo> finListVo = new ArrayList<FinanceListVo>();
		List<Finance> finList = financeDao.draft(map);
		PageInfo<Finance> pageInfo = new PageInfo<Finance>(finList);
		int total = (int) pageInfo.getTotal();
		for (Finance finance : finList) {
			finListVo.add(new FinanceListVo(finance));
		}
		return new ListBean(total, finListVo);
	}

	public List<FinanceVo> selectByProjId(String projId) {
		List<FinanceVo> finVoList = new ArrayList<FinanceVo>();
		if (StrUtil.notEmpty(projId)) {
			List<Finance> finList = financeDao.selectByProjId(projId);
			for (Finance finance : finList) {
				finVoList.add(new FinanceVo(finance));
			}
		}
		return finVoList;
	}

	@Override
	public FinanceVo selectByPrimaryKey(String id) {
		Finance finance = financeDao.selectByPrimaryKey(id);
		return new FinanceVo(finance);
	}

	@Override
	public String save(String token, FinanceVo financeVO) {
		Finance finance = new Finance(financeVO);
		String userId = getAuthUserId(token);
		int msg = 0;
		if (StrUtil.isEmpty(financeVO.getId())) {
			finance.setId(UUIDUtil.getUUID());
			finance.setDraft(0);
			msg = financeDao.insertSelective(finance);
			insertDataUser(userId, OperationMenu.USER_INSERT, finance.getId());// 添加到datauser表
		} else {
			msg = financeDao.updateByPrimaryKeySelective(finance);
			insertDataUser(userId, OperationMenu.USER_UPDATE, finance.getId());
		}
		return (msg == 0) ? "" : finance.getId();
	}

	private Finance getFinance(String token, FinanceVo financeVo) {
		AuthUserVo user = getAuthUser(token);
		String userId = user.getId();
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		// 添加立项人
		financeVo.setcUserId(userId);
		financeVo.setFinUserId(userId);
		financeVo.setFinUserName(user.getUserName());
		// 获取用户部门
		AuthDeptVo authDeptVo = getUserOnthDept(user.getDeptIds(), user.getDeptNames());
		if (authDeptVo != null) {
			financeVo.setFinUserDept(authDeptVo.getId());
			financeVo.setFinUserDeptName(authDeptVo.getDeptName());
		}
		Finance finance = new Finance(financeVo);
		return finance;
	}

	@Override
	public String submit(String token, FinanceVo financeVo, String result) {
		String id = financeVo.getId();
		if (OperationMenu.SUBMIT.equals(result)) {// 发起流程
			financeVo.setDraft(1);
			Finance finance = getFinance(token, financeVo);
			String projId = financeVo.getProjId();
			if (StrUtil.notEmpty(projId)) {
				ProjectVo vo = projectService.selectByProjId(projId);// 判断projId 是否合法
				if (vo != null && projId.equals(vo.getProjId())) {
					return updateFinanceAndProj(token, financeVo);// 更新流程、业务数据
				}
			}
			projId = addProj(finance);
			financeVo.setProjId(projId);
			FinanceVo vo = selectByPrimaryKey(id);
			if (vo != null && StrUtil.notEmpty(vo.getId())) { // 有，更新
				updateFinance(token, financeVo);
			} else { // 没有，添加
				firstAddFinance(token, financeVo);
			}
		} else {// 添加草稿
			financeVo.setDraft(0);
			if (StrUtil.isEmpty(id)) {
				financeVo.setId(UUIDUtil.getUUID());
				id = firstAddFinance(token, financeVo);
			} else {// 修改草稿
				id = updateFinance(token, financeVo);
			}
		}
		return id;
	}

	private String addProj(Finance finance) {
		ProjectVo projVo = new ProjectVo(finance);
		projVo.setContUserId(finance.getcUserId());
		String projId = projectService.insertProject(projVo);
		ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
		projectSpecificVo.setId(UUIDUtil.getUUID());
		projectSpecificVo.setProjId(projId);
		projectSpecificVo.setFinaceState("审核中");
		projectSpecificVo.setFinace("财务立项");
		projectSpecificService.insertProjectSpecificLis(projectSpecificVo);
		addCommonData(finance.getcUserId(), OperationMenu.USER_INSERT, projId);
		return projId;
	}

	private String updateFinanceAndProj(String token, FinanceVo financeVo) {
		String projId = projectService.updateEffective(new ProjectVo(financeVo));// 更新项目总预算
		Finance finance = getFinance(token, financeVo);
		if (StrUtil.isEmpty(projId)) {
			return "";
		} else {
			finance.setProjId(projId);
			finance.setDraft(1);
			updateFinance(token, financeVo);
			insertDataUser(finance.getcUserId(), OperationMenu.USER_UPDATE, finance.getId());
			addCommonData(finance.getcUserId(), OperationMenu.USER_UPDATE, finance.getId(), projId);
		}
		return finance.getId();
	}

	private String firstAddFinance(String token, FinanceVo financeVo) {
		Finance finance = getFinance(token, financeVo);
		int msg = financeDao.insertSelective(finance);
		insertFinanceContract(finance.getId(), finance.getContIds());
		insertDataUser(finance.getcUserId(), OperationMenu.USER_INSERT, finance.getId());
		return (msg == 0) ? "" : finance.getId();
	}

	private String updateFinance(String token, FinanceVo financeVo) {
		Finance finance = getFinance(token, financeVo);
		financeDao.updateByPrimaryKeySelective(finance);
		financeContractDao.deleteByFinId(finance.getId());
		return financeVo.getId();
	}

	private boolean insertFinanceContract(String finId, List<String> contIds) {
		List<FinanceContract> list = new ArrayList<FinanceContract>();
		int msg = 0;
		if (contIds != null && contIds.size() > 0) {
			for (String contId : contIds) {
				list.add(new FinanceContract(UUIDUtil.getUUID(), finId, contId, ""));
			}
			if (list != null && list.size() > 0) {
				msg = financeContractDao.insertBatch(list);
			}
		}
		return (msg == 0) ? false : true;
	}

	@Override
	public String successful(String id) {
		FinanceVo finVo = selectByPrimaryKey(id);// 流程审核成功后
		String projId = finVo.getProjId();
		List<FinanceVo> list = selectByProjId(projId);// 获取项目下的所有财务列表
		Integer totalBudget = getTotalBudget(list);// 计算要同步的数值
		return synProject(projId, totalBudget);// 更新项目台账中的信息
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		financeDao.deleteByPrimaryKey(id);
		return true;
	}

	private Integer getTotalBudget(List<FinanceVo> finListVo) {
		Integer totalBudget = 0;
		if (finListVo.size() > 0) {
			for (FinanceVo financeVo : finListVo) {
				if (StrUtil.notEmpty(financeVo.getOurAmount()) && StrUtil.isNumeric(financeVo.getOurAmount())) {
					try {
						totalBudget += Integer.valueOf(financeVo.getOurAmount());
					} catch (Exception e) {

					}
				}
			}
		}
		return totalBudget;
	}

	private String synProject(String projId, Integer totalBudget) {
		FinanceVo finVo = new FinanceVo();
		finVo.setProjId(projId);
		finVo.setOurAmount(String.valueOf(totalBudget));// 财务要同步到项目台账中的信息
		String msg = projectService.updateEffective(new ProjectVo(finVo));// 更新项目总预算
		ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
		projectSpecificVo.setProjId(projId);
		projectSpecificVo.setFinaceState("结束");
		projectSpecificService.upDateProjectSpecificList(projectSpecificVo);
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
		List<FinanceDetailListVo> finListVo = new ArrayList<FinanceDetailListVo>();
		List<Finance> finList = financeDao.selectByProjId(projId);
		PageInfo<Finance> pageInfo = new PageInfo<Finance>(finList);
		int total = (int) pageInfo.getTotal();
		for (Finance finance : finList) {
			finListVo.add(new FinanceDetailListVo(finance));
		}
		return new ListBean(total, finListVo);
	}

	@Override
	public List<FinanceVo> selectByIds(List<String> objIds) {
		List<FinanceVo> list = new ArrayList<>();
		if (objIds != null && objIds.size() > 0) {
			List<Finance> finList = financeDao.selectByIds(objIds);
			for (Finance finance : finList) {
				list.add(new FinanceVo(finance));
			}
		}
		return list;
	}

	@Override
	public Object selectListByProjId(String projId) {
		List<Finance> finList = financeDao.selectListByProjId(projId);
		List<ChoseVo> list = new ArrayList<ChoseVo>();
		for (Finance finance : finList) {
			list.add(new ChoseVo(finance.getFinName(), finance.getId()));
		}
		return list;
	}
}
