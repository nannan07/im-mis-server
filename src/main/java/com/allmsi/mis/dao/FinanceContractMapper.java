package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.FinanceContract;

public interface FinanceContractMapper {

    int insertSelective(FinanceContract record);

    FinanceContract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FinanceContract record);

    int updateByPrimaryKey(FinanceContract record);

	int insertBatch(List<FinanceContract> list);

	int deleteByFinId(String id);
}