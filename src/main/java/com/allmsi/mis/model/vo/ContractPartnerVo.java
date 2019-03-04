package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.ContractPartner;

public class ContractPartnerVo {
    private String id;

    private String contId;

    private String partnerCompany;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    public ContractPartnerVo() {
    	
    }
    
    public ContractPartnerVo(ContractPartner ContractPartner) {
		if(ContractPartner != null) {
			this.id = ContractPartner.getId();
			this.contId = ContractPartner.getContId();
			this.partnerCompany = ContractPartner.getPartnerCompany();
			this.cTime = ContractPartner.getcTime();
			this.cUserId = ContractPartner.getcUserId();
			this.uTime = ContractPartner.getuTime();
			this.uUserId = ContractPartner.getuUserId();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}

	public String getPartnerCompany() {
        return partnerCompany;
    }

    public void setPartnerCompany(String partnerCompany) {
        this.partnerCompany = partnerCompany == null ? null : partnerCompany.trim();
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
        this.cUserId = cUserId == null ? null : cUserId.trim();
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
        this.uUserId = uUserId == null ? null : uUserId.trim();
    }

}