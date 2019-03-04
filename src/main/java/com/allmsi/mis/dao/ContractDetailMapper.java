package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.ContractDetail;
import com.allmsi.mis.model.po.ContractPartner;

public interface ContractDetailMapper {
    int deleteByPrimaryKey(ContractPartner record);

    int insertSelective(ContractDetail record);

    ContractDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractDetail record);

}