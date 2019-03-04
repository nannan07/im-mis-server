package com.allmsi.mis.model.vo;

import java.util.Date;

import com.allmsi.mis.model.po.Finance;

public class FinanceListVo {
		private String id;

	    private String finTime;

	    private Date cTime;
	    
	    private String finUserId;

	    private String finUserName;

	    private String finUserDept;

	    private String finUserDeptName;
	    
	    private String finName;
	    
	    private String projName;
	    
	    private String contTitle;
	    
		public FinanceListVo() {
	    	
	    }
	    
	    public FinanceListVo(Finance Finance) {
			if(Finance != null) {
				this.id = Finance.getId();
				this.finTime = Finance.getFinTime();
				this.finUserName = Finance.getFinUserName();
				this.finUserId = Finance.getFinUserId();
				this.finUserDept = Finance.getFinUserDept();
				this.finUserDeptName = Finance.getFinUserDeptName();
				this.cTime = Finance.getcTime();
				this.finName = Finance.getFinName();
				this.projName = Finance.getProjName();
				this.contTitle = Finance.getContTitle();
			}
		}
	    
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id == null ? null : id.trim();
	    }

		public String getFinTime() {
	        return finTime;
	    }

	    public void setFinTime(String finTime) {
	        this.finTime = finTime;
	    }

	    public String getFinUserName() {
	        return finUserName;
	    }

	    public void setFinUserName(String finUserName) {
	        this.finUserName = finUserName == null ? null : finUserName.trim();
	    }

		public String getFinUserId() {
			return finUserId;
		}

		public void setFinUserId(String finUserId) {
			this.finUserId = finUserId;
		}

		public String getFinUserDept() {
			return finUserDept;
		}

		public void setFinUserDept(String finUserDept) {
			this.finUserDept = finUserDept;
		}

		public String getFinUserDeptName() {
			return finUserDeptName;
		}

		public void setFinUserDeptName(String finUserDeptName) {
			this.finUserDeptName = finUserDeptName;
		}

		public Date getcTime() {
			return cTime;
		}

		public void setcTime(Date cTime) {
			this.cTime = cTime;
		}

		public String getFinName() {
			return finName;
		}

		public void setFinName(String finName) {
			this.finName = finName;
		}

		public String getProjName() {
			return projName;
		}

		public void setProjName(String projName) {
			this.projName = projName;
		}

		public String getContTitle() {
			return contTitle;
		}

		public void setContTitle(String contTitle) {
			this.contTitle = contTitle;
		}
		
}
