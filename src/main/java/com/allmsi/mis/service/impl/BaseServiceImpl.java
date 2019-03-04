package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.allmsi.mis.service.CommonDataService;
import com.allmsi.mis.third.model.vo.AuthDeptVo;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.mis.third.model.vo.TodoVo;
import com.allmsi.mis.third.model.vo.NodeDealVo;
import com.allmsi.mis.third.model.vo.SubmitGuidOVo;
import com.allmsi.mis.third.service.AuthMisService;
import com.allmsi.mis.third.service.FlowMisService;
import com.allmsi.sys.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class BaseServiceImpl {

	@Autowired
	private AuthMisService authMisService;

	@Autowired
	private FlowMisService flowMisService;

	@Resource
	private CommonDataService commonDataService;

	public AuthUserVo getAuthUser(String token) {
		String json = authMisService.selectUserInfoBytoken(token);
		Gson gson = new Gson();
		AuthUserVo user = gson.fromJson(json, AuthUserVo.class);
		return user;
	}

	public String getAuthUserId(String token) {
		AuthUserVo user = getAuthUser(token);
		if (user == null) {
			return null;
		}
		return user.getId();
	}

	/**
	 * 用户所在的部门
	 * 
	 * @param deptIds
	 * @param deptNames
	 * @return
	 */
	public AuthDeptVo getUserDeptInfo(String deptIds, String deptNames) {
		AuthDeptVo authDeptVo = new AuthDeptVo();
		String[] deptIdArray = deptIds.split(",");
		int deptIdArraySize = deptIdArray.length;
		String[] deptNameArray = deptNames.split(",");
		int deptNameArraySize = deptNameArray.length;
		authDeptVo.setId(deptIdArray[deptIdArraySize - 1]);
		authDeptVo.setDeptName(deptNameArray[deptNameArraySize - 1]);
		return authDeptVo;
	}

	/**
	 * 用户所在的一级部门
	 * 
	 * @param deptIds
	 * @param deptNames
	 * @return
	 */
	public AuthDeptVo getUserOnthDept(String deptIds, String deptNames) {
		AuthDeptVo authDeptVo = new AuthDeptVo();
		String[] deptIdArray = deptIds.split(",");
		String[] deptNameArray = deptNames.split(",");
		authDeptVo.setId(deptIdArray[1]);
		authDeptVo.setDeptName(deptNameArray[1]);
		return authDeptVo;
	}

	/**
	 * 用户所在部门以及所有父部门信息
	 * 
	 * @param deptIds
	 * @return
	 */
	public List<String> getUserDeptList(String deptIds) {
		List<String> list = new ArrayList<String>();
		String[] deptIdArray = deptIds.split(",");
		for (String string : deptIdArray) {
			list.add(string);
		}
		return list;
	}

	/**
	 * 用户所在部门以及所有子部门信息
	 * 
	 * @param deptIds
	 * @return
	 */
	public List<String> getUserDepts(String token) {
		List<String> list = new ArrayList<String>();
		String userId = getAuthUserId(token);
		String json = authMisService.UserDepts(userId);
		Gson gson = new Gson();
		List<AuthDeptVo> udList = gson.fromJson(json, new TypeToken<List<AuthDeptVo>>() {
		}.getType());
		for (AuthDeptVo authDeptVo : udList) {
			list.add(authDeptVo.getId());
		}
		return list;
	}

	public SubmitGuidOVo submitFlow(String flowId, String instanceId, String preNodeId, String sufNodeId,
			String preDealId, String remark, String routeId, List<NodeDealVo> flowRouteDealList, TodoVo flowTodoVo) {
		String msg = flowMisService.submit(flowId, flowTodoVo.getObjId(), instanceId, preNodeId, sufNodeId, preDealId,
				remark, routeId, flowTodoVo.getObjName(), flowTodoVo.getUrgentLevel(), flowTodoVo.getObjValue1(),
				flowTodoVo.getObjValue2(), flowTodoVo.getObjValue3(), flowTodoVo.getObjValue4(),
				flowTodoVo.getObjValue5(), flowRouteDealList);
		Gson gson = new Gson();
		SubmitGuidOVo submitOVo = gson.fromJson(msg, SubmitGuidOVo.class);
		return submitOVo;
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

	public boolean insertDataUser(String userId, String type, String... objId) {
		return commonDataService.insertDataUser(userId, type, objId);
	}

	public boolean insertDataAuthBantch(String objId, String authType, String authId) {
		return commonDataService.insertDataAuthBantch(objId, authType, authId);
	}

	public boolean insertDataAuthForDept(String objId, String deptId) {
		return commonDataService.insertDataAuthForDept(objId, deptId);
	}

	public boolean deleteDataAuth(String objId, String authId) {
		return commonDataService.deleteDataAuth(objId, authId);
	}

	public boolean insertDataAuthBantch(String objId, String... deptIds) {
		return commonDataService.insertDataAuthBantch(objId, deptIds);
	}

	public boolean addCommonData(String userId, String type, String... objIds) {
		return commonDataService.addCommonData(userId, type, objIds);
	}

	public int insertDataAuthUserIds(String objId, String... authId) {
		return commonDataService.insertDataAuthUserIds(objId, authId);
	}

	public List<AuthDeptVo> getDeptParentTree(String userId) {
		String json = authMisService.selectParentDeptByUserId(userId);
		Gson gson = new Gson();
		List<AuthDeptVo> list = gson.fromJson(json, new TypeToken<List<AuthDeptVo>>() {
		}.getType());
		return list;
	}
}
