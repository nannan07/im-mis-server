package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.model.vo.FinanceVo;
import com.allmsi.mis.service.FinanceService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

/**
 * 财务立项
 */
@Controller
@RequestMapping(value = "/fin")
public class FinanceController extends BaseController {

	@Resource
	private FinanceService financeService;

	/**
	 * 草稿箱列表查询
	 * 
	 * @param page
	 * @param pageSize
	 * @param projName
	 * @return
	 */
	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	@ResponseBody
	public Object draft(@RequestHeader(AUTHORIZATION) String token,String search, Integer page, Integer pageSize) {
		return new SuccessProtocol(financeService.draft(token,search, page, pageSize));
	}

	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(financeService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestHeader("Authorization") String token,FinanceVo financeVo) {
		String checkParam = submit(token, financeVo,"");
		
		System.out.println("checkParam---"+checkParam);
		if (OperationMenu.WARN.equals(checkParam)) {
			return new WarnProtocol("",OperationMenu.PARAMETER_MSG);
		}
		return new SuccessProtocol("", checkParam);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(financeService.deleteByPrimaryKey(id));
	}

	/**
	 * 发起业务立项流程
	 * 
	 * @param flowInstanceIVo
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public String submit(String token,FinanceVo financeVo,String result) {
		String checkParam = checkParam(financeVo);
		if (OperationMenu.SUCCESS.equals(checkParam)) {
			return financeService.submit(token, financeVo,result);
		}
		return checkParam;
	}

	public String checkParam(FinanceVo financeVo) {
		if(StrUtil.isEmpty(financeVo.getFinName())) {
			return OperationMenu.WARN;
		}
		return OperationMenu.SUCCESS;
	}
	
	@RequestMapping(value = "/byProjId/select", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId,Integer page,Integer pageSize) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(financeService.selectByProjId(projId, page, pageSize));
	}
	
	@RequestMapping(value = "/listByProj", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(financeService.selectListByProjId(projId));
	}

}
