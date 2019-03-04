package com.allmsi.mis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.service.BusinessService;
import com.allmsi.mis.service.ContractService;
import com.allmsi.mis.service.FinanceService;
import com.allmsi.mis.service.FlowModuleService;
import com.allmsi.mis.service.MisTodoService;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.mis.third.model.vo.FlowDeptInstenceOVo;
import com.allmsi.mis.third.model.vo.FlowDoneOvo;
import com.allmsi.mis.third.model.vo.FlowSelfOVo;
import com.allmsi.mis.third.model.vo.TodoVo;
import com.allmsi.mis.third.service.FlowMisService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service
public class MisTodoServiceImpl extends BaseServiceImpl implements MisTodoService {

	@Resource
	private FlowModuleService flowModuleService;

	@Autowired
	private FlowMisService flowMisService;

	@Resource
	private BusinessService businessService;

	@Resource
	private ContractService contractService;

	@Resource
	private FinanceService financeService;

	@Resource
	private PaymentService paymentService;

	@Override
	public ListBean todoList(String token, String search, String module, Integer page, Integer pageSize) {
		String userId = getAuthUserId(token);
		String flowCode = flowModuleService.selectFlowCode(module);
		if (StrUtil.isEmpty(flowCode)) {
			return null;
		}
		String json = flowMisService.todoList(userId, search, flowCode, page, pageSize);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);

		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<TodoVo> udInfoList = gson.fromJson(jsonList, new TypeToken<List<TodoVo>>() {
		}.getType());
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, udInfoList);
	}

	@Override
	public ListBean doneList(String token, String search, String module, Integer page, Integer pageSize) {
		String userId = getAuthUserId(token);
		String flowCode = flowModuleService.selectFlowCode(module);
		if (StrUtil.isEmpty(flowCode)) {
			return null;
		}
		String json = flowMisService.doneList(userId, search, flowCode, page, pageSize);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);

		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<FlowDoneOvo> udInfoList = gson.fromJson(jsonList, new TypeToken<List<FlowDoneOvo>>() {
		}.getType());
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, udInfoList);
	}

	/**
	 * 我起草的
	 */
	@Override
	public ListBean self(String token, String search, String module, Integer page, Integer pageSize) {
		String userId = getAuthUserId(token);
		String flowCode = flowModuleService.selectFlowCode(module);
		if (StrUtil.isEmpty(flowCode)) {
			return null;
		}
		String json = flowMisService.self(userId, search, flowCode, page, pageSize);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);
		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<FlowSelfOVo> udInfoList = gson.fromJson(jsonList, new TypeToken<List<FlowSelfOVo>>() {
		}.getType());
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, udInfoList);
	}

	@Override
	public ListBean dept(String token,String search, String module, Integer page, Integer pageSize) {
		List<String> depts = getUserDepts(token);
		String flowCode = flowModuleService.selectFlowCode(module);
		if (StrUtil.isEmpty(flowCode)) {
			return null;
		}
		String json = flowMisService.dept(search,flowCode, page, pageSize, depts);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(json);
		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<FlowDeptInstenceOVo> udInfoList = gson.fromJson(jsonList, new TypeToken<List<FlowDeptInstenceOVo>>() {
		}.getType());
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, udInfoList);
	}

}