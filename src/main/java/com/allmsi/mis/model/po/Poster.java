package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.PosterVo;

public class Poster {
    private String id;

    private String url;

    private String description;

    private Date cTime;

    private Integer del;

    public Poster() {
    	
  	}
    
    public Poster(PosterVo posterVo) {
		if(posterVo != null) {
			this.id = posterVo.getId();
			this.url = posterVo.getUrl();
			this.description = posterVo.getDescription();
			this.cTime = posterVo.getcTime();
		}
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}