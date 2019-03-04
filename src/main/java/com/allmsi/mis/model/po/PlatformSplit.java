package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.PlatformSplitVo;

public class PlatformSplit {
    private String id;

    private String platform;

    private Date subaccountDate;

    private Integer amount;

    private String note;

    private Date cTime;

    private Date uTime;

    private String issuedId;
    
    private String platformName;
    
    private Integer del;
    
    public PlatformSplit() {
		
	}
    
    public PlatformSplit(PlatformSplitVo platformSplitVo) {
		if(platformSplitVo != null) {
			this.id = platformSplitVo.getId();
			this.platform = platformSplitVo.getPlatform();
			this.subaccountDate = platformSplitVo.getSubaccountDate();
			this.amount = platformSplitVo.getAmount();
			this.note = platformSplitVo.getNote();
			this.cTime = platformSplitVo.getcTime();
			this.uTime = platformSplitVo.getuTime();
			this.issuedId = platformSplitVo.getIssuedId();
			this.platformName = platformSplitVo.getPlatformName();
		}
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Date getSubaccountDate() {
        return subaccountDate;
    }

    public void setSubaccountDate(Date subaccountDate) {
        this.subaccountDate = subaccountDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public String getIssuedId() {
		return issuedId;
	}

	public void setIssuedId(String issuedId) {
		this.issuedId = issuedId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}
    
}