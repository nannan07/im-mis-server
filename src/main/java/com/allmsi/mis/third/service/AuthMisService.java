package com.allmsi.mis.third.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth-server-1")
public interface AuthMisService {

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	Object login(@RequestParam("sToken") String sToken, @RequestParam("loginName") String loginName,
			@RequestParam("password") String password);

	@RequestMapping(value = "/auth/select/userList", method = RequestMethod.GET)
	String selectUserList(@RequestParam("userIds") List<String> userIds);

	@RequestMapping(value = "/auth/select/userInfo", method = RequestMethod.GET)
	String selectUserInfo(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/userInfo/token", method = RequestMethod.GET)
	String selectUserInfoBytoken(@RequestParam("token") String token);

	@RequestMapping(value = "/auth/select/roleUser", method = RequestMethod.GET)
	String getUserListByRole(@RequestParam("roleId") String roleId);

	@RequestMapping(value = "/auth/select/deptUser", method = RequestMethod.GET)
	String getUserListByDept(@RequestParam("deptId") String deptId);

	@RequestMapping(value = "/auth/select/deptUserByUser", method = RequestMethod.GET)
	String getDeptUsersByUserId(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/allDeptUserByUser", method = RequestMethod.GET)
	String getAllDeptUsersByUserId(@RequestParam("userId") String userId);

	/**
	 * 一级部门下的用户
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/auth/select/allOneThDeptUserByUser", method = RequestMethod.GET)
	String getAllOneThDeptUserByUserId(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/deptList", method = RequestMethod.GET)
	String selectDeptList(@RequestParam("deptIds") List<String> deptIds);

	@RequestMapping(value = "/auth/select/deptInfo", method = RequestMethod.GET)
	String selectDeptInfo(@RequestParam("deptId") String deptId);

	@RequestMapping(value = "/auth/select/userDept", method = RequestMethod.GET)
	String selectDeptListByUserId(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/parentDeptByUserId", method = RequestMethod.GET)
	String selectParentDeptByUserId(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/roleList", method = RequestMethod.GET)
	String selectRoleList(@RequestParam("roleIds") List<String> roleIds);

	@RequestMapping(value = "/auth/select/roleInfo", method = RequestMethod.GET)
	String selectRoleInfo(@RequestParam("roleId") String roleId);

	@RequestMapping(value = "/auth/select/user/role", method = RequestMethod.GET)
	String selectRoleListByUserId(@RequestParam("userId") String userId);

	@RequestMapping(value = "/auth/select/subDeptUser", method = RequestMethod.GET)
	String selectSubDeptUser(@RequestParam("deptId") String deptId);

	@RequestMapping(value = "/auth/res/isVisit", method = RequestMethod.GET)
	String resIsVisit(@RequestParam("token") String token, @RequestParam("resUrl") String resUrl);

	@RequestMapping(value = "/auth/select/UserDepts", method = RequestMethod.GET)
	String UserDepts(@RequestParam("userId") String userId);
}
