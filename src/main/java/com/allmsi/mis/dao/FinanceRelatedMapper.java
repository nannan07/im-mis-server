package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.FinanceRelated;

public interface FinanceRelatedMapper {
    int deleteByPrimaryKey(String id);

    int insert(FinanceRelated record);

    int insertSelective(FinanceRelated record);

    FinanceRelated selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FinanceRelated record);

    int updateByPrimaryKey(FinanceRelated record);
}