package com.allmsi.mis.model.vo;

import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.po.Finance;

public class FinanceVo{
    private String id;

    private String projId;

    private String finTime;

    private String bizId;
    
    private List<String> contIds;

    private String detail;

    private String finUserId;

    private String finUserName;

    private String finUserDept;

    private String finUserDeptName;

    private String contTotalAmount;

    private String ourAmount;

    private String note;

    private String causeOf;

    private String increaseAmount;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private String finName;

    private String isFin;

    private String contDetail;

    private String partner;

    private String contractModel;
    
    private Integer draft;
    
    private String payType;
    
    private String payTypeName;
    
    private String finNo;
    
	public FinanceVo() {
    	
    }
    
    public FinanceVo(Finance Finance) {
		if(Finance != null) {
			this.id = Finance.getId();
			this.projId = Finance.getProjId();
			this.finTime = Finance.getFinTime();
			this.bizId = Finance.getBizId();
			this.detail = Finance.getDetail();
			this.finUserId = Finance.getFinUserId();
			this.finUserName = Finance.getFinUserName();
			this.finUserDept = Finance.getFinUserDept();
			this.finUserDeptName = Finance.getFinUserDeptName();
			this.contTotalAmount = String.valueOf(Finance.getContTotalAmount());
			this.ourAmount = String.valueOf(Finance.getOurAmount());
			this.note = Finance.getNote();
			this.causeOf = Finance.getCauseOf();
			this.increaseAmount = String.valueOf(Finance.getIncreaseAmount());
			this.cTime = Finance.getcTime();
			this.cUserId = Finance.getcUserId();
			this.uTime = Finance.getuTime();
			this.uUserId = Finance.getuUserId();
			this.payTypeName = Finance.getPayTypeName();
			this.finName = Finance.getFinName();
			this.isFin = String.valueOf(Finance.getIsFin());
			this.contDetail = Finance.getContDetail();
			this.partner = Finance.getPartner();
			this.contractModel = Finance.getContractModel();
			this.payTypeName = Finance.getPayTypeName();
			this.finNo = Finance.getFinNo();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

    public String getFinTime() {
		return finTime;
	}

	public void setFinTime(String finTime) {
		this.finTime = finTime;
	}

	public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getFinUserId() {
        return finUserId;
    }

    public void setFinUserId(String finUserId) {
        this.finUserId = finUserId == null ? null : finUserId.trim();
    }

    public String getFinUserName() {
        return finUserName;
    }

    public void setFinUserName(String finUserName) {
        this.finUserName = finUserName == null ? null : finUserName.trim();
    }

    public String getFinUserDept() {
        return finUserDept;
    }

    public void setFinUserDept(String finUserDept) {
        this.finUserDept = finUserDept == null ? null : finUserDept.trim();
    }

    public String getFinUserDeptName() {
        return finUserDeptName;
    }

    public void setFinUserDeptName(String finUserDeptName) {
        this.finUserDeptName = finUserDeptName == null ? null : finUserDeptName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getCauseOf() {
        return causeOf;
    }

    public void setCauseOf(String causeOf) {
        this.causeOf = causeOf == null ? null : causeOf.trim();
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
    
    public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getFinName() {
		return finName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}

	public String getContDetail() {
		return contDetail;
	}

	public void setContDetail(String contDetail) {
		this.contDetail = contDetail;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getContractModel() {
		return contractModel;
	}

	public void setContractModel(String contractModel) {
		this.contractModel = contractModel;
	}

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getContTotalAmount() {
		return contTotalAmount;
	}

	public void setContTotalAmount(String contTotalAmount) {
		this.contTotalAmount = contTotalAmount;
	}

	public String getOurAmount() {
		return ourAmount;
	}

	public void setOurAmount(String ourAmount) {
		this.ourAmount = ourAmount;
	}

	public String getIncreaseAmount() {
		return increaseAmount;
	}

	public void setIncreaseAmount(String increaseAmount) {
		this.increaseAmount = increaseAmount;
	}

	public String getIsFin() {
		return isFin;
	}

	public void setIsFin(String isFin) {
		this.isFin = isFin;
	}

	public List<String> getContIds() {
		return contIds;
	}

	public void setContIds(List<String> contIds) {
		this.contIds = contIds;
	}

	public String getFinNo() {
		return finNo;
	}

	public void setFinNo(String finNo) {
		this.finNo = finNo;
	}

}