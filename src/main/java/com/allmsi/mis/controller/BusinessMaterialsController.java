package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.model.vo.BusinessMaterialsVo;
import com.allmsi.mis.service.BusinessMaterialsService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

/**
 * 项目物料表
 */
@Controller
@RequestMapping(value = "/biz/materials")
public class BusinessMaterialsController {

	@Resource
	private BusinessMaterialsService materialsService;

	@RequestMapping(value = "/list/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(Integer page, Integer pageSize, String bizId) {
		return new SuccessProtocol(materialsService.selectList(page, pageSize, bizId));
	}

	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(materialsService.selectById(id));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(BusinessMaterialsVo materialsVo) {
		String id = "";
		if (StrUtil.isEmpty(materialsVo.getId())) {
			id = materialsService.insertSelective(materialsVo);
		} else {
			id = materialsService.updateByPrimaryKeySelective(materialsVo);
		}
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol("",id);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(materialsService.deleteByPrimaryKey(id));
	}

	// @RequestMapping(value = "/insertBatch",method = RequestMethod.POST)
	// @ResponseBody
	// public Object insertList(BusinessMaterialsListVo businessMaterialsListVo) {
	// return new
	// SuccessProtocol(materialsService.insertList(businessMaterialsListVo));
	// }
}
