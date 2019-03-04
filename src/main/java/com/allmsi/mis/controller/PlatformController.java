package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.PlatformService;
import com.allmsi.sys.model.protocol.SuccessProtocol;

@Controller
@RequestMapping(value = "/platform")
public class PlatformController {

	@Resource
	private PlatformService platformService;
	
	@RequestMapping(value = "/list/select",method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(Integer page,Integer pageSize) {
		return new SuccessProtocol(platformService.selectList(page, pageSize));
	}
}
