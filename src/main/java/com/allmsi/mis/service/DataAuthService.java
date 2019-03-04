package com.allmsi.mis.service;

public interface DataAuthService {

	public int insertDataAuthBantch(String objId, String authType, String authId);
	
	public int insertDataAuthUserIds(String objId, String... authId);
	
	public int insertDataAuthForDept(String objId, String deptId);
	
	public int deleteDataAuth(String objId, String authId);

	public boolean isHaveAuth(String objId, String userId);

}
