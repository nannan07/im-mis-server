package com.allmsi.mis.service;

import com.allmsi.mis.config.GeneralFlowModule;

public interface FlowInstenceStateObjService {

	GeneralFlowModule flowInstenceStateInfo(String token, String objId, String module);

	Object flowInstenceStatelog(String instanceId,Integer page,Integer pageSize);

}
