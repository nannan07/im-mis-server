package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.FlowModuleMapper;
import com.allmsi.mis.model.po.FlowModule;
import com.allmsi.mis.model.vo.FlowModuleVo;
import com.allmsi.mis.service.FlowModuleService;

@Service
public class FlowModuleServiceImpl implements FlowModuleService {

	@Resource
	private FlowModuleMapper flowModuleDao;
	
	@Override
	public String selectFlowCode(String module) {
		String flowCode = flowModuleDao.selectFlowCode(module);
		return flowCode;
	}

	@Override
	public String selectModule(String flowCode) {
		String module = flowModuleDao.selectModule(flowCode);
		return module;
	}

	@Override
	public List<FlowModuleVo> selectModuleByFlowCodes(List<String> flowCodeList) {
		List<FlowModuleVo> list = new ArrayList<FlowModuleVo>();
		if(flowCodeList != null && flowCodeList.size()>0) {
			List<FlowModule> list1 = flowModuleDao.selectModuleByFlowCodes(flowCodeList);
			for (FlowModule flowModule : list1) {
				list.add(new FlowModuleVo(flowModule));
			}
		}
		return list;
	}

}
