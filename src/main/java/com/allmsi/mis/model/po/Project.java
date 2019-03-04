package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ProjectVo;

public class Project {
	private String id;

	private String projId;

	private String projName;

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

	private String actualRating;

	private String projType;

	private String productType;

	private String declareType;

	private String marketingType;

	private String contentType;

	private String promotionDirection;

	private Integer totalBudget;

	private Integer totalExpenses;

	private Integer del;

	private Integer isEffective;

	private Date cTime;

	private Integer projectShare;

    private String contTitle;

    private Date contTime;

    private String contUserDeptId;

    private String contUserDeptName;

    private String contUserId;

    private String contUserName;

    private String finName;

    private String finTime;

    private String finUserId;

    private String finUserName;

    private String finUserDeptId;

    private String finUserDeptName;

    private String payName;

    private String payTime;

    private String payUserDeptId;

    private String payUserDeptName;

    private String payUserId;

    private String payUserName;
	
    private String estimatedRatingName;
    
	private String productTypeName;

	private String declareTypeName;

	private String marketingTypeName;

	private String contentTypeName;

	private String projTypeName;
    
    private String actualRatingName;
    
	public Project() {

	}

	public Project(ProjectVo ProjectVo) {
		if (ProjectVo != null) {
			this.id = ProjectVo.getId();
			this.projName = ProjectVo.getProjName();
			this.projNo = ProjectVo.getProjNo();
			this.bizTime = ProjectVo.getBizTime();
			this.bizUserId = ProjectVo.getBizUserId();
			this.bizUserName = ProjectVo.getBizUserName();
			this.bizUserDeptId = ProjectVo.getBizUserDeptId();
			this.bizUserDeptName = ProjectVo.getBizUserDeptName();
			this.promotionUserId = ProjectVo.getPromotionUserId();
			this.promotionUserName = ProjectVo.getPromotionUserName();
			this.releaseManagerId = ProjectVo.getReleaseManagerId();
			this.releaseManagerName = ProjectVo.getReleaseManagerName();
			this.recordSituation = ProjectVo.getRecordSituation();
			this.estimatedRating = ProjectVo.getEstimatedRating();
			this.actualRating = ProjectVo.getActualRating();
			this.projType = ProjectVo.getProjType();
			this.productType = ProjectVo.getProductType();
			this.declareType = ProjectVo.getDeclareType();
			this.marketingType = ProjectVo.getMarketingType();
			this.contentType = ProjectVo.getContentType();
			this.promotionDirection = ProjectVo.getPromotionDirection();
			this.totalBudget = ProjectVo.getTotalBudget();
			this.totalExpenses = ProjectVo.getTotalExpenses();
			this.cTime = ProjectVo.getcTime();
			this.projectShare = ProjectVo.getProjectShare();
			this.contTitle = ProjectVo.getContTitle();
			this.contTime = ProjectVo.getContTime();
			this.contUserDeptId = ProjectVo.getContUserDeptId();
			this.contUserDeptName = ProjectVo.getContUserDeptName();
			this.contUserId = ProjectVo.getContUserId();
			this.contUserName = ProjectVo.getContUserName();
			this.finName = ProjectVo.getFinName();
			this.finTime = ProjectVo.getFinTime();
			this.finUserId = ProjectVo.getFinUserId();
			this.finUserName = ProjectVo.getFinUserName();
			this.finUserDeptId = ProjectVo.getFinUserDeptId();
			this.finUserDeptName = ProjectVo.getFinUserDeptName();
			this.payName = ProjectVo.getPayName();
			this.payTime = ProjectVo.getPayTime();
			this.payUserDeptId = ProjectVo.getPayUserDeptId();
			this.payUserDeptName = ProjectVo.getPayUserDeptName();
			this.payUserId = ProjectVo.getPayUserId();
			this.payUserName = ProjectVo.getPayUserName();
			this.actualRatingName = ProjectVo.getActualRatingName();
			this.estimatedRatingName = ProjectVo.getEstimatedRatingName();
			this.productTypeName = ProjectVo.getProductTypeName();
			this.declareTypeName = ProjectVo.getDeclareTypeName();
			this.projTypeName = ProjectVo.getProjTypeName();
			this.marketingTypeName = ProjectVo.getMarketingTypeName();
			this.contentTypeName = ProjectVo.getContentTypeName();
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
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
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

	public String getActualRating() {
		return actualRating;
	}

	public void setActualRating(String actualRating) {
		this.actualRating = actualRating == null ? null : actualRating.trim();
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

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType == null ? null : productType.trim();
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

	public String getPromotionDirection() {
		return promotionDirection;
	}

	public void setPromotionDirection(String promotionDirection) {
		this.promotionDirection = promotionDirection == null ? null : promotionDirection.trim();
	}

	public Integer getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(Integer totalBudget) {
		this.totalBudget = totalBudget;
	}

	public Integer getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(Integer totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Integer getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}

	public Integer getProjectShare() {
		return projectShare;
	}

	public void setProjectShare(Integer projectShare) {
		this.projectShare = projectShare;
	}

	public String getContTitle() {
		return contTitle;
	}

	public void setContTitle(String contTitle) {
		this.contTitle = contTitle;
	}

	public Date getContTime() {
		return contTime;
	}

	public void setContTime(Date contTime) {
		this.contTime = contTime;
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

	public String getFinName() {
		return finName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}

	public String getFinTime() {
		return finTime;
	}

	public void setFinTime(String finTime) {
		this.finTime = finTime;
	}

	public String getFinUserId() {
		return finUserId;
	}

	public void setFinUserId(String finUserId) {
		this.finUserId = finUserId;
	}

	public String getFinUserName() {
		return finUserName;
	}

	public void setFinUserName(String finUserName) {
		this.finUserName = finUserName;
	}

	public String getFinUserDeptId() {
		return finUserDeptId;
	}

	public void setFinUserDeptId(String finUserDeptId) {
		this.finUserDeptId = finUserDeptId;
	}

	public String getFinUserDeptName() {
		return finUserDeptName;
	}

	public void setFinUserDeptName(String finUserDeptName) {
		this.finUserDeptName = finUserDeptName;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayUserDeptId() {
		return payUserDeptId;
	}

	public void setPayUserDeptId(String payUserDeptId) {
		this.payUserDeptId = payUserDeptId;
	}

	public String getPayUserDeptName() {
		return payUserDeptName;
	}

	public void setPayUserDeptName(String payUserDeptName) {
		this.payUserDeptName = payUserDeptName;
	}

	public String getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(String payUserId) {
		this.payUserId = payUserId;
	}

	public String getPayUserName() {
		return payUserName;
	}

	public void setPayUserName(String payUserName) {
		this.payUserName = payUserName;
	}

	public String getEstimatedRatingName() {
		return estimatedRatingName;
	}

	public void setEstimatedRatingName(String estimatedRatingName) {
		this.estimatedRatingName = estimatedRatingName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
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

	public String getProjTypeName() {
		return projTypeName;
	}

	public void setProjTypeName(String projTypeName) {
		this.projTypeName = projTypeName;
	}

	public String getActualRatingName() {
		return actualRatingName;
	}

	public void setActualRatingName(String actualRatingName) {
		this.actualRatingName = actualRatingName;
	}

}