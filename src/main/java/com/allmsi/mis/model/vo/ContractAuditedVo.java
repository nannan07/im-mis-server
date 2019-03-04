package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Contract;

/**
 * 已审合同
 * 
 * @author sunnannan
 *
 */
public class ContractAuditedVo extends ContractBaseVo {

	// 我方负责人
	private String contUserId;

	private String contUserName;

	// 合同部门
	private String contUserDeptId;

	private String contUserDeptName;

	private Date cTime;

	private String currentLink;//当前环节

	public ContractAuditedVo() {
	}

	public ContractAuditedVo(Contract contract) {
		if (contract != null) {
			this.id = contract.getId();
			this.contTitle = contract.getContTitle();
			this.contUserId = contract.getContUserId();
			this.contUserName = contract.getContUserName();
			this.contUserDeptId = contract.getContUserDeptId();
			this.contUserDeptName = contract.getContUserDeptName();
			this.totalAmount = contract.getTotalAmount();
			this.cTime = contract.getcTime();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContTitle() {
		return contTitle;
	}

	public void setContTitle(String contTitle) {
		this.contTitle = contTitle;
	}

	public String getContUserId() {
		return contUserId;
	}

	public void setContUserId(String contUserId) {
		this.contUserId = contUserId;
	}

	public String getContUserName() {
		return contUserName;
	}

	public void setContUserName(String contUserName) {
		this.contUserName = contUserName;
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

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getCurrentLink() {
		return currentLink;
	}

	public void setCurrentLink(String currentLink) {
		this.currentLink = currentLink;
	}

}
