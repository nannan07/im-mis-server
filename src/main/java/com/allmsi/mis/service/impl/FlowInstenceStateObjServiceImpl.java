package com.allmsi.mis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.config.FlowCodeModuleMapping;
import com.allmsi.mis.config.GeneralFlowModule;
import com.allmsi.mis.model.vo.FlowStateLogVo;
import com.allmsi.mis.service.BusinessService;
import com.allmsi.mis.service.ContractService;
import com.allmsi.mis.service.FinanceService;
import com.allmsi.mis.service.FlowInstenceStateObjService;
import com.allmsi.mis.service.FlowModuleService;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.mis.third.model.vo.FlowInstenceCurrencyOVO;
import com.allmsi.mis.third.service.FlowMisService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service
public class FlowInstenceStateObjServiceImpl extends BaseServiceImpl implements FlowInstenceStateObjService {

	@Autowired
	private FlowMisService flowMisService;

	@Resource
	private FlowModuleService flowModuleService;

	@Resource
	private BusinessService businessService;

	@Resource
	private ContractService contractService;

	@Resource
	private FinanceService financeService;

	@Resource
	private PaymentService paymentService;

	@Override
	public GeneralFlowModule flowInstenceStateInfo(String token, String objId,String module) {
		GeneralFlowModule generalFlowModule = new GeneralFlowModule();
		String userId = getAuthUserId(token);
		String flowJson = flowMisService.flowInstenceStateInfo(objId, userId);
		System.out.println("flowJson----"+flowJson);
		Gson gson = new Gson();
		FlowInstenceCurrencyOVO flowInfo = gson.fromJson(flowJson, FlowInstenceCurrencyOVO.class);
		generalFlowModule.setFlowInfo(flowInfo);

		String flowCode = flowInfo.getFlowCode();
		String  flowModule = flowModuleService.selectModule(flowCode);
		Object moduleInfo = null;
		if (StrUtil.isEmpty(flowModule)) {
			if(StrUtil.isEmpty(module)) {
				return generalFlowModule;
			}
			flowModule = module;
		}
		generalFlowModule.setModule(flowModule);

		switch (flowModule) {
		case FlowCodeModuleMapping.MODEL_BIZ:// 业务系统
			moduleInfo = businessService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_CONT:// 合同系统
			moduleInfo = contractService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_FIN:// 财务系统
			moduleInfo = financeService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_PAY:// 付款系统
			moduleInfo = paymentService.selectByPrimaryKey(objId);
			break;
		default:
			break;
		}
		generalFlowModule.setModuleInfo(moduleInfo);
		return generalFlowModule;
	}

	@Override
	public Object flowInstenceStatelog(String instanceId,Integer page,Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = Integer.MAX_VALUE;
		}
		String logJson = flowMisService.log(instanceId, page, pageSize);
		Gson gson = new Gson();
		JsonElement je = new JsonParser().parse(logJson);

		JsonElement totals = je.getAsJsonObject().get("total");
		JsonElement jsonList = je.getAsJsonObject().get("list");
		List<FlowStateLogVo> logList = gson.fromJson(jsonList, new TypeToken<List<FlowStateLogVo>>() {
		}.getType());
		int total = gson.fromJson(totals, Integer.class);
		return new ListBean(total, logList);
	}

}
