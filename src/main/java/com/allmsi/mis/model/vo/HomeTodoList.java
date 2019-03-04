package com.allmsi.mis.model.vo;

public class HomeTodoList {
	
	private String id;

//	private String stateId;
	
	private String urgentLevel;
	
	private String objValue1;
	
	private String module;

	private String objId;

	private String objName;

	private String uTime;

	private String flowCode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getStateId() {
//		return stateId;
//	}
//
//	public void setStateId(String stateId) {
//		this.stateId = stateId;
//	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getUrgentLevel() {
		return urgentLevel;
	}

	public void setUrgentLevel(String urgentLevel) {
		this.urgentLevel = urgentLevel;
	}

	public String getObjValue1() {
		return objValue1;
	}

	public void setObjValue1(String objValue1) {
		this.objValue1 = objValue1;
	}

	public String getuTime() {
		return uTime;
	}

	public void setuTime(String uTime) {
		this.uTime = uTime;
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
