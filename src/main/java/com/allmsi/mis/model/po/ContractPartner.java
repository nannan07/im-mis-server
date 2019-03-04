package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ContractPartnerVo;

public class ContractPartner {
    private String id;

    private String contId;

    private String partnerCompany;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private Integer del;


    public ContractPartner() {
    	
    }
    
    public ContractPartner(String id, String contId, String partnerCompany, String cUserId, String uUserId) {
		this.id = id;
		this.contId = contId;
		this.partnerCompany = partnerCompany;
		this.cUserId = cUserId;
		this.uUserId = uUserId;
	}



	public ContractPartner(ContractPartnerVo ContractPartnerVo) {
		if(ContractPartnerVo != null) {
			this.id = ContractPartnerVo.getId();
			this.contId = ContractPartnerVo.getContId();
			this.partnerCompany = ContractPartnerVo.getPartnerCompany();
			this.cTime = ContractPartnerVo.getcTime();
			this.cUserId = ContractPartnerVo.getcUserId();
			this.uTime = ContractPartnerVo.getuTime();
			this.uUserId = ContractPartnerVo.getuUserId();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}