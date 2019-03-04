package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.DictService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping("/dict")
public class DictController {

	@Resource
	private DictService dictService;
	
	@RequestMapping(value = "/list/select",method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String dCode) {
		if(StrUtil.isEmpty(dCode)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(dictService.selectByName(dCode));
	}
}
