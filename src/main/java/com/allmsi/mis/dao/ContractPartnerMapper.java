package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.ContractPartner;

public interface ContractPartnerMapper {

    int insertSelective(ContractPartner record);

    ContractPartner selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractPartner record);

	int insertBatch(List<ContractPartner> list);

	int deleteByContId(String id);

}