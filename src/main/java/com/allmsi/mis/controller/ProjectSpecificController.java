package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.service.ProjectSpecificService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

/**
 * 项目进度
 * 
 * @author sunnannan
 *
 */
@Controller
@RequestMapping(value = "/projSpec")
public class ProjectSpecificController extends BaseController{

	@Resource
	private ProjectSpecificService projectSpecificService;

	@RequestMapping(value = "/list/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(@RequestHeader(AUTHORIZATION)String token,Integer page, Integer pageSize) {
		return new SuccessProtocol(projectSpecificService.selectProjectSpecificList(token,page, pageSize));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveProjectSpecific(ProjectSpecificVo projectSpecificVo) {
		if (projectSpecificVo == null || StrUtil.isEmpty(projectSpecificVo.getProjId())) {
			return new WarnProtocol();
		}
		return new SuccessProtocol("",projectSpecificService.saveProjectSpecific(projectSpecificVo));
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object delProjectSpecific(String projId) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(projectSpecificService.delProjectSpecific(projId));
	}

}
