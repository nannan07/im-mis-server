package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.ProjectService;
import com.allmsi.sys.model.protocol.SuccessProtocol;

@Controller
@RequestMapping(value = "/proj")
public class ProjectController extends BaseController{
	
	@Resource
	private ProjectService projectService;
	
	/**
	 * 列表查询
	 * 
	 * @param page
	 * @param pageSize
	 * @param projName
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(@RequestHeader(AUTHORIZATION)String token,Integer page, Integer pageSize) {
		return new SuccessProtocol(projectService.selectProjList(token,page, pageSize));
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(String projId) {
		return new SuccessProtocol(projectService.selectByProjId(projId));
	}
	
	/**
	 * 列表查询
	 * 
	 * @param projId
	 * @return
	 */
	@RequestMapping(value = "/list/choose", method = RequestMethod.GET)
	@ResponseBody
	public Object listChoose() {
		return new SuccessProtocol(projectService.listChoose());
	}

}
