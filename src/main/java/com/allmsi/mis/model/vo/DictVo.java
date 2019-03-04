package com.allmsi.mis.model.vo;

import com.allmsi.mis.model.po.Dict;

public class DictVo {
    private String id;

    private String dType;

    private String dName;

    private Integer dSort;

    private String parentId;

    public DictVo() {
    	
    }
    
    public DictVo(Dict dict) {
		if(dict != null) {
			this.id = dict.getId();
			this.dType = dict.getdType();
			this.dName = dict.getdName();
			this.dSort = dict.getdSort();
			this.parentId = dict.getParentId();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType == null ? null : dType.trim();
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdSort() {
        return dSort;
    }

    public void setdSort(Integer dSort) {
        this.dSort = dSort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}