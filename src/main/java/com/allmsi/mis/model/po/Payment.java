package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.PaymentVo;

public class Payment {
    private String id;

    private String projId;

    private String finId;

    private String bizId;

    private String payDeptId;

    private String payDeptName;

    private String managerId;

    private String managerName;

    private String payCause;

    private Integer payAmount;

    private String payWay;

    private String payCompanyId;

    private String payDate;

    private Integer isInvoice;

    private String beneficiary;

    private String accountBank;

    private String bankAccount;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;
    
    private Integer draft;

    private Integer del;

    private String payWayName;
    
    private String payCompanyName;
    
    private String payName;
    
    private Integer isSingle;
    
    private String invoiceSituation;
    
    private String note;
    
    private String contId;
    
    public Payment() {
    	
    }
    
    public Payment(PaymentVo paymentVo) {
		if(paymentVo != null) {
			this.id = paymentVo.getId();
			this.projId = paymentVo.getProjId();
			this.finId = paymentVo.getFinId();
			this.bizId = paymentVo.getBizId();
			this.payDeptId = paymentVo.getPayDeptId();
			this.payDeptName = paymentVo.getPayDeptName();
			this.managerId = paymentVo.getManagerId();
			this.managerName = paymentVo.getManagerName();
			this.payCause = paymentVo.getPayCause();
			this.payAmount = paymentVo.getPayAmount();
			this.payWay = paymentVo.getPayWay();
			this.payCompanyId = paymentVo.getPayCompanyId();
			this.payDate = paymentVo.getPayDate();
			this.isInvoice = paymentVo.getIsInvoice();
			this.beneficiary = paymentVo.getBeneficiary();
			this.accountBank = paymentVo.getAccountBank();
			this.bankAccount = paymentVo.getBankAccount();
			this.cUserId = paymentVo.getcUserId();
			this.uUserId = paymentVo.getuUserId();
			this.payCompanyName = paymentVo.getPayCompanyName();
			this.payWayName = paymentVo.getPayWayName();
			this.payName = paymentVo.getPayName();
			this.isSingle = paymentVo.getIsSingle();
			this.invoiceSituation = paymentVo.getInvoiceSituation();
			this.note = paymentVo.getNote();
			this.draft = paymentVo.getDraft();
			this.contId = paymentVo.getContId();
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

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getPayDeptId() {
        return payDeptId;
    }

    public void setPayDeptId(String payDeptId) {
        this.payDeptId = payDeptId == null ? null : payDeptId.trim();
    }

    public String getPayDeptName() {
        return payDeptName;
    }

    public void setPayDeptName(String payDeptName) {
        this.payDeptName = payDeptName == null ? null : payDeptName.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getPayCause() {
        return payCause;
    }

    public void setPayCause(String payCause) {
        this.payCause = payCause == null ? null : payCause.trim();
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPayCompanyId() {
        return payCompanyId;
    }

    public void setPayCompanyId(String payCompanyId) {
        this.payCompanyId = payCompanyId == null ? null : payCompanyId.trim();
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Integer getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary == null ? null : beneficiary.trim();
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank == null ? null : accountBank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
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

    public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}

	public String getPayCompanyName() {
		return payCompanyName;
	}

	public void setPayCompanyName(String payCompanyName) {
		this.payCompanyName = payCompanyName;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public Integer getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}

	public String getInvoiceSituation() {
		return invoiceSituation;
	}

	public void setInvoiceSituation(String invoiceSituation) {
		this.invoiceSituation = invoiceSituation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}
    
}