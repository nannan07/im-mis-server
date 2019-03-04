package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.dao.BusinessMapper;
import com.allmsi.mis.model.po.Business;
import com.allmsi.mis.model.vo.BusinessDetailListVo;
import com.allmsi.mis.model.vo.BusinessListVo;
import com.allmsi.mis.model.vo.BusinessVo;
import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.mis.service.BusinessService;
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
@Transactional
public class BusinessServiceImpl extends BaseServiceImpl implements BusinessService {

	@Resource
	private BusinessMapper businessDao;

	@Resource
	private ProjectService projectService;

	@Resource
	private ProjectSpecificService projectSpecificService;

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
		List<BusinessListVo> bizListVo = new ArrayList<BusinessListVo>();
		List<Business> bizList = businessDao.draft(map);
		PageInfo<Business> pageInfo = new PageInfo<Business>(bizList);
		int total = (int) pageInfo.getTotal();
		for (Business business : bizList) {
			bizListVo.add(new BusinessListVo(business));
		}
		return new ListBean(total, bizListVo);
	}

	@Override
	public BusinessVo selectByPrimaryKey(String id) {
		Business business = businessDao.selectByPrimaryKey(id);
		return new BusinessVo(business);
	}

	private Business getBusiness(String token, BusinessVo businessVo) {
		AuthUserVo user = getAuthUser(token);
		String userId = user.getId();
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		// 添加立项人
		businessVo.setcUserId(userId);
		businessVo.setBizUserName(user.getUserName());
		businessVo.setBizUserId(userId);
		// 获取用户部门
		AuthDeptVo authDeptVo = getUserOnthDept(user.getDeptIds(), user.getDeptNames());
		if (authDeptVo != null) {
			businessVo.setBizUserDeptId(authDeptVo.getId());
			businessVo.setBizUserDeptName(authDeptVo.getDeptName());
		}
		Business business = new Business(businessVo);
		business.setcUserId(userId);
		return business;
	}

	@Override
	public String submit(String token, BusinessVo businessVo, String result) {
		String id = businessVo.getId();
		if (OperationMenu.SUBMIT.equals(result)) {// 发起流程
			businessVo.setDraft(1);
			BusinessVo vo = selectByPrimaryKey(id);
			if (vo != null && StrUtil.notEmpty(vo.getId())) {
				if (1 == vo.getDraft()) {
					updateBusiness(new Business(businessVo));
				} else {// 草稿发起的流程
					String projId = projectService.insertProject(new ProjectVo(businessVo));
					businessVo.setProjId(projId);
					updateBusiness(new Business(businessVo));
					addCommonData(businessVo.getcUserId(), OperationMenu.USER_UPDATE, businessVo.getId(), businessVo.getProjId());
				}
			} else {
				id = firstAddBusiness(token, businessVo);// 首次发起流程
			}
		} else {// 添加草稿
			businessVo.setDraft(0);
			if (StrUtil.isEmpty(id)) {
				id = UUIDUtil.getUUID();
				businessVo.setId(id);
				return addBussiness(token, businessVo);
			} else {// 修改草稿
				updateBusiness(new Business(businessVo));
			}
		}
		return id;
	}

	@Override
	public String successful(String token, String id) {
		String userId = getAuthUserId(token);
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		BusinessVo businessVo = selectByPrimaryKey(id);// 立项成功后查询业务立项信息
		String projId = projectService.updateEffective(new ProjectVo(businessVo));// 更新项目台账里的信息;
		if (StrUtil.notEmpty(projId)) {
			ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
			projectSpecificVo.setProjId(projId);
			projectSpecificVo.setBizState("结束");
			projectSpecificService.upDateProjectSpecificList(projectSpecificVo);
			insertDataUser(userId, OperationMenu.USER_UPDATE, projId);// 添加到datauser表
		}
		return projId;
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		return (businessDao.deleteByPrimaryKey(id) == 0) ? false : true;
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
		List<BusinessDetailListVo> bizListVo = new ArrayList<BusinessDetailListVo>();
		List<Business> bizList = businessDao.selectByProjId(projId);
		PageInfo<Business> pageInfo = new PageInfo<Business>(bizList);
		int total = (int) pageInfo.getTotal();
		for (Business business : bizList) {
			bizListVo.add(new BusinessDetailListVo(business));
		}
		return new ListBean(total, bizListVo);
	}

	@Override
	public List<BusinessVo> selectByIds(List<String> objIds) {
		List<BusinessVo> list = new ArrayList<BusinessVo>();
		if (objIds != null && objIds.size() > 0) {
			List<Business> bList = businessDao.selectByIds(objIds);
			for (Business business : bList) {
				list.add(new BusinessVo(business));
			}
		}
		return list;
	}

	private String firstAddBusiness(String token, BusinessVo businessVo) {
		String projId = projectService.insertProject(new ProjectVo(businessVo));
		String id = "";
		if (StrUtil.isEmpty(projId)) {
			return "";
		} else {
			businessVo.setProjId(projId);
			id = addBussiness(token, businessVo);
		}
		addCommonData(businessVo.getcUserId(), OperationMenu.USER_UPDATE, businessVo.getId(), businessVo.getProjId());
		return id;
	}

	private String addBussiness(String token, BusinessVo businessVo) {
		Business business = getBusiness(token, businessVo);
		int count = businessDao.insertSelective(business);
		insertDataUser(business.getcUserId(), OperationMenu.USER_INSERT, business.getId());
		return (count == 0) ? "" : business.getId();
	}

	private void updateBusiness(Business business) {
		businessDao.updateByPrimaryKeySelective(business);// 更新业务信息
		insertDataUser(business.getcUserId(), OperationMenu.USER_UPDATE, business.getId());
	}

}
