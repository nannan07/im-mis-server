package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.FinanceRelated;

public class FinanceRelatedVo {
    private String id;

    private String finId;

    private String projId;

    private String payType;

    private Integer payAmount;

    private Date payTime;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    public FinanceRelatedVo() {
    	
    }
    
    public FinanceRelatedVo(FinanceRelated Related) {
		if(Related != null) {
			this.id = Related.getId();
			this.finId = Related.getFinId();
			this.projId = Related.getProjId();
			this.payType = Related.getPayType();
			this.payAmount = Related.getPayAmount();
			this.payTime = Related.getPayTime();
			this.cTime = Related.getcTime();
			this.cUserId = Related.getcUserId();
			this.uTime = Related.getuTime();
			this.uUserId = Related.getcUserId();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFinId() {
        return finId;
    }

    public void setFinId(String finId) {
        this.finId = finId == null ? null : finId.trim();
    }

    public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public String getuUserId() {
        return uUserId;
    }

    public void setuUserId(String uUserId) {
        this.uUserId = uUserId;
    }
}