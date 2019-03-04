package com.allmsi.mis.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.model.vo.BusinessVo;
import com.allmsi.mis.service.BusinessService;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.model.protocol.WarnProtocol;
import com.allmsi.sys.util.StrUtil;

/**
 * 业务立项
 */
@Controller
@RequestMapping(value = "/proj/biz")
public class BusinessController extends BaseController {

	@Resource
	private BusinessService businessService;

	/**
	 * 草稿箱列表查询 业务立项
	 * 
	 * @param page
	 * @param pageSize
	 * @param projName
	 * @return
	 */
	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	@ResponseBody
	public Object draft(@RequestHeader(AUTHORIZATION) String token, String search, Integer page, Integer pageSize) {
		return new SuccessProtocol(businessService.draft(token, search, page, pageSize));
	}

	/**
	 * 业务立项详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/info/select", method = RequestMethod.GET)
	@ResponseBody
	public Object infoSelect(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(businessService.selectByPrimaryKey(id));
	}

	/**
	 * 出品类
	 */
	private boolean getProducedType(BusinessVo businessVo) {
		// if (StrUtil.notEmpty(businessVo.getRecordSituation())
		// && StrUtil.notEmpty(businessVo.getEstimatedRating()) &&
		// StrUtil.notEmpty(businessVo.getProjNo())
		// && StrUtil.notEmpty(businessVo.getIsProectTeam()) &&
		// StrUtil.notEmpty(businessVo.getContentType())
		// && StrUtil.notEmpty(businessVo.getDeclareType()) &&
		// StrUtil.notEmpty(businessVo.getProducedType())
		// && businessVo.getPromotionBudget() != null &&
		// StrUtil.notEmpty(businessVo.getPromotionDirection())) {
		// businessVo.setMarketingType("");
		// return true;
		// } else {
		// return false;
		// }
		return true;
	}

	/**
	 * 纯宣发
	 */
	private boolean getDeclareType(BusinessVo businessVo) {
		if (StrUtil.notEmpty(businessVo.getPromotionUserId()) && StrUtil.notEmpty(businessVo.getPromotionUserName())
				&& StrUtil.notEmpty(businessVo.getReleaseManagerId())
				&& StrUtil.notEmpty(businessVo.getReleaseManagerName())
				&& StrUtil.notEmpty(businessVo.getRecordSituation())
				&& StrUtil.notEmpty(businessVo.getEstimatedRating()) && StrUtil.notEmpty(businessVo.getProjNo())
				&& StrUtil.notEmpty(businessVo.getIsProectTeam()) && StrUtil.notEmpty(businessVo.getContentType())
				&& StrUtil.notEmpty(businessVo.getDeclareType()) && StrUtil.notEmpty(businessVo.getPromotionDirection())
				&& businessVo.getPromotionBudget() != null) {
			businessVo.setMarketingType("");
			businessVo.setProducedType("");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 营销类
	 */
	private boolean getMarketingType(BusinessVo businessVo) {
		if (StrUtil.notEmpty(businessVo.getMarketingType())) {
			businessVo.setPromotionUserId("");
			businessVo.setPromotionUserName("");
			businessVo.setReleaseManagerId("");
			businessVo.setReleaseManagerName("");
			businessVo.setRecordSituation("");
			businessVo.setEstimatedRating("");
			businessVo.setIsProectTeam("");
			businessVo.setContentType("");
			businessVo.setProducedType("");
			businessVo.setDeclareType("");
			businessVo.setPromotionBudget("");
			businessVo.setPromotionDirection("");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 其他类
	 */
	private boolean getOther(BusinessVo businessVo) {
		businessVo.setPromotionUserId("");
		businessVo.setPromotionUserName("");
		businessVo.setReleaseManagerId("");
		businessVo.setReleaseManagerName("");
		businessVo.setRecordSituation("");
		businessVo.setEstimatedRating("");
		businessVo.setIsProectTeam("");
		businessVo.setContentType("");
		businessVo.setProducedType("");
		businessVo.setDeclareType("");
		businessVo.setPromotionBudget("");
		businessVo.setPromotionDirection("");
		businessVo.setMarketingType("");
		return true;
	}

	/**
	 * 发起和修改业务立项
	 * 
	 * @param businessVo
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestHeader("Authorization") String token, BusinessVo businessVo) {
		String checkParam = submit(token, businessVo, "");
		if (OperationMenu.WARN.equals(checkParam)) {
			return new WarnProtocol("", OperationMenu.PARAMETER_MSG);
		}
		return new SuccessProtocol("", checkParam);
	}

	/**
	 * 发起业务立项流程
	 * 
	 * @param flowInfoVo
	 * @param nodeDealList
	 * 
	 * @param flowInstanceIVo
	 * @return
	 */
	public String submit(String token, BusinessVo businessVo, String result) {
		String checkParam = checkParam(businessVo);
		if (OperationMenu.SUCCESS.equals(checkParam)) {
			return businessService.submit(token, businessVo, result);
		}
		return checkParam;
	}

	public String checkParam(BusinessVo businessVo) {
		if (StrUtil.notEmpty(businessVo.getProjName()) && businessVo.getBizTime() != null
				&& StrUtil.notEmpty(businessVo.getProjType())) {
			if ("09".equals(businessVo.getProjType())) {
				if (getProducedType(businessVo) == false) {
					return OperationMenu.WARN;
				}
			} else if ("10".equals(businessVo.getProjType())) {
				if (getDeclareType(businessVo) == false) {
					return OperationMenu.WARN;
				}
			} else if ("12".equals(businessVo.getProjType())) {
				if (getMarketingType(businessVo) == false) {
					return OperationMenu.WARN;
				}
			} else if ("13".equals(businessVo.getProjType())) {
				if (getOther(businessVo) == false) {
					return OperationMenu.WARN;
				}
			} else {
				return OperationMenu.WARN;
			}
			return OperationMenu.SUCCESS;
		} else {
			return OperationMenu.WARN;
		}
	}

	/**
	 * 删除业务立项 添加删除判断，当待办或待阅表中有该业务信息时不可删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(String id) {
		if (StrUtil.isEmpty(id)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(businessService.deleteByPrimaryKey(id));
	}

	@RequestMapping(value = "/byProjId/select", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByProjId(String projId, Integer page, Integer pageSize) {
		if (StrUtil.isEmpty(projId)) {
			return new WarnProtocol("必填信息不能为空");
		}
		return new SuccessProtocol(businessService.selectByProjId(projId, page, pageSize));
	}
}
