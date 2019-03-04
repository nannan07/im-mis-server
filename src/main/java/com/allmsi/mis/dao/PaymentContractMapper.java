package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.PaymentContract;

public interface PaymentContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(PaymentContract record);

    int insertSelective(PaymentContract record);

    PaymentContract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PaymentContract record);

    int updateByPrimaryKey(PaymentContract record);
}