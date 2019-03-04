package com.allmsi.mis.third.model.vo;

import java.util.List;

public class FlowInstenceCurrencyOVO {

	private String urgentLevel;
	
	private String stateId;

	private String instanceId;

	private String preNodeId;
	
	private String sufNodeId;

	private String routeId;

	private String preDealId;

	private String sufDealId;

	private String sufDealType;

	private String sufAuthType;

	private String uTime;

	private String uUserId;

	// node
	private String preNodeName;

	private String preNodeType;

	// route
	private String routeName;

	// flow
	private String flowId;

	private String flowCode;

	private String objectId;
	
	private String remark;
	
	
	//button
	private List<FlowNodeButtonSimpleOVO> nodeButtonList;

	public FlowInstenceCurrencyOVO() {
	}

	public String getUrgentLevel() {
		return urgentLevel;
	}

	public void setUrgentLevel(String urgentLevel) {
		this.urgentLevel = urgentLevel;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getPreDealId() {
		return preDealId;
	}

	public void setPreDealId(String preDealId) {
		this.preDealId = preDealId;
	}

	public String getSufDealId() {
		return sufDealId;
	}

	public void setSufDealId(String sufDealId) {
		this.sufDealId = sufDealId;
	}

	public String getSufDealType() {
		return sufDealType;
	}

	public void setSufDealType(String sufDealType) {
		this.sufDealType = sufDealType;
	}

	public String getSufAuthType() {
		return sufAuthType;
	}

	public void setSufAuthType(String sufAuthType) {
		this.sufAuthType = sufAuthType;
	}

	public String getuTime() {
		return uTime;
	}

	public void setuTime(String uTime) {
		this.uTime = uTime;
	}

	public String getuUserId() {
		return uUserId;
	}

	public void setuUserId(String uUserId) {
		this.uUserId = uUserId;
	}

	public String getPreNodeName() {
		return preNodeName;
	}

	public void setPreNodeName(String preNodeName) {
		this.preNodeName = preNodeName;
	}

	public String getPreNodeType() {
		return preNodeType;
	}

	public void setPreNodeType(String preNodeType) {
		this.preNodeType = preNodeType;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public List<FlowNodeButtonSimpleOVO> getNodeButtonList() {
		return nodeButtonList;
	}

	public void setNodeButtonList(List<FlowNodeButtonSimpleOVO> nodeButtonList) {
		this.nodeButtonList = nodeButtonList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPreNodeId() {
		return preNodeId;
	}

	public void setPreNodeId(String preNodeId) {
		this.preNodeId = preNodeId;
	}

	public String getSufNodeId() {
		return sufNodeId;
	}

	public void setSufNodeId(String sufNodeId) {
		this.sufNodeId = sufNodeId;
	}

}
