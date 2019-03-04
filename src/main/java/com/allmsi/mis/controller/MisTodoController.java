package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.service.MisTodoService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/flow")
public class MisTodoController extends BaseController {

	@Resource
	private MisTodoService misTodoService;

	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	@ResponseBody
	public Object todoList(@RequestHeader(AUTHORIZATION) String token, String search, String module, Integer page,
			Integer pageSize) {
		if (StrUtil.isEmpty(module) || StrUtil.isEmpty(token)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(misTodoService.todoList(token, search, module, page, pageSize));
	}

	@RequestMapping(value = "/done", method = RequestMethod.GET)
	@ResponseBody
	public Object doneList(@RequestHeader(AUTHORIZATION) String token, String search, String module, Integer page,
			Integer pageSize) {
		if (StrUtil.isEmpty(module) || StrUtil.isEmpty(token)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(misTodoService.doneList(token, search, module, page, pageSize));
	}

	@RequestMapping(value = "/self", method = RequestMethod.GET)
	@ResponseBody
	public Object self(@RequestHeader(AUTHORIZATION) String token, String search, String module, Integer page,
			Integer pageSize) {
		return new SuccessProtocol(misTodoService.self(token, search, module, page, pageSize));
	}

	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	@ResponseBody
	public Object dept(@RequestHeader(AUTHORIZATION) String token, String search, String module, Integer page,
			Integer pageSize) {
		return new SuccessProtocol(misTodoService.dept(token, search, module, page, pageSize));
	}
}
