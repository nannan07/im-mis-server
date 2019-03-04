package com.allmsi.mis.model.po;

import java.util.Date;

public class FinanceContract {
    private String id;

    private String finId;

    private String contId;

    private String contName;

    private Date cTime;

    private Date uTime;

    private Byte del;
    
	public FinanceContract() {
	}

	public FinanceContract(String id, String finId, String contId, String contName) {
		this.id = id;
		this.finId = finId;
		this.contId = contId;
		this.contName = contName;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFinId() {
        return finId;
    }

    public void setFinId(String finId) {
        this.finId = finId == null ? null : finId.trim();
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
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

    public Byte getDel() {
        return del;
    }

    public void setDel(Byte del) {
        this.del = del;
    }
}