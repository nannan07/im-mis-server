package com.allmsi.mis.third.model.vo;

public class FlowNodeButtonSimpleOVO {
	private String buttonName;

	private String buttonType;

	public FlowNodeButtonSimpleOVO() {
	}

	public FlowNodeButtonSimpleOVO(String buttonName, String buttonType) {
		this.buttonName = buttonName;
		this.buttonType = buttonType;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

}
