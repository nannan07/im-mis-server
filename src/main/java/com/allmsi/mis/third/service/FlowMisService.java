package com.allmsi.mis.third.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.allmsi.mis.third.model.vo.NodeDealVo;

@FeignClient(value = "flow-server-3")
public interface FlowMisService {

	@RequestMapping(value = "/flowInstenceState/info", method = RequestMethod.GET)
	String flowInstenceStateInfo(@RequestParam("objId") String objId, @RequestParam("userId") String userId);

	@RequestMapping(value = "/bus/guide", method = RequestMethod.GET)
	String guide(@RequestParam("flowCode") String flowCode, @RequestParam("instanceId") String instanceId,
			@RequestParam("nodeId") String nodeId, @RequestParam("isback") String isback,
			@RequestParam("routeId") String routeId, @RequestParam("query") String query,
			@RequestParam("userId") String userId);

	@RequestMapping(value = "/bus/submit", method = RequestMethod.POST)
	String submit(@RequestParam("flowId") String flowId, @RequestParam("objId") String objId,
			@RequestParam("instanceId") String instanceId, @RequestParam("preNodeId") String preNodeId,
			@RequestParam("sufNodeId") String sufNodeId, @RequestParam("preDealId") String preDealId,
			@RequestParam("remark") String remark, @RequestParam("routeId") String routeId,
			@RequestParam("objName") String objName, @RequestParam("urgentLevel") String urgentLevel,
			@RequestParam("objValue1") String objValue1, @RequestParam("objValue2") String objValue2,
			@RequestParam("objValue3") String objValue3, @RequestParam("objValue4") String objValue4,
			@RequestParam("objValue5") String objValue5, @RequestBody List<NodeDealVo> flowRouteDealList);

	@RequestMapping(value = "/flowInstance/selectById", method = RequestMethod.GET)
	String selectById(@RequestParam("instanceId") String instanceId);

	@RequestMapping(value = "/flow/todo", method = RequestMethod.GET)
	String todoList(@RequestParam("userId") String userId, @RequestParam("search") String search,
			@RequestParam("flowCode") String flowCode, @RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize);

	@RequestMapping(value = "/flow/done", method = RequestMethod.GET)
	String doneList(@RequestParam("userId") String userId, @RequestParam("search") String search,
			@RequestParam("flowCode") String flowCode, @RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize);

	@RequestMapping(value = "/flow/urgentCount", method = RequestMethod.GET)
	Integer urgentLevel(@RequestParam("userId") String userId);

	@RequestMapping(value = "/flow/toall", method = RequestMethod.GET)
	String toall(@RequestParam("userId") String userId);

	@RequestMapping(value = "/flow/todoCount", method = RequestMethod.GET)
	Integer todoCount(@RequestParam("userId") String userId);

	@RequestMapping(value = "/flow/self", method = RequestMethod.GET)
	String self(@RequestParam("userId") String userId, @RequestParam("search") String search,
			@RequestParam("flowCode") String flowCode, @RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize);

	@RequestMapping(value = "/flowInstenceState/log", method = RequestMethod.GET)
	String log(@RequestParam("instanceId") String instanceId, @RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize);

	@RequestMapping(value = "/flow/dept", method = RequestMethod.GET)
	String dept(@RequestParam("search") String search, @RequestParam("flowCode") String flowCode,
			@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("depts") List<String> depts);
}
