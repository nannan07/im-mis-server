package com.allmsi.mis.model.vo;

import com.allmsi.mis.model.po.Platform;

public class PlatformVo {
    private String id;

    private String pName;

    private Integer pSort;

    public PlatformVo() {
    	
    }
    
    public PlatformVo(Platform Platform) {
		if(Platform != null) {
			this.id = Platform.getId();
			this.pName = Platform.getpName();
			this.pSort = Platform.getpSort();
		}
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpSort() {
        return pSort;
    }

    public void setpSort(Integer pSort) {
        this.pSort = pSort;
    }
}