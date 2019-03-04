package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.model.vo.PlatformSplitVo;
import com.allmsi.mis.service.PlatformSplitService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping(value = "/platform/split")
public class PlatformSplitController {

	@Resource
	private PlatformSplitService platformSplitService;
	
	@RequestMapping(value = "/list/select", method = RequestMethod.GET)
	@ResponseBody
	public Object listSelect(Integer page,Integer pageSize) {
		return new SuccessProtocol(platformSplitService.selectList(page, pageSize));
	}

	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if(StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(platformSplitService.selectByPrimaryKey(id));
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(PlatformSplitVo platformSplitVo) {
		String id = "";
		if (StrUtil.notEmpty(platformSplitVo.getPlatform())) {
			id = platformSplitService.save(platformSplitVo);
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
		return new SuccessProtocol(platformSplitService.del(id));
	}

}
