package com.allmsi.mis.model.vo;

import java.util.List;
//接收前端obj
public class BusinessMaterialsListVo {
    private String id;

    private String bizId;

    private String projId;

    private List<BusinessMaterialsOneVo> list;
    
    public List<BusinessMaterialsOneVo> getList() {
		return list;
	}

	public void setList(List<BusinessMaterialsOneVo> list) {
		this.list = list;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

}