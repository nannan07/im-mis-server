package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.ProjectSpecific;

public class ProjectSpecificVo {
	private String id;

	private String projId;

	private String biziness;

	private String bizManager;

	private String bizState;

	private String signingContract;

	private String contractState;

	private Integer contractCounts;

	private String finace;

	private String finaceState;

	private String principal;

	private String principalManager;

	private String principalState;

	private String releaseOnline;

	private String releaseManager;

	private String releaseState;

	private String trackingSplits;

	private String payManager;

	private Integer counts;

	private Date cTime;

	private String projName;

	public ProjectSpecificVo() {

	}

	public ProjectSpecificVo(ProjectSpecific projectSpecific) {
		if (projectSpecific != null) {
			this.id = projectSpecific.getId();
			this.projId = projectSpecific.getProjId();
			this.biziness = projectSpecific.getBiziness();
			this.bizManager = projectSpecific.getBizManager();
			this.bizState = projectSpecific.getBizState();
			this.signingContract = projectSpecific.getSigningContract();
			this.contractState = projectSpecific.getContractState();
			this.contractCounts = projectSpecific.getContractCounts();
			this.finace = projectSpecific.getFinace();
			this.finaceState = projectSpecific.getFinaceState();
			this.principal = projectSpecific.getPrincipal();
			this.principalManager = projectSpecific.getPrincipalManager();
			this.principalState = projectSpecific.getPrincipalState();
			this.releaseManager = projectSpecific.getReleaseManager();
			this.releaseOnline = projectSpecific.getReleaseOnline();
			this.releaseState = projectSpecific.getReleaseState();
			this.trackingSplits = projectSpecific.getTrackingSplits();
			this.payManager = projectSpecific.getPayManager();
			this.counts = projectSpecific.getCounts();
			this.cTime = projectSpecific.getcTime();
			this.projName = projectSpecific.getProjName();
		}
	}

	public ProjectSpecificVo(ContractVo contractVo) {
		if(contractVo != null) {
			this.signingContract = "签署合同";
		}
	}

	public ProjectSpecificVo(FinanceVo financeVo) {
		if(financeVo != null) {
			this.finace = "财务立项";
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

	public String getBiziness() {
		return biziness;
	}

	public void setBiziness(String biziness) {
		this.biziness = biziness;
	}

	public String getBizManager() {
		return bizManager;
	}

	public void setBizManager(String bizManager) {
		this.bizManager = bizManager;
	}

	public String getBizState() {
		return bizState;
	}

	public void setBizState(String bizState) {
		this.bizState = bizState;
	}

	public String getSigningContract() {
		return signingContract;
	}

	public void setSigningContract(String signingContract) {
		this.signingContract = signingContract;
	}

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public Integer getContractCounts() {
		return contractCounts;
	}

	public void setContractCounts(Integer contractCounts) {
		this.contractCounts = contractCounts;
	}

	public String getFinace() {
		return finace;
	}

	public void setFinace(String finace) {
		this.finace = finace;
	}

	public String getFinaceState() {
		return finaceState;
	}

	public void setFinaceState(String finaceState) {
		this.finaceState = finaceState;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipalManager() {
		return principalManager;
	}

	public void setPrincipalManager(String principalManager) {
		this.principalManager = principalManager;
	}

	public String getPrincipalState() {
		return principalState;
	}

	public void setPrincipalState(String principalState) {
		this.principalState = principalState;
	}

	public String getReleaseOnline() {
		return releaseOnline;
	}

	public void setReleaseOnline(String releaseOnline) {
		this.releaseOnline = releaseOnline;
	}

	public String getReleaseManager() {
		return releaseManager;
	}

	public void setReleaseManager(String releaseManager) {
		this.releaseManager = releaseManager;
	}

	public String getReleaseState() {
		return releaseState;
	}

	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState;
	}

	public String getTrackingSplits() {
		return trackingSplits;
	}

	public void setTrackingSplits(String trackingSplits) {
		this.trackingSplits = trackingSplits;
	}

	public String getPayManager() {
		return payManager;
	}

	public void setPayManager(String payManager) {
		this.payManager = payManager;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}
}