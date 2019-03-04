package com.allmsi.mis.model.po;

import java.util.Date;
import java.util.List;

import com.allmsi.mis.model.vo.FinanceVo;
import com.allmsi.sys.util.StrUtil;

public class Finance {
	private String id;

	private String projId;

	private String finTime;

	private String bizId;

	private String detail;

	private String finUserId;

	private String finUserName;

	private String finUserDept;

	private String finUserDeptName;

	private Integer contTotalAmount;

	private Integer ourAmount;

	private String note;

	private String causeOf;

	private Integer increaseAmount;

	private Date cTime;

	private String cUserId;

	private Date uTime;

	private String uUserId;

	private Integer del;

	private String finName;

	private Integer isFin;

	private String contDetail;

	private String partner;

	private String contractModel;

	private String projName;

	private String contTitle;

	private Integer draft;

	private String payType;

	private String payTypeName;

	private String finNo;
	
	private List<String> contIds;

	public Finance() {

	}

	public Finance(FinanceVo FinanceVo) {
		if (FinanceVo != null) {
			this.id = FinanceVo.getId();
			this.projId = FinanceVo.getProjId();
			this.finTime = FinanceVo.getFinTime();
			this.bizId = FinanceVo.getBizId();
			this.detail = FinanceVo.getDetail();
			this.finUserId = FinanceVo.getFinUserId();
			this.finUserName = FinanceVo.getFinUserName();
			this.finUserDept = FinanceVo.getFinUserDept();
			this.finUserDeptName = FinanceVo.getFinUserDeptName();
			if (StrUtil.notEmpty(FinanceVo.getContTotalAmount()) && StrUtil.isNumeric(FinanceVo.getContTotalAmount())) {
				try {
					this.contTotalAmount = Integer.valueOf(FinanceVo.getContTotalAmount());
				} catch (Exception e) {

				}
			}
			if (StrUtil.notEmpty(FinanceVo.getOurAmount()) && StrUtil.isNumeric(FinanceVo.getOurAmount())) {
				try {
					this.ourAmount = Integer.valueOf(FinanceVo.getOurAmount());
				} catch (Exception e) {

				}
			}
			this.note = FinanceVo.getNote();
			this.causeOf = FinanceVo.getCauseOf();

			if (StrUtil.notEmpty(FinanceVo.getIncreaseAmount()) && StrUtil.isNumeric(FinanceVo.getIncreaseAmount())) {
				try {
					this.increaseAmount = Integer.valueOf(FinanceVo.getIncreaseAmount());
				} catch (Exception e) {

				}
			}
			if (StrUtil.notEmpty(FinanceVo.getIsFin()) && StrUtil.isNumeric(FinanceVo.getIsFin())) {
				try {
					this.isFin = Integer.valueOf(FinanceVo.getIsFin());
				} catch (Exception e) {

				}
			}
			this.cTime = FinanceVo.getcTime();
			this.cUserId = FinanceVo.getcUserId();
			this.uTime = FinanceVo.getuTime();
			this.uUserId = FinanceVo.getuUserId();
			this.payTypeName = FinanceVo.getPayTypeName();
			this.finName = FinanceVo.getFinName();
			this.contDetail = FinanceVo.getContDetail();
			this.partner = FinanceVo.getPartner();
			this.contractModel = FinanceVo.getContractModel();
			this.contIds = FinanceVo.getContIds();
			this.draft = FinanceVo.getDraft();
			this.finNo = FinanceVo.getFinNo();
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

	public String getFinTime() {
		return finTime;
	}

	public void setFinTime(String finTime) {
		this.finTime = finTime;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public Integer getContTotalAmount() {
		return contTotalAmount;
	}

	public void setContTotalAmount(Integer contTotalAmount) {
		this.contTotalAmount = contTotalAmount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}

	public String getFinUserId() {
		return finUserId;
	}

	public void setFinUserId(String finUserId) {
		this.finUserId = finUserId == null ? null : finUserId.trim();
	}

	public String getFinUserName() {
		return finUserName;
	}

	public void setFinUserName(String finUserName) {
		this.finUserName = finUserName == null ? null : finUserName.trim();
	}

	public String getFinUserDept() {
		return finUserDept;
	}

	public void setFinUserDept(String finUserDept) {
		this.finUserDept = finUserDept == null ? null : finUserDept.trim();
	}

	public String getFinUserDeptName() {
		return finUserDeptName;
	}

	public void setFinUserDeptName(String finUserDeptName) {
		this.finUserDeptName = finUserDeptName == null ? null : finUserDeptName.trim();
	}

	public Integer getOurAmount() {
		return ourAmount;
	}

	public void setOurAmount(Integer ourAmount) {
		this.ourAmount = ourAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getCauseOf() {
		return causeOf;
	}

	public void setCauseOf(String causeOf) {
		this.causeOf = causeOf == null ? null : causeOf.trim();
	}

	public Integer getIncreaseAmount() {
		return increaseAmount;
	}

	public void setIncreaseAmount(Integer increaseAmount) {
		this.increaseAmount = increaseAmount;
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

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getFinName() {
		return finName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}

	public Integer getIsFin() {
		return isFin;
	}

	public void setIsFin(Integer isFin) {
		this.isFin = isFin;
	}

	public String getContDetail() {
		return contDetail;
	}

	public void setContDetail(String contDetail) {
		this.contDetail = contDetail;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getContractModel() {
		return contractModel;
	}

	public void setContractModel(String contractModel) {
		this.contractModel = contractModel;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getContTitle() {
		return contTitle;
	}

	public void setContTitle(String contTitle) {
		this.contTitle = contTitle;
	}

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public List<String> getContIds() {
		return contIds;
	}

	public void setContIds(List<String> contIds) {
		this.contIds = contIds;
	}

	public String getFinNo() {
		return finNo;
	}

	public void setFinNo(String finNo) {
		this.finNo = finNo;
	}

}