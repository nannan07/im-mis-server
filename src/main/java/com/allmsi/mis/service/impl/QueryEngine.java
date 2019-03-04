package com.allmsi.mis.service.impl;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.config.EnvYml;
import com.allmsi.mis.config.FlowCodeModuleMapping;
import com.allmsi.mis.service.BusinessService;
import com.allmsi.mis.service.ContractService;
import com.allmsi.mis.service.FinanceService;
import com.allmsi.mis.service.PaymentService;
import com.allmsi.sys.util.StrUtil;

@Service
public class QueryEngine {

	@Resource
	private BusinessService businessService;

	@Resource
	private ContractService contractService;

	@Resource
	private FinanceService financeService;

	@Resource
	private PaymentService paymentService;

	@Resource
	private EnvYml envYml;

	public String getQuery(String module, String routeQuery, String objId) {
		if (StrUtil.isEmpty(module)) {
			return null;
		}
		System.out.println("routeQuery----"+routeQuery);
		
		Object obj = null;
		switch (module) {
		case FlowCodeModuleMapping.MODEL_BIZ:// 业务系统
			obj = businessService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_CONT:// 合同系统
			obj = contractService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_FIN:// 财务系统
			obj = financeService.selectByPrimaryKey(objId);
			break;
		case FlowCodeModuleMapping.MODEL_PAY:// 付款系统
			obj = paymentService.selectByPrimaryKey(objId);
			break;
		default:
			break;
		}
		return getQuery(routeQuery, obj);
	}

	private String getQuery(String routeQuery, Object obj) {
		String query = "";
		String[] strs = routeQuery.split(";");
		for (String string : strs) {
			try {
				Object value = reflectPrivateField(obj, string);
				query = query + string + ":" + value + ";";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (query.endsWith(";")) {
			query = query.substring(0, query.length() - 1);
		}
		System.out.println("query----"+query);
		return query;
	}

	public Object reflectPrivateField(Object obj, String filedName) throws Exception {
		// 将person类加载到内存中
		Class<?> clazz = obj.getClass();
		// 因为是私有字段，需要通过getDeclaredField该方法传入字段的名字获取对应的字段
		Field filed = clazz.getDeclaredField(filedName);
		// 释放权限，设为可见
		filed.setAccessible(true);
		// 传入一个对象，来获取该对象的值
		Object objValue = filed.get(obj);
		return objValue;
	}
}
