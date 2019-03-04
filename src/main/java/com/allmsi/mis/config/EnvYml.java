package com.allmsi.mis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvYml {

	@Autowired
	private Environment env;

	public String getModuleAlias(String key) {
		return env.getProperty(key);
	}

}
