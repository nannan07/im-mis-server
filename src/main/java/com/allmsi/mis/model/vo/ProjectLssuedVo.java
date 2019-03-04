package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.ProjectLssued;

public class ProjectLssuedVo {
    private String id;

    private String issuedId;

    private String issuedName;
    
    private String actualRating;

    private Date onlineTime;

    private String deviationOf;

    private String projId;

    private Date cTime;

    private String cUserId;

    private Date uTime;

    private String uUserId;

    private String subaccountDate;
    
    public ProjectLssuedVo() {
    	
    }
    
    public ProjectLssuedVo(ProjectLssued Lssued) {
		if(Lssued != null) {
			this.id = Lssued.getId();
			this.issuedId = Lssued.getIssuedId();
			this.actualRating = Lssued.getActualRating();
			this.onlineTime = Lssued.getOnlineTime();
			this.deviationOf = Lssued.getDeviationOf();
			this.projId = Lssued.getProjId();
			this.cTime = Lssued.getcTime();
			this.cUserId = Lssued.getcUserId();
			this.uTime = Lssued.getuTime();
			this.uUserId = Lssued.getuUserId();
			this.issuedName = Lssued.getIssuedName();
			this.subaccountDate = Lssued.getSubaccountDate();
		}
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIssuedId() {
        return issuedId;
    }

    public void setIssuedId(String issuedId) {
        this.issuedId = issuedId == null ? null : issuedId.trim();
    }

    public String getActualRating() {
        return actualRating;
    }

    public void setActualRating(String actualRating) {
        this.actualRating = actualRating == null ? null : actualRating.trim();
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getDeviationOf() {
        return deviationOf;
    }

    public void setDeviationOf(String deviationOf) {
        this.deviationOf = deviationOf == null ? null : deviationOf.trim();
    }

    public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
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

	public String getIssuedName() {
		return issuedName;
	}

	public void setIssuedName(String issuedName) {
		this.issuedName = issuedName;
	}

	public String getSubaccountDate() {
		return subaccountDate;
	}

	public void setSubaccountDate(String subaccountDate) {
		this.subaccountDate = subaccountDate;
	}
    
}