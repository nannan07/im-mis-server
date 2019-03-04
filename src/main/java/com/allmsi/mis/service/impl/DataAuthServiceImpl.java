package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.DataAuthMapper;
import com.allmsi.mis.model.po.DataAuth;
import com.allmsi.mis.service.DataAuthService;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.mis.third.service.AuthMisService;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service
public class DataAuthServiceImpl implements DataAuthService {

	@Resource
	private DataAuthMapper dateAuthDao;

	@Autowired
	private AuthMisService authMisService;

	@Override
	public int insertDataAuthBantch(String objId, String authType, String authId) {
		List<DataAuth> list = new ArrayList<DataAuth>();
		list.add(new DataAuth(UUIDUtil.getUUID(), objId, authId, authType));
		int msg = 0;
		if (list != null && list.size() > 0) {
			msg = dateAuthDao.insertDataAuthBantch(list);
		}
		return msg;
	}

	@Override
	public int insertDataAuthForDept(String deptId, String objId) {
		if (StrUtil.isEmpty(deptId) || StrUtil.isEmpty(objId)) {
			return 0;
		}
		// 获取部门下的用户
		List<AuthUserVo> authUserList = getUserListByDept(deptId);
		List<DataAuth> list = new ArrayList<DataAuth>();
		for (AuthUserVo authUserVo : authUserList) {
			DataAuth dateAuth = new DataAuth();
			dateAuth.setId(UUIDUtil.getUUID());
			dateAuth.setObjId(objId);
			dateAuth.setAuthId(authUserVo.getId());
			dateAuth.setAuthType("01");
			list.add(dateAuth);
		}
		return dateAuthDao.insertDataAuthBantch(list);
	}

	@Override
	public int deleteDataAuth(String objId, String authId) {
		if (StrUtil.isEmpty(objId) || StrUtil.isEmpty(authId)) {
			return 0;
		}
		DataAuth dateAuth = new DataAuth();
		dateAuth.setAuthId(authId);
		dateAuth.setAuthType("01");
		dateAuth.setObjId(objId);
		dateAuthDao.deleteByObjIdAndAuthId(dateAuth);
		return 0;
	}

	@Override
	public boolean isHaveAuth(String objId, String userId) {
		if (StrUtil.isEmpty(objId) || StrUtil.isEmpty(userId)) {
			return false;
		}
		// 查询用户对于该objId是否有权限访问
		DataAuth dateAuth = new DataAuth();
		dateAuth.setAuthId(userId);
		dateAuth.setAuthType("01");
		dateAuth.setObjId(objId);
		DataAuth info = dateAuthDao.selectByObjIdAndUserId(dateAuth);
		if (info == null) {
			return false;
		}
		return true;
	}

	public List<AuthUserVo> getUserListByDept(String deptId) {
		List<AuthUserVo> list = new ArrayList<AuthUserVo>();
		if (StrUtil.isEmpty(deptId)) {
			return list;
		}
		String json = authMisService.getUserListByDept(deptId);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);
		JsonElement jsonIndex = je.getAsJsonObject().get("list");
		List<AuthUserVo> udInfoList = gson.fromJson(jsonIndex, new TypeToken<List<AuthUserVo>>() {
		}.getType());
		return udInfoList;
	}

	@Override
	public int insertDataAuthUserIds(String objId, String... authId) {
		List<DataAuth> list = new ArrayList<DataAuth>();
		for (String string : authId) {
			list.add(new DataAuth(UUIDUtil.getUUID(), objId, string, "01"));
		}
		int msg = 0;
		if (list != null && list.size() > 0) {
			msg = dateAuthDao.insertDataAuthBantch(list);
		}
		return msg;
	}
}
