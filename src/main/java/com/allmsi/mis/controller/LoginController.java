package com.allmsi.mis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allmsi.mis.third.service.AuthMisService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.util.StrUtil;

@RestController
public class LoginController {

	@Autowired
	AuthMisService authLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(String loginName, String password) {
		if (StrUtil.notEmpty(loginName, password)) {
			Object object = authLoginService.login("mis", loginName, password);
			if (object == null) {
				return new SuccessProtocol("error");
			}
			return new SuccessProtocol("", object);
		} else {
			return new SuccessProtocol("error");
		}
	}

}
