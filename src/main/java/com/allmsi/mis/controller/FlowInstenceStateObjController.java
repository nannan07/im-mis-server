package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.FlowInstenceStateObjService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/flowInstance/state")
public class FlowInstenceStateObjController extends BaseController{
	
	@Resource
	private FlowInstenceStateObjService flowInstenceStateObjService;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object flowInstenceStateInfo(@RequestHeader(AUTHORIZATION) String token,String objId,String module) {
		if(StrUtil.isEmpty(objId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(flowInstenceStateObjService.flowInstenceStateInfo(token,objId,module));
	}

	
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	@ResponseBody
	public Object flowInstenceStatelog(@RequestHeader(AUTHORIZATION) String token,String instanceId,Integer page,Integer pageSize) {
		System.out.println("instanceId---"+instanceId);
		if(StrUtil.isEmpty(instanceId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(flowInstenceStateObjService.flowInstenceStatelog(instanceId,page,pageSize));
	}
}
