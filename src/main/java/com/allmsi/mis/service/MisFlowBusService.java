package com.allmsi.mis.service;

import com.allmsi.mis.model.vo.BusGuideVo;
import com.allmsi.mis.third.model.vo.SubmitGuidOVo;
import com.google.gson.JsonElement;

public interface MisFlowBusService {

	BusGuideVo guide(String module, String instanceId, String nodeId, String isback,String routeId, String query, String userId);

	SubmitGuidOVo submit(String token, JsonElement module, JsonElement flowInfo, JsonElement moduleInfo,
			JsonElement nodeDealList);
}
