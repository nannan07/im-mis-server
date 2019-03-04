package com.allmsi.mis.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.allmsi.cache.CacheFactory;
import com.allmsi.cache.CacheInstence;
import com.allmsi.cache.CacheKeyPrefix;
import com.allmsi.mis.third.model.vo.AuthUserRoleVo;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.mis.third.service.AuthMisService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class CacheInstenceSubclass extends CacheInstence {

	@Autowired
	private AuthMisService authMisService;

	public CacheInstenceSubclass(CacheFactory cacheFactory) {
		super(cacheFactory);
	}

	public AuthUserVo getUser(String token) {
		String json = authMisService.selectUserInfoBytoken(token);
		Gson gson = new Gson();
		AuthUserVo user = gson.fromJson(json, AuthUserVo.class);
		return user;
	}

	public String getUserId(String token) {
		return getUser(token).getId();
	}

	@SuppressWarnings("unchecked")
	public boolean isVisit(String token, String resUrl) {
		String userId = getUserId(token);
		Set<String> values = new HashSet<String>();
		List<String> roleIds = new ArrayList<String>();
		Gson gson = new Gson();
		String json = authMisService.selectRoleListByUserId(userId);
		List<AuthUserRoleVo> udInfoList = gson.fromJson(json, new TypeToken<List<AuthUserRoleVo>>() {
		}.getType());
		for (AuthUserRoleVo authUserRoleVo : udInfoList) {
			roleIds.add(authUserRoleVo.getRoleId());
		}
		if (roleIds != null && roleIds.size() > 0) {
			for (String roleId : roleIds) {
				if (getObject((CacheKeyPrefix.RES.getValue() + roleId)) != null) {
					values.addAll((Set<String>) getObject(CacheKeyPrefix.RES.getValue() + roleId));
				}
			}
		}
		return (values.contains(resUrl)) ? true : true;
	}
}
