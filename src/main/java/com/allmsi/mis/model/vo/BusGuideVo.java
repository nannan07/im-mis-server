package com.allmsi.mis.model.vo;

import java.util.List;

import com.allmsi.mis.third.model.vo.FlowRouteIVo;
import com.allmsi.mis.third.model.vo.FlowUserModel;

public class BusGuideVo {

	private String type;

	private String msg;

	private List<FlowUserModel> flowUserList;

	private List<FlowRouteIVo> flowRouteList;

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

	public List<FlowUserModel> getFlowUserList() {
		return flowUserList;
	}

	public void setFlowUserList(List<FlowUserModel> flowUserList) {
		this.flowUserList = flowUserList;
	}

	public List<FlowRouteIVo> getFlowRouteList() {
		return flowRouteList;
	}

	public void setFlowRouteList(List<FlowRouteIVo> flowRouteList) {
		this.flowRouteList = flowRouteList;
	}
}
