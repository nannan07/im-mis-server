package com.allmsi.mis.third.model.vo;

public class FlowNodeOVo {
	private String id;

	private String flowId;

	private String nodeName;

	private String nodeType;

	public FlowNodeOVo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId == null ? null : flowId.trim();
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName == null ? null : nodeName.trim();
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType == null ? null : nodeType.trim();
	}
}