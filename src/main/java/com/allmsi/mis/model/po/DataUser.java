package com.allmsi.mis.model.po;

import java.util.Date;

public class DataUser {
	private String id;

	private String objId;

	private String userId;

	private Date time;

	private String type;

	public DataUser() {
	}

	public DataUser(String id, String objId, String userId, String type) {
		this.id = id;
		this.objId = objId;
		this.userId = userId;
		this.type = type;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
}