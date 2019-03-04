package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.Payment;

public interface PaymentMapper {

	List<Payment> draft(Map<String, Object> map);
	
    int deleteByPrimaryKey(String id);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Payment record);

    List<Payment> selectPaymentList(Map<String,Object> map);

	List<Payment> selectByProjId(String projId);
	
	List<Payment> selectByIds(List<String> objIds);
}