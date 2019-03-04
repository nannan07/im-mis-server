package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.model.vo.ContractVo;
import com.allmsi.mis.service.ContractService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/cont")
public class ContractController extends BaseController {

	@Resource
	private ContractService contractService;

	/**
	 * 合同起草，草稿箱
	 * 
	 * @param contTitle
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	@ResponseBody
	public Object draft(@RequestHeader(AUTHORIZATION) String token, String search, Integer page,
			Integer pageSize) {
		return new SuccessProtocol(contractService.draft(token,search, page, pageSize));
	}

	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(contractService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(contractService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/byProjId/select", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId, Integer page, Integer pageSize) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(contractService.ListByProjId(projId, page, pageSize));
	}
	
	@RequestMapping(value = "/listByProj", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(contractService.selectListByProjId(projId));
	}
	
	@RequestMapping(value = "/listByFin", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByFin(String finId) {
		if (StrUtil.isEmpty(finId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(contractService.selectByFin(finId));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestHeader("Authorization") String token, ContractVo contractVo) {
		String checkParam = submit(token, contractVo, "");
		if (OperationMenu.WARN.equals(checkParam)) {
			return new WarnProtocol("", OperationMenu.PARAMETER_MSG);
		}
		return new SuccessProtocol("", checkParam);
	}

	/**
	 * 发起业务立项流程
	 * 
	 * @param ndList
	 * @param flowInfoVo
	 * 
	 * @param flowInstanceIVo
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public String submit(String token, ContractVo contractVo, String result) {
		String checkParam = checkParam(contractVo);
		if (OperationMenu.SUCCESS.equals(checkParam)) {
			return contractService.submit(token, contractVo, result);
		}
		return checkParam;
	}

	public String checkParam(ContractVo contractVo) {
		if (StrUtil.isEmpty(contractVo.getContTitle())
				|| StrUtil.isEmpty(contractVo.getContType()) || contractVo.getIsBiz() == null
				|| StrUtil.isEmpty(contractVo.getOurCompanyId())) {
			return OperationMenu.WARN;
		}
		return OperationMenu.SUCCESS;
	}
}
