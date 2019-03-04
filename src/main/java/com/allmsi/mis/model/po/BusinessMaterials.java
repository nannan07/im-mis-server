package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.BusinessMaterialsVo;

public class BusinessMaterials {
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

    private Integer del;

    private String materTypeName;
    
    private String situation;
    
    public BusinessMaterials() {
    	
    }
    
    public BusinessMaterials(BusinessMaterialsVo materialsVo) {
		if(materialsVo != null) {
			this.id = materialsVo.getId();
			this.bizId = materialsVo.getBizId();
			this.materType = materialsVo.getMaterType();
			this.projId = materialsVo.getProjId();
			this.url = materialsVo.getUrl();
			this.sort = materialsVo.getSort();
			this.cTime = materialsVo.getcTime();
			this.cUserId = materialsVo.getcUserId();
			this.uTime = materialsVo.getuTime();
			this.uUserId = materialsVo.getuUserId();
			this.materTypeName = materialsVo.getMaterTypeName();
			this.situation = materialsVo.getSituation();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
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