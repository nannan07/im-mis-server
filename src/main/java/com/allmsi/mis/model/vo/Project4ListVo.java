package com.allmsi.mis.model.vo;

import com.allmsi.mis.model.po.Project;

public class Project4ListVo {
	
	private String id;

	private String projId;

	private String projName;

	private String projNo;

	private String bizTime;

	private String bizUserId;

	private String bizUserName;

	private String bizUserDeptId;

	private String bizUserDeptName;
	
	private Integer totalBudget;
	
	public Project4ListVo() {

	}

	public Project4ListVo(Project project) {
		if (project != null) {
			this.id = project.getId();
			this.projId = project.getProjId();
			this.projName = project.getProjName();
			this.projNo = project.getProjNo();
			this.bizTime = project.getBizTime();
			this.bizUserId = project.getBizUserId();
			this.bizUserName = project.getBizUserName();
			this.bizUserDeptId = project.getBizUserDeptId();
			this.bizUserDeptName = project.getBizUserDeptName();
			this.totalBudget = project.getTotalBudget();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjNo() {
		return projNo;
	}

	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}

	public String getBizTime() {
		return bizTime;
	}

	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}

	public String getBizUserId() {
		return bizUserId;
	}

	public void setBizUserId(String bizUserId) {
		this.bizUserId = bizUserId;
	}

	public String getBizUserName() {
		return bizUserName;
	}

	public void setBizUserName(String bizUserName) {
		this.bizUserName = bizUserName;
	}

	public String getBizUserDeptId() {
		return bizUserDeptId;
	}

	public void setBizUserDeptId(String bizUserDeptId) {
		this.bizUserDeptId = bizUserDeptId;
	}

	public String getBizUserDeptName() {
		return bizUserDeptName;
	}

	public void setBizUserDeptName(String bizUserDeptName) {
		this.bizUserDeptName = bizUserDeptName;
	}

	public Integer getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(Integer totalBudget) {
		this.totalBudget = totalBudget;
	}
	
}
