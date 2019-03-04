package com.allmsi.mis.third.model.vo;

public class SubmitGuidOVo {

	private String type;

	private String msg;

	private Object data;
	
	private boolean flag;

	public SubmitGuidOVo() {
	}

	public SubmitGuidOVo(String type, String msg) {
		this(type, msg, null);
	}

	public SubmitGuidOVo(String type, String msg, Object data) {
		this.type = type;
		this.msg = msg;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
