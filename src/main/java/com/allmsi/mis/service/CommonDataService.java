package com.allmsi.mis.service;

public interface CommonDataService {

	public boolean insertDataUser(String userId, String type, String... objId);

	public boolean insertDataAuthBantch(String objId, String authType, String authId);

	public boolean insertDataAuthForDept(String objId, String deptId);

	public boolean deleteDataAuth(String objId, String authId);
	
	public boolean insertDataAuthBantch(String objId, String... deptIds);

	public boolean addCommonData(String userId, String type, String... objIds);

	public int insertDataAuthUserIds(String objId, String[] authId);
}
