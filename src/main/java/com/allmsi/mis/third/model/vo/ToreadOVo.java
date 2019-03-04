package com.allmsi.mis.third.model.vo;

public class ToreadOVo {
    private String id;

    private String stateId;

    private String objId;

    private String objName;

    private String objValue1;

    private String objValue2;

    private String objValue3;

    private String objValue4;

    private String objValue5;

    private String senderId;
    
    private String senderName;
    
    private String senderTime;

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId == null ? null : stateId.trim();
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
    }

    public String getObjValue1() {
        return objValue1;
    }

    public void setObjValue1(String objValue1) {
        this.objValue1 = objValue1 == null ? null : objValue1.trim();
    }

    public String getObjValue2() {
        return objValue2;
    }

    public void setObjValue2(String objValue2) {
        this.objValue2 = objValue2 == null ? null : objValue2.trim();
    }

    public String getObjValue3() {
        return objValue3;
    }

    public void setObjValue3(String objValue3) {
        this.objValue3 = objValue3 == null ? null : objValue3.trim();
    }

    public String getObjValue4() {
        return objValue4;
    }

    public void setObjValue4(String objValue4) {
        this.objValue4 = objValue4 == null ? null : objValue4.trim();
    }

    public String getObjValue5() {
        return objValue5;
    }

    public void setObjValue5(String objValue5) {
        this.objValue5 = objValue5 == null ? null : objValue5.trim();
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
    
}