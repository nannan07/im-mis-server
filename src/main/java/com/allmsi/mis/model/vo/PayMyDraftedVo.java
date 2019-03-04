package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Payment;

public class PayMyDraftedVo extends PaymentBaseVo {

	private Date cTime;//申请时间

	private String payDeptId;

	private String payDeptName;
	
	private String currentLink;//当前环节
	
	private String auditor;//审核人
	

	public PayMyDraftedVo() {

	}

	public PayMyDraftedVo(Payment pay) {
		if (pay != null) {
			this.id = pay.getId();
			this.payName = pay.getPayName();
			this.payDeptId = pay.getPayDeptId();
			this.payDeptName = pay.getPayDeptName();
			this.payAmount = pay.getPayAmount();
			this.cTime = pay.getcTime();
			//当前环节
			
			//审核人
		}
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getPayDeptId() {
		return payDeptId;
	}

	public void setPayDeptId(String payDeptId) {
		this.payDeptId = payDeptId;
	}

	public String getPayDeptName() {
		return payDeptName;
	}

	public void setPayDeptName(String payDeptName) {
		this.payDeptName = payDeptName;
	}

	public String getCurrentLink() {
		return currentLink;
	}

	public void setCurrentLink(String currentLink) {
		this.currentLink = currentLink;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
}
