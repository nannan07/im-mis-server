package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.ProjectSpecificMapper;
import com.allmsi.mis.model.po.ProjectSpecific;
import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.service.ProjectSpecificService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProjectSpecificServiceImpl extends BaseServiceImpl implements ProjectSpecificService {

	@Resource
	private ProjectSpecificMapper projectSpecificDao;

	@Override
	public ListBean selectProjectSpecificList(String token, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = getAuthUserId(token);
		map.put("authId", userId);
		List<ProjectSpecificVo> projectSpecificlist = new ArrayList<ProjectSpecificVo>();
		PageHelper.startPage(page, pageSize);
		List<ProjectSpecific> list = projectSpecificDao.selectList(map);
		PageInfo<ProjectSpecific> pageInfo = new PageInfo<ProjectSpecific>(list);
		int total = (int) pageInfo.getTotal();
		for (ProjectSpecific projectSpecific : list) {
			projectSpecificlist.add(new ProjectSpecificVo(projectSpecific));
		}

		return new ListBean(total, projectSpecificlist);
	}

	@Override
	public String saveProjectSpecific(ProjectSpecificVo projectSpecificVo) {
		if (projectSpecificVo == null || StrUtil.isEmpty(projectSpecificVo.getProjId())) {
			return null;
		}
		String id = projectSpecificVo.getId();
		if (StrUtil.isEmpty(id)) {// 添加
			ProjectSpecific record = new ProjectSpecific(projectSpecificVo);
			id = UUIDUtil.getUUID();
			record.setId(id);
			projectSpecificDao.insertSelective(record);
		} else {// 修改
			ProjectSpecific record = new ProjectSpecific(projectSpecificVo);
			projectSpecificDao.updateByPrimaryKeySelective(record);
		}
		return id;
	}

	@Override
	public boolean delProjectSpecific(String projId) {
		if (StrUtil.isEmpty(projId)) {
			return false;
		}
		projectSpecificDao.delByProjId(projId);
		return true;
	}

	@Override
	public String upDateProjectSpecificList(ProjectSpecificVo projectSpecificVo) {
		ProjectSpecific record = new ProjectSpecific(projectSpecificVo);
		int msg = projectSpecificDao.updateByPrimaryKeySelective(record);
		return (msg == 0) ? "" : record.getProjId();
	}

	@Override
	public String insertProjectSpecificLis(ProjectSpecificVo projectSpecificVo) {
		ProjectSpecific record = new ProjectSpecific(projectSpecificVo);
		int msg = projectSpecificDao.insertSelective(record);
		return (msg == 0) ? "" : record.getProjId();
	}

}
