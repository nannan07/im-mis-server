package com.allmsi.mis.model.po;

import java.util.Date;

import com.allmsi.mis.model.vo.ReceiptVo;

public class Receipt {
    private String id;

    private String contId;

    private Integer amountofThis;

    private Date receiptDate;

    private Integer isArrival;

    private String invoiceSituation;

    private String note;

    private Date cTime;

    private Date uTime;

    private Integer del;
    
    public Receipt() {

    }
    
    public Receipt(ReceiptVo receiptVo) {
    	if(receiptVo != null ) {
    		this.id = receiptVo.getId();
    		this.contId = receiptVo.getContId();
    		this.amountofThis = receiptVo.getAmountofThis();
    		this.receiptDate = receiptVo.getReceiptDate();
    		this.isArrival = receiptVo.getIsArrival();
    		this.invoiceSituation = receiptVo.getInvoiceSituation();
    		this.note = receiptVo.getNote();
    		this.cTime = receiptVo.getcTime();
    		this.uTime = receiptVo.getuTime();
    	}
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public Integer getAmountofThis() {
        return amountofThis;
    }

    public void setAmountofThis(Integer amountofThis) {
        this.amountofThis = amountofThis;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(Integer isArrival) {
        this.isArrival = isArrival;
    }

    public String getInvoiceSituation() {
        return invoiceSituation;
    }

    public void setInvoiceSituation(String invoiceSituation) {
        this.invoiceSituation = invoiceSituation == null ? null : invoiceSituation.trim();
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

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

}