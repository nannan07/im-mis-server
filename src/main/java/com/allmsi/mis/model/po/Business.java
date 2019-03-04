package com.allmsi.mis.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.vo.BusinessVo;
import com.allmsi.sys.util.StrUtil;

public class Business {
	private String id;

	private String projName;

	private String projId;

	private String projType;

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

	private Integer promotionBudget;

	private String promotionDirection;

	private Integer isProectTeam;

	private String note;

	private String producedType;

	private String jointDetails;

	private String declareType;

	private String marketingType;

	private String contentType;

	private String otherCategories;

	private Date cTime;

	private String cUserId;

	private Date uTime;

	private String uUserId;

	private Integer draft;

	private Integer del;

	//
	private String estimatedRatingName;

	private String producedTypeName;

	private String declareTypeName;

	private String marketingTypeName;

	private String contentTypeName;

	private String projTypeName;

	private List<BusinessMaterials> materialsList = new ArrayList<BusinessMaterials>();

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

	public Business() {

	}

	public Business(BusinessVo businessVo) {
		if (businessVo != null) {
			this.id = businessVo.getId();
			this.projName = businessVo.getProjName();
			this.projId = businessVo.getProjId();
			this.projType = businessVo.getProjType();
			this.projNo = businessVo.getProjNo();
			this.bizTime = businessVo.getBizTime();
			this.bizUserId = businessVo.getBizUserId();
			this.bizUserName = businessVo.getBizUserName();
			this.bizUserDeptId = businessVo.getBizUserDeptId();
			this.bizUserDeptName = businessVo.getBizUserDeptName();
			this.promotionUserId = businessVo.getPromotionUserId();
			this.promotionUserName = businessVo.getPromotionUserName();
			this.releaseManagerId = businessVo.getReleaseManagerId();
			this.releaseManagerName = businessVo.getReleaseManagerName();
			this.recordSituation = businessVo.getRecordSituation();
			this.estimatedRating = businessVo.getEstimatedRating();
			String str1 = businessVo.getPromotionBudget();
			if (StrUtil.notEmpty(str1) && StrUtil.isNumeric(str1)) {
				try {
					this.promotionBudget = Integer.valueOf(str1);
				} catch (Exception e) {

				}
			}
			String str2 = businessVo.getIsProectTeam();
			if (StrUtil.notEmpty(str2) && StrUtil.isNumeric(str2)) {
				try {
					this.isProectTeam = Integer.valueOf(str2);
				} catch (Exception e) {

				}
			}
			this.promotionDirection = businessVo.getPromotionDirection();

			this.note = businessVo.getNote();
			this.producedType = businessVo.getProducedType();
			this.jointDetails = businessVo.getJointDetails();
			this.declareType = businessVo.getDeclareType();
			this.marketingType = businessVo.getMarketingType();
			this.contentType = businessVo.getContentType();
			this.otherCategories = businessVo.getOtherCategories();
			this.cUserId = businessVo.getcUserId();
			this.uUserId = businessVo.getuUserId();
			this.contentTypeName = businessVo.getContentTypeName();
			this.declareTypeName = businessVo.getDeclareTypeName();
			this.producedTypeName = businessVo.getProducedTypeName();
			this.estimatedRatingName = businessVo.getEstimatedRatingName();
			this.marketingTypeName = businessVo.getMarketingTypeName();
			this.materialsList = businessVo.getMaterialsList();
			this.draft = businessVo.getDraft();
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

	public Integer getPromotionBudget() {
		return promotionBudget;
	}

	public void setPromotionBudget(Integer promotionBudget) {
		this.promotionBudget = promotionBudget;
	}

	public String getPromotionDirection() {
		return promotionDirection;
	}

	public void setPromotionDirection(String promotionDirection) {
		this.promotionDirection = promotionDirection == null ? null : promotionDirection.trim();
	}

	public Integer getIsProectTeam() {
		return isProectTeam;
	}

	public void setIsProectTeam(Integer isProectTeam) {
		this.isProectTeam = isProectTeam;
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
		this.cUserId = cUserId == null ? null : cUserId.trim();
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
		this.uUserId = uUserId == null ? null : uUserId.trim();
	}

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public List<BusinessMaterials> getMaterialsList() {
		return materialsList;
	}

	public void setMaterialsList(List<BusinessMaterials> materialsList) {
		this.materialsList = materialsList;
	}

	public String getProjTypeName() {
		return projTypeName;
	}

	public void setProjTypeName(String projTypeName) {
		this.projTypeName = projTypeName;
	}

}