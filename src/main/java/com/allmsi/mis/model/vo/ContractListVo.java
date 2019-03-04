package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Contract;

public class ContractListVo {
	  private String id;

	    private String contTitle;

	    private String contUserDeptName;

	    private Integer totalAmount;

	    private Date dateofApplication;

	    private String contType;
	    
	    private String contTypeName;
	    
	    private String ourCompanyId;
	    
	    private String ourCompanyName;
	    
	    public ContractListVo() {
	    	
	    }
	    
	    public ContractListVo(Contract contract) {
	    	if(contract != null) {
			this.id = contract.getId();
			this.contTitle = contract.getContTitle();
			this.contUserDeptName = contract.getContUserDeptName();
			this.totalAmount = contract.getTotalAmount();
			this.dateofApplication = contract.getcTime();
			this.contType = contract.getContType();
			this.contTypeName = contract.getContTypeName();
			this.ourCompanyName = contract.getOurCompanyName();
			this.ourCompanyId = contract.getOurCompanyId();
	    	}
		}
	    
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id == null ? null : id.trim();
	    }


	    public String getContTitle() {
			return contTitle;
		}

		public void setContTitle(String contTitle) {
			this.contTitle = contTitle;
		}

		public String getContUserDeptName() {
			return contUserDeptName;
		}

		public void setContUserDeptName(String contUserDeptName) {
			this.contUserDeptName = contUserDeptName;
		}


		public Integer getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(Integer totalAmount) {
	        this.totalAmount = totalAmount;
	    }


		public Date getDateofApplication() {
			return dateofApplication;
		}

		public void setDateofApplication(Date dateofApplication) {
			this.dateofApplication = dateofApplication;
		}

		public String getContType() {
			return contType;
		}

		public void setContType(String contType) {
			this.contType = contType;
		}

		public String getContTypeName() {
			return contTypeName;
		}

		public void setContTypeName(String contTypeName) {
			this.contTypeName = contTypeName;
		}

		public String getOurCompanyName() {
			return ourCompanyName;
		}

		public void setOurCompanyName(String ourCompanyName) {
			this.ourCompanyName = ourCompanyName;
		}

		public String getOurCompanyId() {
			return ourCompanyId;
		}

		public void setOurCompanyId(String ourCompanyId) {
			this.ourCompanyId = ourCompanyId;
		}

}
