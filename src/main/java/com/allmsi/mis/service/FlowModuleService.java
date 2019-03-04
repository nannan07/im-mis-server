package com.allmsi.mis.service;

import java.util.List;

import com.allmsi.mis.model.vo.FlowModuleVo;

public interface FlowModuleService {

	String selectFlowCode(String module);

	String selectModule(String flowCode);

	List<FlowModuleVo> selectModuleByFlowCodes(List<String> flowCodeList);
}
