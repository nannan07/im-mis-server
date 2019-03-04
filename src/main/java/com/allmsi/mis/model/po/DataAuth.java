package com.allmsi.mis.model.po;

public class DataAuth {
	private String id;

	private String objId;

	private String authId;

	private String authType;

	public DataAuth() {

	}

	public DataAuth(String id, String objId, String authId, String authType) {
		this.id = id;
		this.objId = objId;
		this.authId = authId;
		this.authType = authType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId == null ? null : objId.trim();
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId == null ? null : authId.trim();
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType == null ? null : authType.trim();
	}
}