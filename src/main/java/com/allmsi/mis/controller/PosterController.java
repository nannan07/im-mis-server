package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.PosterService;
import com.allmsi.sys.model.protocol.SuccessProtocol;

@Controller
@RequestMapping(value = "/poster")
public class PosterController {

	@Resource
	private PosterService posterService;
	
	@RequestMapping(value = "/list/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect() {
		return new SuccessProtocol(posterService.selectPosterList());
	}
}
