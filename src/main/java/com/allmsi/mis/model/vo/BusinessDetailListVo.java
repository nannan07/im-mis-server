package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Business;

public class BusinessDetailListVo {

	private String id;

	private String projName;

	private String bizTime;

	private String bizUserDeptName;
	
	private String bizUserDeptId;
	
	private Date cTime;
	
	private String jointDetails;

	private String producedType;

	private String projType;

	private String declareType;

	private String marketingType;

	private String contentType;
	
	private String estimatedRatingName;

	private String producedTypeName;

	private String declareTypeName;

	private String marketingTypeName;

	private String contentTypeName;

	private String projTypeName;
	
	private String bizUserName;
	
	private String bizUsertId;
	
	private String estimatedRating;
	
	public BusinessDetailListVo(Business business) {
		if (business != null) {
			this.id = business.getId();
			this.projName = business.getProjName();
			this.bizUserDeptName = business.getBizUserDeptName();
			this.cTime = business.getcTime();
			this.jointDetails = business.getJointDetails();
			this.bizUserDeptId = business.getBizUserDeptId();
			this.bizUsertId = business.getBizUserId();
			this.bizUserName = business.getBizUserName();
			this.projType = business.getProjType();
			this.declareType = business.getDeclareType();
			this.producedType = business.getProducedType();
			this.estimatedRating = business.getEstimatedRating();
			this.contentType = business.getContentType();
			this.marketingType = business.getMarketingType();
			this.projTypeName = business.getProjTypeName();
			this.declareTypeName = business.getDeclareTypeName();
			this.producedTypeName = business.getProducedTypeName();
			this.estimatedRatingName = business.getEstimatedRatingName();
			this.contentTypeName = business.getContentTypeName();
			this.marketingTypeName = business.getMarketingTypeName();
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}


	public String getBizTime() {
		return bizTime;
	}

	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}

	public String getBizUserDeptName() {
		return bizUserDeptName;
	}

	public void setBizUserDeptName(String bizUserDeptName) {
		this.bizUserDeptName = bizUserDeptName;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getJointDetails() {
		return jointDetails;
	}

	public void setJointDetails(String jointDetails) {
		this.jointDetails = jointDetails;
	}

	public String getDeclareType() {
		return declareType;
	}

	public void setDeclareType(String declareType) {
		this.declareType = declareType;
	}

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}

	public String getBizUserDeptId() {
		return bizUserDeptId;
	}

	public void setBizUserDeptId(String bizUserDeptId) {
		this.bizUserDeptId = bizUserDeptId;
	}

	public String getBizUserName() {
		return bizUserName;
	}

	public void setBizUserName(String bizUserName) {
		this.bizUserName = bizUserName;
	}

	public String getBizUsertId() {
		return bizUsertId;
	}

	public void setBizUsertId(String bizUsertId) {
		this.bizUsertId = bizUsertId;
	}

	public String getProducedType() {
		return producedType;
	}

	public void setProducedType(String producedType) {
		this.producedType = producedType;
	}

	public String getDeclareTypeName() {
		return declareTypeName;
	}

	public void setDeclareTypeName(String declareTypeName) {
		this.declareTypeName = declareTypeName;
	}

	public String getProjTypeName() {
		return projTypeName;
	}

	public void setProjTypeName(String projTypeName) {
		this.projTypeName = projTypeName;
	}

	public String getProducedTypeName() {
		return producedTypeName;
	}

	public void setProducedTypeName(String producedTypeName) {
		this.producedTypeName = producedTypeName;
	}

	public String getMarketingType() {
		return marketingType;
	}

	public void setMarketingType(String marketingType) {
		this.marketingType = marketingType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEstimatedRatingName() {
		return estimatedRatingName;
	}

	public void setEstimatedRatingName(String estimatedRatingName) {
		this.estimatedRatingName = estimatedRatingName;
	}

	public String getMarketingTypeName() {
		return marketingTypeName;
	}

	public void setMarketingTypeName(String marketingTypeName) {
		this.marketingTypeName = marketingTypeName;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public String getEstimatedRating() {
		return estimatedRating;
	}

	public void setEstimatedRating(String estimatedRating) {
		this.estimatedRating = estimatedRating;
	}
	
}
