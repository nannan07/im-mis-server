package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.model.vo.FlowModuleVo;
import com.allmsi.mis.model.vo.HomeTodoList;
import com.allmsi.mis.service.DataDeptService;
import com.allmsi.mis.service.FlowModuleService;
import com.allmsi.mis.service.HomeService;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.mis.third.model.vo.HomeVo;
import com.allmsi.mis.third.service.FlowMisService;
import com.allmsi.sys.model.ListBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service
public class HomeServiceImpl extends BaseServiceImpl implements HomeService {

	@Autowired
	private FlowMisService flowMisService;

	@Resource
	private FlowModuleService flowModuleService;

	@Resource
	private DataDeptService dataDeptService;

	@Override
	public Object home(String token) {
		Integer urgentLevel = urgentLevel(token);
		Integer todoCount = todoCount(token);
		Integer allCount = allCount(token);
		return new HomeVo(urgentLevel, todoCount, allCount, toall(token).getList());
	}

	@Override
	public Integer urgentLevel(String token) {
		String userId = getAuthUserId(token);
		return flowMisService.urgentLevel(userId);
	}

	@Override
	public Integer allCount(String token) {
		AuthUserVo user = getAuthUser(token);
		String deptId = getUserDeptInfo(user.getDeptIds(), user.getDeptNames()).getId();
		return dataDeptService.allCount(deptId);
	}

	@Override
	public ListBean toall(String token) {
		String userId = getAuthUserId(token);
		String json = flowMisService.toall(userId);
		System.out.println("json---"+json);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);
		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<HomeTodoList> list = gson.fromJson(jsonList, new TypeToken<List<HomeTodoList>>() {
		}.getType());
		Map<String, List<HomeTodoList>> map = new HashMap<String, List<HomeTodoList>>();
		List<String> flowCodeList = new ArrayList<String>();
		for (HomeTodoList homeVo : list) {
			List<HomeTodoList> aList = new ArrayList<HomeTodoList>();
			String key = homeVo.getFlowCode();
			if (map.containsKey(key)) {
				List<HomeTodoList> mapList = map.get(key);
				if (mapList != null && mapList.size() > 0) {
					aList.addAll(mapList);
				}
			} else {
				flowCodeList.add(key);
			}
			aList.add(homeVo);
			map.put(key, aList);
		}
		list = getHomeFlowCodeModule(map, flowCodeList);
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, list);
	}

	private List<HomeTodoList> getHomeFlowCodeModule(Map<String, List<HomeTodoList>> map, List<String> flowCodeList) {
		List<HomeTodoList> list = new ArrayList<HomeTodoList>();
		if (flowCodeList != null && flowCodeList.size() > 0) {
			List<FlowModuleVo> moduleList = flowModuleService.selectModuleByFlowCodes(flowCodeList);
			for (FlowModuleVo flowModuleVo : moduleList) {
				String flowCode = flowModuleVo.getFlowCode();
				String module = flowModuleVo.getModule();
				if (map.containsKey(flowCode)) {
					List<HomeTodoList> homeVoList = map.get(flowCode);
					if (homeVoList != null && homeVoList.size() > 0) {
						for (HomeTodoList homeVo : homeVoList) {
							homeVo.setModule(module);
							list.add(homeVo);
						}
					}
				}
			}
		}
		return list;
	}

	@Override
	public Integer todoCount(String token) {
		String userId = getAuthUserId(token);
		return flowMisService.todoCount(userId);
	}

}
