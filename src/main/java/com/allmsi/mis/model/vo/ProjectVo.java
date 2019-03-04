package com.allmsi.mis.model.vo;

import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.po.Business;
import com.allmsi.mis.model.po.BusinessMaterials;
import com.allmsi.mis.model.po.Contract;
import com.allmsi.mis.model.po.Finance;
import com.allmsi.mis.model.po.Payment;
import com.allmsi.mis.model.po.Project;
import com.allmsi.mis.model.po.ProjectLssued;
import com.allmsi.sys.util.DateUtil;
import com.allmsi.sys.util.StrUtil;

public class ProjectVo {
	
	private String estimatedRatingName;
    
	private String productTypeName;

	private String declareTypeName;

	private String marketingTypeName;

	private String contentTypeName;

	private String projTypeName;
	    
	private String actualRatingName;
	
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

	private List<BusinessMaterials> bizMaterials;

	private List<ProjectLssued> projLssued;

	private List<Business> bizList;

	private List<Contract> contList;

	private List<Finance> finList;

	private List<Payment> payList;

	public ProjectVo() {

	}

	public ProjectVo(Project project) {
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
			this.promotionUserId = project.getPromotionUserId();
			this.promotionUserName = project.getPromotionUserName();
			this.releaseManagerId = project.getReleaseManagerId();
			this.releaseManagerName = project.getReleaseManagerName();
			this.recordSituation = project.getRecordSituation();
			this.estimatedRating = project.getEstimatedRating();
			this.actualRating = project.getActualRating();
			this.projType = project.getProjType();
			this.productType = project.getProductType();
			this.declareType = project.getDeclareType();
			this.marketingType = project.getMarketingType();
			this.contentType = project.getContentType();
			this.promotionDirection = project.getPromotionDirection();
			this.totalBudget = project.getTotalBudget();
			this.totalExpenses = project.getTotalExpenses();
			this.projectShare = project.getProjectShare();
			this.contTitle = project.getContTitle();
			this.contTime = project.getContTime();
			this.contUserDeptId = project.getContUserDeptId();
			this.contUserDeptName = project.getContUserDeptName();
			this.contUserId = project.getContUserId();
			this.contUserName = project.getContUserName();
			this.finName = project.getFinName();
			this.finTime = project.getFinTime();
			this.finUserId = project.getFinUserId();
			this.finUserName = project.getFinUserName();
			this.finUserDeptId = project.getFinUserDeptId();
			this.finUserDeptName = project.getFinUserDeptName();
			this.payName = project.getPayName();
			this.payTime = project.getPayTime();
			this.payUserDeptId = project.getPayUserDeptId();
			this.payUserDeptName = project.getPayUserDeptName();
			this.payUserId = project.getPayUserId();
			this.payUserName = project.getPayUserName();
		}
	}

	public ProjectVo(Contract contract) {
		if (contract != null) {
			this.id = contract.getId();
			this.projId = contract.getProjId();
			this.projName = contract.getContTitle();
			this.bizTime = DateUtil.dateConvertStringTime(new Date());
			this.bizUserId = contract.getContUserId();
			this.bizUserName = contract.getContUserName();
			this.bizUserDeptId = contract.getContUserDeptId();
			this.bizUserDeptName = contract.getContUserDeptName();
			this.projType = "13";
			this.id = contract.getId();
			this.contTitle = contract.getContTitle();
			this.contUserId = contract.getContUserId();
			this.contUserName = contract.getContUserName();
			this.contUserDeptId = contract.getContUserDeptId();
			this.contUserDeptName = contract.getContUserDeptName();
			this.contTime = contract.getcTime();
			this.cTime = contract.getcTime();
			this.projectShare = contract.getProjShareValue();
		}
	}

	public ProjectVo(Finance finance) {
		if (finance != null) {
			this.id = finance.getId();
			this.projId = finance.getProjId();
			this.projName = finance.getFinName();
			this.bizTime = DateUtil.dateConvertStringTime(new Date());
			this.bizUserId = finance.getFinUserId();
			this.bizUserName = finance.getFinUserName();
			this.bizUserDeptId = finance.getFinUserDept();
			this.bizUserDeptName = finance.getFinUserDeptName();
			this.projType = "13";
			this.totalBudget = finance.getOurAmount();
			this.cTime = finance.getcTime();
			this.finName = finance.getFinName();
		}
	}

	public ProjectVo(Payment payment) {
		if (payment != null) {
			this.id = payment.getId();
			this.projId = payment.getProjId();
			this.projName = payment.getPayName();
			this.bizTime = DateUtil.dateConvertStringTime(new Date());
			this.bizUserId = payment.getManagerId();
			this.bizUserName = payment.getManagerName();
			this.bizUserDeptId = payment.getPayDeptId();
			this.bizUserDeptName = payment.getPayDeptName();
			this.projType = "13";
			this.cTime = payment.getcTime();
			this.payTime = payment.getPayDate();
			this.payUserId = payment.getcUserId();
			this.payName = payment.getPayName();
		}
	}

	public ProjectVo(BusinessVo businessVo) {
		if (businessVo != null) {
			this.projId = businessVo.getProjId();
			this.projName = businessVo.getProjName();
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
			this.projType = businessVo.getProjType();
			this.declareType = businessVo.getDeclareType();
			this.marketingType = businessVo.getMarketingType();
			this.contentType = businessVo.getContentType();
			this.promotionDirection = businessVo.getPromotionDirection();
		}
	}

	public ProjectVo(ContractVo contractVo) {
		if (contractVo != null) {
			this.projId = contractVo.getProjId();
			this.projectShare = Integer.valueOf(contractVo.getProjShareValue());
		}
	}

	public ProjectVo(FinanceVo financeVo) {
		if (financeVo != null) {
			this.projId = financeVo.getProjId();
			if (StrUtil.notEmpty(financeVo.getOurAmount()) && StrUtil.isNumeric(financeVo.getOurAmount())) {
				try {
					this.totalBudget = Integer.valueOf(financeVo.getOurAmount());
				} catch (Exception e) {

				}
			}

		}
	}

	public ProjectVo(PaymentVo paymentVo) {
		if (paymentVo != null) {
			this.projId = paymentVo.getProjId();
			this.totalExpenses = paymentVo.getPayAmount();
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

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
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

	public List<BusinessMaterials> getBizMaterials() {
		return bizMaterials;
	}

	public void setBizMaterials(List<BusinessMaterials> bizMaterials) {
		this.bizMaterials = bizMaterials;
	}

	public List<ProjectLssued> getProjLssued() {
		return projLssued;
	}

	public void setProjLssued(List<ProjectLssued> projLssued) {
		this.projLssued = projLssued;
	}

	public List<Business> getBizList() {
		return bizList;
	}

	public void setBizList(List<Business> bizList) {
		this.bizList = bizList;
	}

	public List<Contract> getContList() {
		return contList;
	}

	public void setContList(List<Contract> contList) {
		this.contList = contList;
	}

	public List<Finance> getFinList() {
		return finList;
	}

	public void setFinList(List<Finance> finList) {
		this.finList = finList;
	}

	public List<Payment> getPayList() {
		return payList;
	}

	public void setPayList(List<Payment> payList) {
		this.payList = payList;
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