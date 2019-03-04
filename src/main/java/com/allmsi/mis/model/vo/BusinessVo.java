package com.allmsi.mis.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.allmsi.mis.model.po.Business;
import com.allmsi.mis.model.po.BusinessMaterials;

public class BusinessVo {
	private String id;

	private String projName;

	private String projId;

	private String projType;
	
	private String projTypeName;

	private String projNo;

	private String bizTime;

	private String bizUserId;

	private String bizUserName;

	private String bizUserDeptId;

	private String bizUserDeptName;

	private String promotionUserId;

	private String promotionUserName;

	private String releaseManagerId;

	private String releaseManagerName;

	private String recordSituation;

	private String estimatedRating;

	private String promotionBudget;

	private String promotionDirection;

	private String isProectTeam;

	private String note;

	private String producedType;

	private String jointDetails;

	private String declareType;

	private String marketingType;

	private String contentType;

	private String otherCategories;

	private String cUserId;

	private String uUserId;
	
	private Integer draft;

	private String estimatedRatingName;

	private String producedTypeName;

	private String declareTypeName;

	private String marketingTypeName;

	private String contentTypeName;

	private List<BusinessMaterials> materialsList = new ArrayList<BusinessMaterials>();

	public BusinessVo() {

	}

	public BusinessVo(Business business) {
		if (business != null) {
			this.id = business.getId();
			this.projName = business.getProjName();
			this.projId = business.getProjId();
			this.projType = business.getProjType();
			this.projTypeName = business.getProjTypeName();
			this.projNo = business.getProjNo();
			this.bizTime = business.getBizTime();
			this.bizUserId = business.getBizUserId();
			this.bizUserName = business.getBizUserName();
			this.bizUserDeptId = business.getBizUserDeptId();
			this.bizUserDeptName = business.getBizUserDeptName();
			this.promotionUserId = business.getPromotionUserId();
			this.promotionUserName = business.getPromotionUserName();
			this.releaseManagerId = business.getReleaseManagerId();
			this.releaseManagerName = business.getReleaseManagerName();
			this.recordSituation = business.getRecordSituation();
			this.estimatedRating = business.getEstimatedRating();
			this.promotionBudget = String.valueOf(business.getPromotionBudget());
			this.promotionDirection = business.getPromotionDirection();
			this.isProectTeam = String.valueOf(business.getIsProectTeam());
			this.note = business.getNote();
			this.producedType = business.getProducedType();
			this.jointDetails = business.getJointDetails();
			this.declareType = business.getDeclareType();
			this.marketingType = business.getMarketingType();
			this.contentType = business.getContentType();
			this.otherCategories = business.getOtherCategories();
			this.cUserId = business.getcUserId();
			this.uUserId = business.getuUserId();
			this.contentTypeName = business.getContentTypeName();
			this.declareTypeName = business.getDeclareTypeName();
			this.producedTypeName = business.getProducedTypeName();
			this.estimatedRatingName = business.getEstimatedRatingName();
			this.marketingTypeName = business.getMarketingTypeName();
			this.materialsList = business.getMaterialsList();
			this.bizUserDeptId = business.getBizUserDeptId();
			this.bizUserDeptName = business.getBizUserDeptName();
			this.bizUserId = business.getBizUserId();
			this.bizUserName = business.getBizUserName();

		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
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

	public String getPromotionUserId() {
		return promotionUserId;
	}

	public void setPromotionUserId(String promotionUserId) {
		this.promotionUserId = promotionUserId == null ? null : promotionUserId.trim();
	}

	public String getPromotionUserName() {
		return promotionUserName;
	}

	public void setPromotionUserName(String promotionUserName) {
		this.promotionUserName = promotionUserName == null ? null : promotionUserName.trim();
	}

	public String getReleaseManagerId() {
		return releaseManagerId;
	}

	public void setReleaseManagerId(String releaseManagerId) {
		this.releaseManagerId = releaseManagerId == null ? null : releaseManagerId.trim();
	}

	public String getReleaseManagerName() {
		return releaseManagerName;
	}

	public void setReleaseManagerName(String releaseManagerName) {
		this.releaseManagerName = releaseManagerName == null ? null : releaseManagerName.trim();
	}

	public String getRecordSituation() {
		return recordSituation;
	}

	public void setRecordSituation(String recordSituation) {
		this.recordSituation = recordSituation == null ? null : recordSituation.trim();
	}

	public String getEstimatedRating() {
		return estimatedRating;
	}

	public void setEstimatedRating(String estimatedRating) {
		this.estimatedRating = estimatedRating == null ? null : estimatedRating.trim();
	}

	public String getPromotionDirection() {
		return promotionDirection;
	}

	public void setPromotionDirection(String promotionDirection) {
		this.promotionDirection = promotionDirection == null ? null : promotionDirection.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getProducedType() {
		return producedType;
	}

	public void setProducedType(String producedType) {
		this.producedType = producedType == null ? null : producedType.trim();
	}

	public String getJointDetails() {
		return jointDetails;
	}

	public void setJointDetails(String jointDetails) {
		this.jointDetails = jointDetails == null ? null : jointDetails.trim();
	}

	public String getDeclareType() {
		return declareType;
	}

	public void setDeclareType(String declareType) {
		this.declareType = declareType == null ? null : declareType.trim();
	}

	public String getMarketingType() {
		return marketingType;
	}

	public void setMarketingType(String marketingType) {
		this.marketingType = marketingType == null ? null : marketingType.trim();
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType == null ? null : contentType.trim();
	}

	public String getOtherCategories() {
		return otherCategories;
	}

	public void setOtherCategories(String otherCategories) {
		this.otherCategories = otherCategories == null ? null : otherCategories.trim();
	}

	public String getcUserId() {
		return cUserId;
	}

	public void setcUserId(String cUserId) {
		this.cUserId = cUserId == null ? null : cUserId.trim();
	}

	public String getuUserId() {
		return uUserId;
	}

	public void setuUserId(String uUserId) {
		this.uUserId = uUserId == null ? null : uUserId.trim();
	}

	public String getEstimatedRatingName() {
		return estimatedRatingName;
	}

	public void setEstimatedRatingName(String estimatedRatingName) {
		this.estimatedRatingName = estimatedRatingName;
	}

	public String getProducedTypeName() {
		return producedTypeName;
	}

	public void setProducedTypeName(String producedTypeName) {
		this.producedTypeName = producedTypeName;
	}

	public String getDeclareTypeName() {
		return declareTypeName;
	}

	public void setDeclareTypeName(String declareTypeName) {
		this.declareTypeName = declareTypeName;
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

	public List<BusinessMaterials> getMaterialsList() {
		return materialsList;
	}

	public void setMaterialsList(List<BusinessMaterials> materialsList) {
		this.materialsList = materialsList;
	}

	public String getPromotionBudget() {
		return promotionBudget;
	}

	public void setPromotionBudget(String promotionBudget) {
		this.promotionBudget = promotionBudget;
	}

	public String getIsProectTeam() {
		return isProectTeam;
	}

	public void setIsProectTeam(String isProectTeam) {
		this.isProectTeam = isProectTeam;
	}

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public String getProjTypeName() {
		return projTypeName;
	}

	public void setProjTypeName(String projTypeName) {
		this.projTypeName = projTypeName;
	}

}