package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.ContractDetail;

public class ContractDetailVo {
    private String id;

    private String contId;

    private String contProectName;

    private String contProectDetail;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    public ContractDetailVo() {
    	
    }
    
    public ContractDetailVo(ContractDetail contractDetail) {
    	if(contractDetail != null) {
    		this.id = contractDetail.getId();
    		this.contId = contractDetail.getContId();
    		this.contProectName = contractDetail.getContProectName();
    		this.contProectDetail = contractDetail.getContProectDetail();
    		this.cTime = contractDetail.getcTime();
    		this.cUserId = contractDetail.getcUserId();
    		this.uTime = contractDetail.getuTime();
    		this.uUserId = contractDetail.getuUserId();
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

	public String getContProectName() {
		return contProectName;
	}

	public void setContProectName(String contProectName) {
		this.contProectName = contProectName;
	}

	public String getContProectDetail() {
		return contProectDetail;
	}

	public void setContProectDetail(String contProectDetail) {
		this.contProectDetail = contProectDetail;
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