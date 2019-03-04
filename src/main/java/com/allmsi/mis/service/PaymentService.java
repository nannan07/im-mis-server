package com.allmsi.mis.service;

import java.util.List;

import com.allmsi.mis.model.vo.PaymentVo;
import com.allmsi.sys.model.ListBean;

public interface PaymentService {

	ListBean draft(String token, String search, Integer page, Integer pageSize);
	
	List<PaymentVo> selectByProjId(String projId);

	PaymentVo selectByPrimaryKey(String id);

	//ListBean selectPaymentList(String projId, String payName, String cTime, Integer page, Integer pageSize);

	String save(String token,PaymentVo paymentVo);

	String submit(String token, PaymentVo paymentVo,String result);

	String successful(String id);

	boolean deleteByPrimaryKey(String id);
	
	ListBean selectByProjId(String projId,Integer page,Integer pageSize);
	
	List<PaymentVo> selectByIds(List<String> objIds);
}
