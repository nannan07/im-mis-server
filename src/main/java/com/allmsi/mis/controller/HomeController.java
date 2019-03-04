package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.HomeService;
import com.allmsi.sys.model.protocol.SuccessProtocol;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController{
	
	@Resource
	private HomeService homeService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Object home(@RequestHeader(AUTHORIZATION) String token) {
		return new SuccessProtocol("",homeService.home(token));
	}
}
