package com.allmsi.mis.model.vo;

import com.allmsi.mis.model.po.FlowModule;

public class FlowModuleVo {
    private String id;

    private String flowCode;

    private String module;
    
    public FlowModuleVo() {
	}
    
    public FlowModuleVo(FlowModule flowModule) {
		if(flowModule != null) {
			this.id = flowModule.getId();
			this.flowCode = flowModule.getFlowCode();
			this.module = flowModule.getModule();
		}
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode == null ? null : flowCode.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }
}