package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.service.DataAuthService;
import com.allmsi.mis.service.DataDeptService;
import com.allmsi.mis.service.CommonDataService;
import com.allmsi.mis.service.DataUserService;
import com.allmsi.mis.third.model.vo.AuthDeptVo;
import com.allmsi.mis.third.service.AuthMisService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class CommonDataServiceImpl implements CommonDataService {

	@Resource
	private DataAuthService dataAuthService;

	@Resource
	private DataDeptService dataDeptService;

	@Resource
	private DataUserService dataUserService;
	
	@Autowired
	private AuthMisService authMisService;
	
	@Override
	public boolean insertDataUser(String userId, String type, String... objIds) {
		int msg = dataUserService.insertSelective(userId, type, objIds);
		return (msg == 0) ? false : true;
	}

	@Override
	public boolean insertDataAuthBantch(String objId, String authType, String authId) {
		int msg = dataAuthService.insertDataAuthBantch(objId, authType, authId);
		return (msg == 0) ? false : true;
	}

	@Override
	public boolean insertDataAuthForDept(String objId, String deptId) {
		int msg = dataAuthService.insertDataAuthForDept(objId, deptId);
		return (msg == 0) ? false : true;
	}

	@Override
	public boolean deleteDataAuth(String objId, String authId) {
		int msg = dataAuthService.deleteDataAuth(objId, authId);
		return (msg == 0) ? false : true;
	}

	@Override
	public boolean insertDataAuthBantch(String objId, String... deptIds) {
		int msg = dataDeptService.insertDataAuthBantch(objId, deptIds);
		return (msg == 0) ? false : true;
	}

	@Override
	public boolean addCommonData(String userId, String type, String... objIds) {
		// im_tc_data_user
		dataUserService.insertSelective(userId, type, objIds);
		List<AuthDeptVo> deptList = getDeptParentTree(userId);
		List<String> deptIds = new ArrayList<String>();
		for (AuthDeptVo authDeptVo : deptList) {
			deptIds.add(authDeptVo.getId());
		}
		String[] strings = new String[deptIds.size()];
		deptIds.toArray(strings);
		for (String str : objIds) {
			dataAuthService.insertDataAuthBantch(str, "01", userId);// im_tc_data_auth
			dataDeptService.insertDataAuthBantch(str, strings); // im_tc_data_dept
		}
		return true;
	}

	@Override
	public int insertDataAuthUserIds(String objId, String[] authId) {
		return dataAuthService.insertDataAuthUserIds(objId, authId);
	}
	
	public List<AuthDeptVo> getDeptParentTree(String userId) {
		String json = authMisService.selectParentDeptByUserId(userId);
		Gson gson = new Gson();
		List<AuthDeptVo> list = gson.fromJson(json, new TypeToken<List<AuthDeptVo>>() {
		}.getType());
		return list;
	}
}
