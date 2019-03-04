package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Poster;

public class PosterVo {
    private String id;

    private String url;

    private String description;

    private Date cTime;

    public PosterVo(Poster poster) {
  		if(poster != null) {
  			this.id = poster.getId();
  			this.url = poster.getUrl();
  			this.description = poster.getDescription();
  			this.cTime = poster.getcTime();
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
}