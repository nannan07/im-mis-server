package com.allmsi.mis.third.model.vo;

public class FlowUserModel {

	private String userId;

	private String name;

	private String type;

	// 用户部门
	private String deptId;

	private String deptName;

	public FlowUserModel() {

	}

	public FlowUserModel(String userId, String name, String type) {
		this.userId = userId;
		this.name = name;
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
