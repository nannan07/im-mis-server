package com.allmsi.mis.model.vo;

import com.allmsi.mis.model.po.Payment;

public class PaymentVo extends FlowBaseVo{
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

    private String cUserId;

    private String uUserId;

    private String payWayName;
    
    private String payCompanyName;
    
    private String payName;
    
    private Integer isSingle;
    
    private String invoiceSituation;
    
    private String note;
    
    private Integer draft;
    
    private String contId;
    
    public PaymentVo() {
    	
    }
    
    public PaymentVo(Payment payment) {
		if(payment != null) {
			this.id = payment.getId();
			this.projId = payment.getProjId();
			this.finId = payment.getFinId();
			this.bizId = payment.getBizId();
			this.payDeptId = payment.getPayDeptId();
			this.payDeptName = payment.getPayDeptName();
			this.managerId = payment.getManagerId();
			this.managerName = payment.getManagerName();
			this.payCause = payment.getPayCause();
			this.payAmount = payment.getPayAmount();
			this.payWay = payment.getPayWay();
			this.payCompanyId = payment.getPayCompanyId();
			this.payDate = payment.getPayDate();
			this.isInvoice = payment.getIsInvoice();
			this.beneficiary = payment.getBeneficiary();
			this.accountBank = payment.getAccountBank();
			this.bankAccount = payment.getBankAccount();
			this.cUserId = payment.getcUserId();
			this.uUserId = payment.getuUserId();
			this.payCompanyName = payment.getPayCompanyName();
			this.payWayName = payment.getPayWayName();
			this.payName = payment.getPayName();
			this.isSingle = payment.getIsSingle();
			this.invoiceSituation = payment.getInvoiceSituation();
			this.note = payment.getNote();
			this.draft = payment.getDraft();
			this.contId = payment.getContId();
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
    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }
    public String getuUserId() {
        return uUserId;
    }

    public void setuUserId(String uUserId) {
        this.uUserId = uUserId == null ? null : uUserId.trim();
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

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}
	
}