package com.allmsi.mis.model.po;

import com.allmsi.mis.model.vo.FlowModuleVo;

public class FlowModule {
    private String id;

    private String flowCode;

    private String module;
    
    public FlowModule() {
  	}

    public FlowModule(FlowModuleVo flowModuleVo) {
  		if(flowModuleVo != null) {
  			this.id = flowModuleVo.getId();
  			this.flowCode = flowModuleVo.getFlowCode();
  			this.module = flowModuleVo.getModule();
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