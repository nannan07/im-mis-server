package com.allmsi.mis.model.vo;

import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.po.Contract;

public class ContractVo{
    private String id;

    private String contTitle;

    private String contUserId;

    private String contUserName;

    private String contUserDeptId;

    private String contUserDeptName;

    private String contDetail;

    private String contType;

    private String contNo;

    private String totalAmount;

    private String projId;

    private String bizId;

    private String ourCompanyId;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private String conTypeName;
    
    private List<String> partnerCompanyName;

    private String ourCompanyName;
    
    private String projName;

    private String projShare;

    private String projShareValue;

    private String isBiz;

    private String dateofApplication;

    private String dateofSigning;
    
    private String contTypeName;
    
    private Integer draft;
    
    public ContractVo() {
    	
    }
    
    public ContractVo(Contract contract) {
    	if(contract != null) {
		this.id = contract.getId();
		this.contTitle = contract.getContTitle();
		this.contUserId = contract.getContUserId();
		this.contUserName = contract.getContUserName();
		this.contUserDeptId = contract.getContUserDeptId();
		this.contUserDeptName = contract.getContUserDeptName();
		this.contDetail = contract.getContDetail();
		this.contType = contract.getContType();
		this.contNo = String.valueOf(contract.getContNo());
		this.totalAmount = String.valueOf(contract.getTotalAmount());
		this.projId = contract.getProjId();
		this.bizId = contract.getBizId();
		this.ourCompanyId = contract.getOurCompanyId();
		this.cTime = contract.getcTime();
		this.cUserId = contract.getcUserId();
		this.uTime = contract.getuTime();
		this.uUserId = contract.getuUserId();
		this.partnerCompanyName = contract.getPartnerCompanyName();
		this.conTypeName = contract.getConTypeName();
		this.ourCompanyName = contract.getOurCompanyName();
		this.projName = contract.getProjName();
		this.projShare = contract.getProjShare();
		this.projShareValue = String.valueOf(contract.getProjShareValue());
		this.isBiz = String.valueOf(contract.getIsBiz());
		this.dateofApplication = contract.getDateofApplication();
		this.dateofSigning = contract.getDateofSigning();
		this.contTypeName = contract.getContTypeName();
    	}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

	public String getContDetail() {
		return contDetail;
	}

	public void setContDetail(String contDetail) {
		this.contDetail = contDetail;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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

	public String getOurCompanyId() {
		return ourCompanyId;
	}

	public void setOurCompanyId(String ourCompanyId) {
		this.ourCompanyId = ourCompanyId;
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
		this.cUserId = cUserId;
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
		this.uUserId = uUserId;
	}

	public String getConTypeName() {
		return conTypeName;
	}

	public void setConTypeName(String conTypeName) {
		this.conTypeName = conTypeName;
	}

	public String getOurCompanyName() {
		return ourCompanyName;
	}

	public void setOurCompanyName(String ourCompanyName) {
		this.ourCompanyName = ourCompanyName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjShare() {
		return projShare;
	}

	public void setProjShare(String projShare) {
		this.projShare = projShare;
	}

	public String getProjShareValue() {
		return projShareValue;
	}

	public void setProjShareValue(String projShareValue) {
		this.projShareValue = projShareValue;
	}

	public String getIsBiz() {
		return isBiz;
	}

	public void setIsBiz(String isBiz) {
		this.isBiz = isBiz;
	}

	public String getDateofApplication() {
		return dateofApplication;
	}

	public void setDateofApplication(String dateofApplication) {
		this.dateofApplication = dateofApplication;
	}

	public String getDateofSigning() {
		return dateofSigning;
	}

	public void setDateofSigning(String dateofSigning) {
		this.dateofSigning = dateofSigning;
	}

	public String getContTypeName() {
		return contTypeName;
	}

	public void setContTypeName(String contTypeName) {
		this.contTypeName = contTypeName;
	}


	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public List<String> getPartnerCompanyName() {
		return partnerCompanyName;
	}

	public void setPartnerCompanyName(List<String> partnerCompanyName) {
		this.partnerCompanyName = partnerCompanyName;
	}
}