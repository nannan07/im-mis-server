package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ProjectLssuedVo;

public class ProjectLssued {
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

    private Integer del;

    private String subaccountDate;
    
    public ProjectLssued() {
    	
    }
    
    public ProjectLssued(ProjectLssuedVo LssuedVo) {
		if(LssuedVo != null) {
			this.id = LssuedVo.getId();
			this.issuedId = LssuedVo.getIssuedId();
			this.actualRating = LssuedVo.getActualRating();
			this.onlineTime = LssuedVo.getOnlineTime();
			this.deviationOf = LssuedVo.getDeviationOf();
			this.projId = LssuedVo.getProjId();
			this.cTime = LssuedVo.getcTime();
			this.cUserId = LssuedVo.getcUserId();
			this.uTime = LssuedVo.getuTime();
			this.uUserId = LssuedVo.getuUserId();
			this.subaccountDate = LssuedVo.getSubaccountDate();
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
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