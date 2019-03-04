package com.allmsi.mis.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.allmsi.mis.third.model.vo.NodeDealVo;

public class FlowBaseVo {

	private String flowId;

	private String instanceId;

	private String nodeId;

	private String routeId;

	private String preDealId;

	private String remark;

	private List<NodeDealVo> flowRouteDealList = new ArrayList<NodeDealVo>();

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<NodeDealVo> getFlowRouteDealList() {
		return flowRouteDealList;
	}

	public void setFlowRouteDealList(List<NodeDealVo> flowRouteDealList) {
		this.flowRouteDealList = flowRouteDealList;
	}

}
