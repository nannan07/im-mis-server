package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.BusinessMaterials;

public class BusinessMaterialsVo {
    private String id;

    private String bizId;

    private String materType;

    private String projId;

    private String url;

    private Integer sort;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private String materTypeName;
    
    private String situation;
    
	public BusinessMaterialsVo() {
    	
    }
    
    public BusinessMaterialsVo(BusinessMaterials materials) {
		if(materials != null) {
			this.id = materials.getId();
			this.bizId = materials.getBizId();
			this.materType = materials.getMaterType();
			this.projId = materials.getProjId();
			this.url = materials.getUrl();
			this.sort = materials.getSort();
			this.cTime = materials.getcTime();
			this.cUserId = materials.getcUserId();
			this.uTime = materials.getuTime();
			this.uUserId = materials.getuUserId();
			this.materTypeName = materials.getMaterTypeName();
			this.situation = materials.getSituation();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMaterType() {
        return materType;
    }

    public void setMaterType(String materType) {
        this.materType = materType == null ? null : materType.trim();
    }

    public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
    public String getMaterTypeName() {
		return materTypeName;
	}

	public void setMaterTypeName(String materTypeName) {
		this.materTypeName = materTypeName;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

}