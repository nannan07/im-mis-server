package com.allmsi.mis.model.po;

import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.vo.ContractVo;
import com.allmsi.sys.util.StrUtil;

public class Contract {
	private String id;

	private String contTitle;

	private String contUserId;

	private String contUserName;

	private String contUserDeptId;

	private String contUserDeptName;

	private String contDetail;

	private String contType;

	private Integer contNo;

	private Integer totalAmount;

	private String projId;

	private String bizId;

	private String ourCompanyId;

	private Date cTime;

	private String cUserId;

	private Date uTime;

	private String uUserId;

	private Integer del;

	private String conTypeName;

	private List<String> partnerCompanyName;

	private String ourCompanyName;

	private String projName;

	private String projShare;

	private Integer projShareValue;

	private Integer isBiz;

	private String dateofApplication;

	private String dateofSigning;

	private String contTypeName;

	private Integer draft;

	public Contract() {

	}

	public Contract(ContractVo contractVo) {
		if (contractVo != null) {
			this.id = contractVo.getId();
			this.contTitle = contractVo.getContTitle();
			this.contUserId = contractVo.getContUserId();
			this.contUserName = contractVo.getContUserName();
			this.contUserDeptId = contractVo.getContUserDeptId();
			this.contUserDeptName = contractVo.getContUserDeptName();
			this.contDetail = contractVo.getContDetail();
			this.contType = contractVo.getContType();
			if (StrUtil.notEmpty(contractVo.getContNo()) && StrUtil.isNumeric(contractVo.getContNo())) {
				try {
					this.contNo = Integer.valueOf(contractVo.getContNo());
				} catch (Exception e) {

				}
			}
			if (StrUtil.notEmpty(contractVo.getTotalAmount()) && StrUtil.isNumeric(contractVo.getTotalAmount())) {
				try {
					this.totalAmount = Integer.valueOf(contractVo.getTotalAmount());
				} catch (Exception e) {

				}
			}

			this.projId = contractVo.getProjId();
			this.bizId = contractVo.getBizId();
			this.ourCompanyId = contractVo.getOurCompanyId();
			this.cTime = contractVo.getcTime();
			this.cUserId = contractVo.getcUserId();
			this.uTime = contractVo.getuTime();
			this.uUserId = contractVo.getuUserId();
			this.partnerCompanyName = contractVo.getPartnerCompanyName();
			this.conTypeName = contractVo.getConTypeName();
			this.ourCompanyName = contractVo.getOurCompanyName();
			this.projName = contractVo.getProjName();
			this.projShare = contractVo.getProjShare();

			if (StrUtil.notEmpty(contractVo.getProjShareValue()) && StrUtil.isNumeric(contractVo.getProjShareValue())) {
				try {
					this.projShareValue = Integer.valueOf(contractVo.getProjShareValue());
				} catch (Exception e) {

				}
			}
			if (StrUtil.notEmpty(contractVo.getIsBiz()) && StrUtil.isNumeric(contractVo.getIsBiz())) {
				try {
					this.isBiz = Integer.valueOf(contractVo.getIsBiz());
				} catch (Exception e) {

				}
			}
			this.dateofApplication = contractVo.getDateofApplication();
			this.dateofSigning = contractVo.getDateofSigning();
			this.contTypeName = contractVo.getContTypeName();
			this.draft = contractVo.getDraft();
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

	public Integer getContNo() {
		return contNo;
	}

	public void setContNo(Integer contNo) {
		this.contNo = contNo;
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

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOurCompanyId() {
		return ourCompanyId;
	}

	public void setOurCompanyId(String ourCompanyId) {
		this.ourCompanyId = ourCompanyId == null ? null : ourCompanyId.trim();
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

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
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

	public Integer getProjShareValue() {
		return projShareValue;
	}

	public void setProjShareValue(Integer projShareValue) {
		this.projShareValue = projShareValue;
	}

	public Integer getIsBiz() {
		return isBiz;
	}

	public void setIsBiz(Integer isBiz) {
		this.isBiz = isBiz;
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

	public List<String> getPartnerCompanyName() {
		return partnerCompanyName;
	}

	public void setPartnerCompanyName(List<String> partnerCompanyName) {
		this.partnerCompanyName = partnerCompanyName;
	}

}