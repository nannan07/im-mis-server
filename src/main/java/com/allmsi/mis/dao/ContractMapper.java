package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.Contract;

public interface ContractMapper {

	List<Contract> draft(Map<String, Object> map);
	
	List<Contract> todo(Map<String, Object> map);

	List<Contract> done(Map<String, Object> map);

	List<Contract> self(Map<String, Object> map);
	
    int deleteByPrimaryKey(String id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    
    List<Contract> selectContractList(Map<String,Object> map);

	List<Contract> selectByProjId(String projId);
	
	List<Contract> selectByIds(List<String> objIds);
	
	List<Contract> selectByFin(String finId);
}