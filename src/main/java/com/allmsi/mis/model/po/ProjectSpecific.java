package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.sys.util.UUIDUtil;

public class ProjectSpecific {
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

	public ProjectSpecific() {

	}

	public ProjectSpecific(ProjectSpecificVo projectSpecificVo) {
		if (projectSpecificVo != null) {
			this.id = projectSpecificVo.getId();
			this.projId = projectSpecificVo.getProjId();
			this.biziness = projectSpecificVo.getBiziness();
			this.bizManager = projectSpecificVo.getBizManager();
			this.bizState = projectSpecificVo.getBizState();
			this.signingContract = projectSpecificVo.getSigningContract();
			this.contractState = projectSpecificVo.getContractState();
			this.contractCounts = projectSpecificVo.getContractCounts();
			this.finace = projectSpecificVo.getFinace();
			this.finaceState = projectSpecificVo.getFinaceState();
			this.principal = projectSpecificVo.getPrincipal();
			this.principalManager = projectSpecificVo.getPrincipalManager();
			this.principalState = projectSpecificVo.getPrincipalState();
			this.releaseManager = projectSpecificVo.getReleaseManager();
			this.releaseOnline = projectSpecificVo.getReleaseOnline();
			this.releaseState = projectSpecificVo.getReleaseState();
			this.trackingSplits = projectSpecificVo.getTrackingSplits();
			this.payManager = projectSpecificVo.getPayManager();
			this.counts = projectSpecificVo.getCounts();
		}
	}

	public ProjectSpecific(Project project) {
		if (project != null) {
			this.projId = project.getProjId();
			this.biziness = "业务立项";
			this.bizManager = project.getBizUserName();
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
		this.projId = projId == null ? null : projId.trim();
	}

	public String getBiziness() {
		return biziness;
	}

	public void setBiziness(String biziness) {
		this.biziness = biziness == null ? null : biziness.trim();
	}

	public String getBizManager() {
		return bizManager;
	}

	public void setBizManager(String bizManager) {
		this.bizManager = bizManager == null ? null : bizManager.trim();
	}

	public String getBizState() {
		return bizState;
	}

	public void setBizState(String bizState) {
		this.bizState = bizState == null ? null : bizState.trim();
	}

	public String getSigningContract() {
		return signingContract;
	}

	public void setSigningContract(String signingContract) {
		this.signingContract = signingContract == null ? null : signingContract.trim();
	}

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState == null ? null : contractState.trim();
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
		this.finace = finace == null ? null : finace.trim();
	}

	public String getFinaceState() {
		return finaceState;
	}

	public void setFinaceState(String finaceState) {
		this.finaceState = finaceState == null ? null : finaceState.trim();
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal == null ? null : principal.trim();
	}

	public String getPrincipalManager() {
		return principalManager;
	}

	public void setPrincipalManager(String principalManager) {
		this.principalManager = principalManager == null ? null : principalManager.trim();
	}

	public String getPrincipalState() {
		return principalState;
	}

	public void setPrincipalState(String principalState) {
		this.principalState = principalState == null ? null : principalState.trim();
	}

	public String getReleaseOnline() {
		return releaseOnline;
	}

	public void setReleaseOnline(String releaseOnline) {
		this.releaseOnline = releaseOnline == null ? null : releaseOnline.trim();
	}

	public String getReleaseManager() {
		return releaseManager;
	}

	public void setReleaseManager(String releaseManager) {
		this.releaseManager = releaseManager == null ? null : releaseManager.trim();
	}

	public String getReleaseState() {
		return releaseState;
	}

	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState == null ? null : releaseState.trim();
	}

	public String getTrackingSplits() {
		return trackingSplits;
	}

	public void setTrackingSplits(String trackingSplits) {
		this.trackingSplits = trackingSplits == null ? null : trackingSplits.trim();
	}

	public String getPayManager() {
		return payManager;
	}

	public void setPayManager(String payManager) {
		this.payManager = payManager == null ? null : payManager.trim();
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