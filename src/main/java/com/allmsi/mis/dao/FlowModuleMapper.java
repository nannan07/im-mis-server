package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.FlowModule;

public interface FlowModuleMapper {
   
    String selectFlowCode(String module);

	String selectModule(String flowCode);

	List<FlowModule> selectModuleByFlowCodes(List<String> flowCodeList);
}