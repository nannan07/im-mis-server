package com.allmsi.mis.model.po;

import com.allmsi.mis.model.vo.DictVo;

public class Dict {
    private String id;

    private String dType;

    private String dName;

    private Integer dSort;

    private String parentId;

    private Integer del;

    public Dict() {
    	
    }
    
    public Dict(DictVo dictVo) {
		if(dictVo != null) {
			this.id = dictVo.getId();
			this.dType = dictVo.getdType();
			this.dName = dictVo.getdName();
			this.dSort = dictVo.getdSort();
			this.parentId = dictVo.getParentId();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}