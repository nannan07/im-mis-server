package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.model.vo.BusGuideVo;
import com.allmsi.mis.service.MisFlowBusService;
import com.allmsi.mis.third.model.vo.SubmitGuidOVo;
import com.allmsi.sys.model.protocol.ErrorProtocol;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/flow")
public class MisBusController extends BaseController {

	@Resource
	private MisFlowBusService misFlowBusService;

	/**
	 * 获取节点后续路由
	 * 
	 * @param flowId
	 * @param nodeId
	 * @return
	 */
	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	@ResponseBody
	public Object guide(@RequestHeader(AUTHORIZATION) String token, String module, String instanceId, String nodeId,
			String isback, String routeId, String query) {
		BusGuideVo busGuideVo = misFlowBusService.guide(module, instanceId, nodeId, isback, routeId, query, token);

		String type = busGuideVo.getType();
		if (OperationMenu.ERROR.equals(type)) {
			return new ErrorProtocol("路由配置错误，请联系管理员");
		}
		if (OperationMenu.WARN.equals(type)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(busGuideVo);
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public Object submit(@RequestHeader(AUTHORIZATION) String token, String data) {
		JsonElement je = new JsonParser().parse(data);
		JsonElement module = je.getAsJsonObject().get("module");
		JsonElement flowInfo = je.getAsJsonObject().get("flowInfo");
		JsonElement moduleInfo = je.getAsJsonObject().get("moduleInfo");
		JsonElement nodeDealList = je.getAsJsonObject().get("nodeDealList");
		SubmitGuidOVo submitOVo = misFlowBusService.submit(token, module, flowInfo, moduleInfo, nodeDealList);
		String type = submitOVo.getType();
		if (OperationMenu.ERROR.equals(type)) {
			return new ErrorProtocol(submitOVo.getMsg());
		} else if (OperationMenu.WARN.equals(type)) {
			return new WarnProtocol(submitOVo.getMsg());
		}
		return new SuccessProtocol("", submitOVo.getData());
	}

}
