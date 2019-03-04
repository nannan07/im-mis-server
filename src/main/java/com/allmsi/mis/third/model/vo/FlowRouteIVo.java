package com.allmsi.mis.third.model.vo;

import java.util.Date;

public class FlowRouteIVo {

	private String id;

	private String flowId;

	private String routeName;

	private Date cTime;

	private String preNode;

	private String sufNode;

	private Integer isBack;

	private String preNodeName;

	private String preNodeType;

	private String sufNodeName;

	private String sufNodeType;

	private FlowUserModel user;

	// 路由处理
	private String routeDealType;

	private String query;

	public FlowRouteIVo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Integer getIsBack() {
		return isBack;
	}

	public void setIsBack(Integer isBack) {
		this.isBack = isBack;
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

	public String getPreNode() {
		return preNode;
	}

	public void setPreNode(String preNode) {
		this.preNode = preNode;
	}

	public String getSufNodeName() {
		return sufNodeName;
	}

	public void setSufNodeName(String sufNodeName) {
		this.sufNodeName = sufNodeName;
	}

	public String getSufNodeType() {
		return sufNodeType;
	}

	public void setSufNodeType(String sufNodeType) {
		this.sufNodeType = sufNodeType;
	}

	public FlowUserModel getUser() {
		return user;
	}

	public void setUser(FlowUserModel user) {
		this.user = user;
	}

	public String getSufNode() {
		return sufNode;
	}

	public void setSufNode(String sufNode) {
		this.sufNode = sufNode;
	}

	public String getRouteDealType() {
		return routeDealType;
	}

	public void setRouteDealType(String routeDealType) {
		this.routeDealType = routeDealType;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
