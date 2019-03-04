package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.model.vo.PaymentVo;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/pay")
public class PaymentController extends BaseController {

	@Resource
	private PaymentService paymentService;

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
	public Object draft(@RequestHeader(AUTHORIZATION) String token, String search, Integer page, Integer pageSize) {
		return new SuccessProtocol(paymentService.draft(token, search, page, pageSize));
	}

	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(paymentService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestHeader(AUTHORIZATION) String token, PaymentVo paymentVo) {
		String checkParam = submit(token, paymentVo, "");
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
		return new SuccessProtocol(paymentService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public String submit(String token, PaymentVo paymentVo, String result) {
		String checkParam = checkParam(paymentVo);
		if (OperationMenu.SUCCESS.equals(checkParam)) {
			return paymentService.submit(token, paymentVo, result);
		}
		return checkParam;
	}

	public String checkParam(PaymentVo paymentVo) {
		System.out.println("1--------------");
		if (StrUtil.isEmpty(paymentVo.getPayName()) || paymentVo.getIsSingle() == null || StrUtil.isEmpty(paymentVo.getPayCause())
				|| paymentVo.getPayAmount() == null || StrUtil.isEmpty(paymentVo.getPayCompanyId())
				|| paymentVo.getIsInvoice() == null || StrUtil.isEmpty(paymentVo.getAccountBank())
				|| StrUtil.isEmpty(paymentVo.getBankAccount()) || StrUtil.isEmpty(paymentVo.getBeneficiary())) {
			System.out.println("2-------------");
			return OperationMenu.WARN;
		}
		return OperationMenu.SUCCESS;
	}

	@RequestMapping(value = "/byProjId/select", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId, Integer page, Integer pageSize) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(paymentService.selectByProjId(projId, page, pageSize));
	}
}
