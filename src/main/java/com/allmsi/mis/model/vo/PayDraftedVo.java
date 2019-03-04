package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Payment;

public class PayDraftedVo extends PaymentBaseVo {

	private Date cTime;

	public PayDraftedVo() {

	}

	public PayDraftedVo(Payment pay) {
		if (pay != null) {
			this.id = pay.getId();
			this.payName = pay.getPayName();
			this.payAmount = pay.getPayAmount();
			this.cTime = pay.getcTime();
		}
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
}
