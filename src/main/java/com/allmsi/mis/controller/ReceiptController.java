package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.model.vo.ReceiptVo;
import com.allmsi.mis.service.ReceiptService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/receipt")
public class ReceiptController {

	@Resource
	private ReceiptService receiptService;
	
	@RequestMapping(value = "/list/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(String contId,Integer page,Integer pageSize) {
		if(StrUtil.isEmpty(contId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(receiptService.selectReceiptList(contId, page, pageSize));
	}
	
	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(String id) {
		if(StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(receiptService.selectByPrimaryKey(id));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(ReceiptVo receiptVo) {
		String id = "";
		if (StrUtil.notEmpty(receiptVo.getContId())) {
			id = receiptService.save(receiptVo);
		} else {
			return new WarnProtocol("必填信息不能为空");
		}
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol("", id);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(receiptService.del(id));
	}

}
