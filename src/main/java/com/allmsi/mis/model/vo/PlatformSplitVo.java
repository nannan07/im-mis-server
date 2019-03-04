package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.PlatformSplit;

public class PlatformSplitVo {
    private String id;

    private String platform;

    private String platformName;
    
    private Date subaccountDate;

    private Integer amount;

    private String note;

    private Date cTime;

    private Date uTime;

    private String issuedId;
    
    public PlatformSplitVo() {
		
	}
    
    public PlatformSplitVo(PlatformSplit PlatformSplit) {
		if(PlatformSplit != null) {
			this.id = PlatformSplit.getId();
			this.platform = PlatformSplit.getPlatform();
			this.subaccountDate = PlatformSplit.getSubaccountDate();
			this.amount = PlatformSplit.getAmount();
			this.note = PlatformSplit.getNote();
			this.cTime = PlatformSplit.getcTime();
			this.uTime = PlatformSplit.getuTime();
			this.issuedId = PlatformSplit.getIssuedId();
			this.platformName = PlatformSplit.getPlatformName();
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
    
}