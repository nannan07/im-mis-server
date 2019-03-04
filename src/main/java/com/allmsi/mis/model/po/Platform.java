package com.allmsi.mis.model.po;

import com.allmsi.mis.model.vo.PlatformVo;

public class Platform {
    private String id;

    private String pName;

    private Integer pSort;

    private Integer del;

    public Platform() {
    	
    }
    
    public Platform(PlatformVo PlatformVo) {
		if(PlatformVo != null) {
			this.id = PlatformVo.getId();
			this.pName = PlatformVo.getpName();
			this.pSort = PlatformVo.getpSort();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}