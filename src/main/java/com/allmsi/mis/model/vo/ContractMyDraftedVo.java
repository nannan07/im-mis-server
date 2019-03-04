package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Contract;

/**
 * 我起草的合同
 * 
 * @author sunnannan
 *
 */
public class ContractMyDraftedVo extends ContractBaseVo {
	private Date cTime;

	private String contUserDeptId;

	private String contUserDeptName;
	
	private String currentLink;//当前环节
	
	private String auditor;//审核人

	public ContractMyDraftedVo() {
	}

	public ContractMyDraftedVo(Contract contract) {
		if (contract != null) {
			this.id = contract.getId();
			this.contTitle = contract.getContTitle();
			this.totalAmount = contract.getTotalAmount();
			this.cTime = contract.getcTime();
			this.contUserDeptId = contract.getContUserDeptId();
			this.contUserDeptName = contract.getContUserDeptName();
		}
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getContUserDeptId() {
		return contUserDeptId;
	}

	public void setContUserDeptId(String contUserDeptId) {
		this.contUserDeptId = contUserDeptId;
	}

	public String getContUserDeptName() {
		return contUserDeptName;
	}

	public void setContUserDeptName(String contUserDeptName) {
		this.contUserDeptName = contUserDeptName;
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
