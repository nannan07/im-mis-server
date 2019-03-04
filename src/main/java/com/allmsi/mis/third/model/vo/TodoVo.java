package com.allmsi.mis.third.model.vo;

public class TodoVo {

	private String id;

	private String stateId;

	private String objId;

	private String objName;

	private String urgentLevel;

	private String objValue1;

	private String objValue2;

	private String objValue3;

	private String objValue4;

	private String objValue5;

	private String senderId;

	private String senderName;

	private String senderTime;
	
	private String createTime;

	private String handleName;
	private String handleDept;

	public TodoVo() {
	}

	public TodoVo(String objId, String objName, String urgentLevel, String objValue1, String objValue2,
			String objValue3, String objValue4, String objValue5) {
		this.objId = objId;
		this.objName = objName;
		this.urgentLevel = urgentLevel;
		this.objValue1 = objValue1;
		this.objValue2 = objValue2;
		this.objValue3 = objValue3;
		this.objValue4 = objValue4;
		this.objValue5 = objValue5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

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

	public String getObjValue1() {
		return objValue1;
	}

	public void setObjValue1(String objValue1) {
		this.objValue1 = objValue1;
	}

	public String getObjValue2() {
		return objValue2;
	}

	public void setObjValue2(String objValue2) {
		this.objValue2 = objValue2;
	}

	public String getObjValue3() {
		return objValue3;
	}

	public void setObjValue3(String objValue3) {
		this.objValue3 = objValue3;
	}

	public String getObjValue4() {
		return objValue4;
	}

	public void setObjValue4(String objValue4) {
		this.objValue4 = objValue4;
	}

	public String getObjValue5() {
		return objValue5;
	}

	public void setObjValue5(String objValue5) {
		this.objValue5 = objValue5;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderTime() {
		return senderTime;
	}

	public void setSenderTime(String senderTime) {
		this.senderTime = senderTime;
	}

	public String getHandleName() {
		return handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

	public String getHandleDept() {
		return handleDept;
	}

	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept;
	}

	public String getUrgentLevel() {
		return urgentLevel;
	}

	public void setUrgentLevel(String urgentLevel) {
		this.urgentLevel = urgentLevel;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
