package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.FlowModuleService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/flow/module")
public class FlowModuleController {

	@Resource
	private FlowModuleService flowModuleService;
	
	@RequestMapping(value = "/flowCode/select", method = RequestMethod.GET)
	@ResponseBody
	public Object flowCodeSelect(String module) {
		if(StrUtil.isEmpty(module)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol("",flowModuleService.selectFlowCode(module));
	}
}
