package com.allmsi.mis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmsi.mis.config.FlowCodeModuleMapping;
import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.controller.BusinessController;
import com.allmsi.mis.controller.ContractController;
import com.allmsi.mis.controller.FinanceController;
import com.allmsi.mis.controller.PaymentController;
import com.allmsi.mis.dao.ProjectMapper;
import com.allmsi.mis.model.po.Project;
import com.allmsi.mis.model.vo.BusGuideVo;
import com.allmsi.mis.model.vo.BusinessVo;
import com.allmsi.mis.model.vo.ContractVo;
import com.allmsi.mis.model.vo.FinanceVo;
import com.allmsi.mis.model.vo.PaymentVo;
import com.allmsi.mis.service.BusinessService;
import com.allmsi.mis.service.ContractService;
import com.allmsi.mis.service.FinanceService;
import com.allmsi.mis.service.FlowModuleService;
import com.allmsi.mis.service.MisFlowBusService;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.mis.third.model.vo.BusGuide;
import com.allmsi.mis.third.model.vo.FlowInstanceOVo;
import com.allmsi.mis.third.model.vo.FlowInstenceCurrencyOVO;
import com.allmsi.mis.third.model.vo.NodeDealVo;
import com.allmsi.mis.third.model.vo.SubmitGuidOVo;
import com.allmsi.mis.third.model.vo.TodoVo;
import com.allmsi.mis.third.service.FlowMisService;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Service
public class MisFlowBusServiceImpl extends BaseServiceImpl implements MisFlowBusService {

	@Autowired
	private FlowMisService flowMisService;

	@Resource
	private QueryEngine queryEngine;

	@Resource
	private FlowModuleService flowModuleService;

	@Resource
	private BusinessController businessController;

	@Resource
	private ContractController contractController;

	@Resource
	private FinanceController financeController;

	@Resource
	private PaymentController paymentController;

	@Resource
	private ProjectMapper projectDao;

	@Resource
	private BusinessService businessService;

	@Resource
	private ContractService contractService;

	@Resource
	private FinanceService financeService;

	@Resource
	private PaymentService paymentService;

	@Override
	public BusGuideVo guide(String module, String instanceId, String nodeId, String isback, String routeId,
			String query, String token) {
		BusGuideVo guideVo = new BusGuideVo();
		if (StrUtil.isEmpty(module)) {
			guideVo.setType(OperationMenu.WARN);
			return guideVo;
		}
		String flowCode = flowModuleService.selectFlowCode(module);
		if (StrUtil.isEmpty(flowCode)) {
			guideVo.setType(OperationMenu.WARN);
			return guideVo;
		}
		String objId = "";
		if (StrUtil.notEmpty(instanceId)) {
			String json = flowMisService.selectById(instanceId);
			Gson gson = new Gson();
			FlowInstanceOVo flowInstance = gson.fromJson(json, FlowInstanceOVo.class);
			if (flowInstance != null) {
				objId = flowInstance.getObjectId();
			}
		}
		String userId = getAuthUserId(token);
		String json = flowMisService.guide(flowCode, instanceId, nodeId, isback, routeId, query, userId);
		System.out.println("json---" + json);
		Gson gson = new Gson();
		BusGuide busGuide = gson.fromJson(json, BusGuide.class);
		if (busGuide == null) {
			guideVo.setType(OperationMenu.WARN);
			return guideVo;
		}
		String type = busGuide.getType();
		switch (type) {
		case OperationMenu.ERROR:
			guideVo.setType(OperationMenu.ERROR);
			guideVo.setMsg(busGuide.getMsg());
			break;
		case OperationMenu.QUERY:
			String routeQuery = busGuide.getMsg();
			String q = queryEngine.getQuery(module, routeQuery, objId);
			guideVo = guide(module, instanceId, nodeId, isback, routeId, q, userId);
			break;
		case OperationMenu.USER:
			guideVo.setType(OperationMenu.USER);
			guideVo.setFlowUserList(busGuide.getFlowUserList());
			guideVo.setFlowRouteList(busGuide.getFlowRouteList());
			break;
		case OperationMenu.ROUTE:
			guideVo.setType(OperationMenu.ROUTE);
			guideVo.setFlowRouteList(busGuide.getFlowRouteList());
			break;
		case OperationMenu.MULTI_PERSON_HANDLING:
			guideVo.setType(OperationMenu.MULTI_PERSON_HANDLING);
			guideVo.setFlowUserList(busGuide.getFlowUserList());
			break;
		}
		return guideVo;
	}

	@Override
	public SubmitGuidOVo submit(String token, JsonElement module, JsonElement flowInfo, JsonElement moduleInfo,
			JsonElement nodeDealList) {
		AuthUserVo user = getAuthUser(token);
		String userId = user.getId();
		Gson gson = new Gson();
		FlowInstenceCurrencyOVO flowInfoVo = gson.fromJson(flowInfo, FlowInstenceCurrencyOVO.class);
		String moduleFlag = gson.fromJson(module, String.class);
		List<NodeDealVo> ndList = gson.fromJson(nodeDealList, new TypeToken<List<NodeDealVo>>() {
		}.getType());
		String flowId = flowInfoVo.getFlowId();
		String instanceId = flowInfoVo.getInstanceId();
		String preNodeId = flowInfoVo.getPreNodeId();
		String sufNodeId = flowInfoVo.getSufNodeId();
		String remark = flowInfoVo.getRemark();
		String routeId = flowInfoVo.getRouteId();
		if ((StrUtil.isEmpty(flowId) && StrUtil.isEmpty(instanceId))
				|| (StrUtil.isEmpty(instanceId) && moduleInfo == null)) {
			return new SubmitGuidOVo(OperationMenu.WARN, OperationMenu.PARAMETER_MSG);
		}
		String urgentLevel = flowInfoVo.getUrgentLevel();

		TodoVo flowTodoVo = new TodoVo();
		if (moduleInfo != null) {
			// 添加todo信息，根据不同的业务模块
			flowTodoVo = getFlowToDoInfoVo(moduleFlag, urgentLevel, moduleInfo);
			if (flowTodoVo == null) {
				return new SubmitGuidOVo(OperationMenu.WARN, "参数不合法");
			}
		}
		// 添加流程
		SubmitGuidOVo submitOVo = submitFlow(flowId, instanceId, preNodeId, sufNodeId, userId, remark, routeId, ndList,
				flowTodoVo);
		if (submitOVo == null) {
			return new SubmitGuidOVo(OperationMenu.ERROR, "");
		}
		System.out.println("type---" + submitOVo.getType());
		if (moduleInfo != null) {
			if (OperationMenu.SUCCESS.equals(submitOVo.getType())) { // 添加业务
				String msg = addModuleInfo(token, moduleInfo, moduleFlag, submitOVo);
				return new SubmitGuidOVo(OperationMenu.SUCCESS, "", msg);
			} else {
				return submitOVo;
			}
		}
		if (OperationMenu.SUCCESS.equals(submitOVo.getType())) { // 添加业务
			boolean isFinish = submitOVo.isFlag();
			String objId = (String) submitOVo.getData();
			if (isFinish) {// 流程结束
				successFul(token, moduleFlag, objId);
			}
		}
		return submitOVo;
	}

	private void successFul(String token, String moduleFlag, String objId) {
		if (StrUtil.notEmpty(moduleFlag, objId)) {
			switch (moduleFlag) {
			case FlowCodeModuleMapping.MODEL_BIZ:// 业务系统
				businessService.successful(token, objId);
				break;
			case FlowCodeModuleMapping.MODEL_CONT:// 合同系统
				contractService.successful(objId);
				break;
			case FlowCodeModuleMapping.MODEL_FIN:// 财务系统
				financeService.successful(objId);
				break;
			case FlowCodeModuleMapping.MODEL_PAY:// 付款系统
				paymentService.successful(objId);
				break;
			}
		}
	}

	private String addModuleInfo(String token, JsonElement moduleInfo, String moduleFlag, SubmitGuidOVo submitOVo) {
		Gson gson = new Gson();
		String type = submitOVo.getType();
		String msg = null;
		if (OperationMenu.SUCCESS.equals(type)) {// 流程添加成功
			String objId = (String) submitOVo.getData();
			switch (moduleFlag) {
			case FlowCodeModuleMapping.MODEL_BIZ:// 业务系统
				BusinessVo businessVo = gson.fromJson(moduleInfo, BusinessVo.class);
				businessVo.setId(objId);
				msg = businessController.submit(token, businessVo, OperationMenu.SUBMIT);
				break;
			case FlowCodeModuleMapping.MODEL_CONT:// 合同系统
				ContractVo contractVo = gson.fromJson(moduleInfo, ContractVo.class);
				contractVo.setId(objId);
				msg = contractController.submit(token, contractVo, OperationMenu.SUBMIT);
				break;
			case FlowCodeModuleMapping.MODEL_FIN:// 财务系统
				FinanceVo financeVo = gson.fromJson(moduleInfo, FinanceVo.class);
				financeVo.setId(objId);
				msg = financeController.submit(token, financeVo, OperationMenu.SUBMIT);
				break;
			case FlowCodeModuleMapping.MODEL_PAY:// 付款系统
				PaymentVo paymentVo = gson.fromJson(moduleInfo, PaymentVo.class);
				paymentVo.setId(objId);
				msg = paymentController.submit(token, paymentVo, OperationMenu.SUBMIT);
				System.out.println("pay---"+msg);
			default:
				break;
			}
		}
		return msg;
	}

	private TodoVo getFlowToDoInfoVo(String module, String urgentLevel, JsonElement moduleInfo) {
		String objId = "";
		String objName = "";
		String projectLevel = "";
		Gson gson = new Gson();
		TodoVo flowTodoVo = null;
		String checkParam = null;
		switch (module) {
		case FlowCodeModuleMapping.MODEL_BIZ:// 业务系统
			BusinessVo businessVo = gson.fromJson(moduleInfo, BusinessVo.class);
			if (businessVo != null) {
				objId = businessVo.getId();
				if (StrUtil.notEmpty(objId)) {// 不为空时，流程流转中
					BusinessVo vo = businessService.selectByPrimaryKey(objId);
					objName = vo.getProjName();
					projectLevel = vo.getEstimatedRatingName();
					checkParam = OperationMenu.SUCCESS;
				} else {// 首次提交流程
					objName = businessVo.getProjName();
					projectLevel = businessVo.getEstimatedRatingName();
					checkParam = businessController.checkParam(businessVo);
				}
				flowTodoVo = new TodoVo(objId, objName, urgentLevel, projectLevel, "", "", "", "");
			}
			break;
		case FlowCodeModuleMapping.MODEL_CONT:// 合同系统
			ContractVo contractVo = gson.fromJson(moduleInfo, ContractVo.class);
			if (contractVo != null) {
				objId = contractVo.getId();
				if (StrUtil.notEmpty(contractVo.getProjId())) {
					Project proj = projectDao.selectByPrimaryKey(contractVo.getProjId());
					if (proj != null) {
						projectLevel = proj.getEstimatedRatingName();
					}
				}
				if (StrUtil.notEmpty(objId)) {// 不为空时，流程流转中
					ContractVo vo = contractService.selectByPrimaryKey(objId);
					objName = vo.getProjName();
					checkParam = OperationMenu.SUCCESS;
				} else {// 首次提交流程
					objName = contractVo.getContTitle();
					checkParam = contractController.checkParam(contractVo);
				}
				String totalAmount = contractVo.getTotalAmount();
				flowTodoVo = new TodoVo(objId, objName, urgentLevel, projectLevel, totalAmount, "", "", "");
			}
			break;
		case FlowCodeModuleMapping.MODEL_FIN:// 财务系统
			FinanceVo financeVo = gson.fromJson(moduleInfo, FinanceVo.class);
			if (financeVo != null) {
				objId = financeVo.getId();
				String projName = "";
				if (StrUtil.notEmpty(financeVo.getProjId())) {
					Project proj = projectDao.selectByPrimaryKey(financeVo.getProjId());
					if (proj != null) {
						projectLevel = proj.getEstimatedRatingName();
						projName = proj.getPayName();
					}
				}
				if (StrUtil.notEmpty(objId)) {// 不为空时，流程流转中
					FinanceVo vo = financeService.selectByPrimaryKey(objId);
					objName = vo.getFinName();
					checkParam = OperationMenu.SUCCESS;
				} else {// 首次提交流程
					objName = financeVo.getFinName();
					checkParam = financeController.checkParam(financeVo);
				}
				flowTodoVo = new TodoVo(objId, objName, urgentLevel, projectLevel, projName, "", "", "");
			}
			break;
		case FlowCodeModuleMapping.MODEL_PAY:// 付款系统
			PaymentVo paymentVo = gson.fromJson(moduleInfo, PaymentVo.class);
			if (paymentVo != null) {
				objId = paymentVo.getId();
				String projName = "";
				if (StrUtil.notEmpty(paymentVo.getProjId())) {
					Project proj = projectDao.selectByPrimaryKey(paymentVo.getProjId());
					if (proj != null) {
						projectLevel = proj.getEstimatedRatingName();
						projName = proj.getProjName();
					}
				}
				if (StrUtil.notEmpty(objId)) {// 不为空时，流程流转中
					PaymentVo vo = paymentService.selectByPrimaryKey(objId);
					objName = vo.getPayName();
					checkParam = OperationMenu.SUCCESS;
				} else {// 首次提交流程
					objName = paymentVo.getPayName();
					checkParam = paymentController.checkParam(paymentVo);
				}
				flowTodoVo = new TodoVo(objId, objName, urgentLevel, projectLevel, projName, "", "", "");
			}
			break;
		}
		if (OperationMenu.SUCCESS.equals(checkParam)) {
			if (StrUtil.isEmpty(objId)) {
				objId = UUIDUtil.getUUID();
			}
		} else {
			return null;
		}
		flowTodoVo.setObjId(objId);
		return flowTodoVo;
	}
}
