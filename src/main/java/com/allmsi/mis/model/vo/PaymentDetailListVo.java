package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Payment;

public class PaymentDetailListVo {
	 	private String id;

	    private String payDeptName;

	    private String payDeptId;
	    
	    private String managerId;

	    private String managerName;
	    
	    private String payName;

	    private Integer payAmount;

	    private Date cTime;

	    private String payWay;
	    
	    private String payWayName;
	    
	    private String payCompanyId;
	    
	    private String payCompanyName;
	    
	    public PaymentDetailListVo() {
	    	
	    }
	    
	    public PaymentDetailListVo(Payment payment) {
			if(payment != null) {
				this.id = payment.getId();
				this.payDeptName = payment.getPayDeptName();
				this.payAmount = payment.getPayAmount();
				this.payName = payment.getPayName();
				this.cTime = payment.getcTime();
				this.payDeptId = payment.getPayDeptId();
				this.managerId = payment.getManagerId();
				this.managerName = payment.getManagerName();
				this.payWayName = payment.getPayWayName();
				this.payCompanyName = payment.getPayCompanyName();
				this.payWay = payment.getPayWay();
				this.payCompanyId = payment.getPayCompanyId();
			}
		}
	    
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id == null ? null : id.trim();
	    }

	    public String getPayDeptName() {
	        return payDeptName;
	    }

	    public void setPayDeptName(String payDeptName) {
	        this.payDeptName = payDeptName == null ? null : payDeptName.trim();
	    }

	    public Integer getPayAmount() {
	        return payAmount;
	    }

	    public void setPayAmount(Integer payAmount) {
	        this.payAmount = payAmount;
	    }

		public String getPayName() {
			return payName;
		}

		public void setPayName(String payName) {
			this.payName = payName;
		}

		public Date getcTime() {
			return cTime;
		}

		public void setcTime(Date cTime) {
			this.cTime = cTime;
		}

		public String getPayDeptId() {
			return payDeptId;
		}

		public void setPayDeptId(String payDeptId) {
			this.payDeptId = payDeptId;
		}

		public String getManagerId() {
			return managerId;
		}

		public void setManagerId(String managerId) {
			this.managerId = managerId;
		}

		public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}

		public String getPayWayName() {
			return payWayName;
		}

		public void setPayWayName(String payWayName) {
			this.payWayName = payWayName;
		}

		public String getPayCompanyName() {
			return payCompanyName;
		}

		public void setPayCompanyName(String payCompanyName) {
			this.payCompanyName = payCompanyName;
		}

		public String getPayWay() {
			return payWay;
		}

		public void setPayWay(String payWay) {
			this.payWay = payWay;
		}

		public String getPayCompanyId() {
			return payCompanyId;
		}

		public void setPayCompanyId(String payCompanyId) {
			this.payCompanyId = payCompanyId;
		}

}
