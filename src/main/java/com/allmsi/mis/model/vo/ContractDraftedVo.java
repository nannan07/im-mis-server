package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Contract;

/**
 * 合同起草，草稿箱
 * @author sunnannan
 *
 */
public class ContractDraftedVo extends ContractBaseVo {
	private Date cTime;

	public ContractDraftedVo() {
	}

	public ContractDraftedVo(Contract contract) {
		if (contract != null) {
			this.id = contract.getId();
			this.contTitle = contract.getContTitle();
			this.totalAmount = contract.getTotalAmount();
			this.cTime = contract.getcTime();
		}
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
}
