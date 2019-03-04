package com.allmsi.mis.model.vo;

import java.util.Date;

public class BusinessMaterialsOneVo {

	private String materType;

    private String url;

    private Integer sort;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

	public String getMaterType() {
		return materType;
	}

	public void setMaterType(String materType) {
		this.materType = materType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
}
