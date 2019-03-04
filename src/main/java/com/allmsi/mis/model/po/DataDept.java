package com.allmsi.mis.model.po;

public class DataDept {
	private String id;

	private String objId;

	private String deptId;

	public DataDept() {

	}

	public DataDept(String id, String objId, String deptId) {
		this.id = id;
		this.objId = objId;
		this.deptId = deptId;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId == null ? null : deptId.trim();
	}
}