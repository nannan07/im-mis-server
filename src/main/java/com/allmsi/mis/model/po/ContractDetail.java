package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ContractDetailVo;

public class ContractDetail {
    private String id;

    private String contId;

    private String contProectName;

    private String contProectDetail;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private Integer del;

    public ContractDetail() {
    	
    }
    
    public ContractDetail(ContractDetailVo contractDetailVo) {
    	if(contractDetailVo != null) {
    		this.id = contractDetailVo.getId();
    		this.contId = contractDetailVo.getContId();
    		this.contProectName = contractDetailVo.getContProectName();
    		this.contProectDetail = contractDetailVo.getContProectDetail();
    		this.cTime = contractDetailVo.getcTime();
    		this.cUserId = contractDetailVo.getcUserId();
    		this.uTime = contractDetailVo.getuTime();
    		this.uUserId = contractDetailVo.getuUserId();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}