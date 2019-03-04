package com.allmsi.mis.service;

public interface DataUserService {

	public int insertSelective(String userId, String type, String... objIds);
}
