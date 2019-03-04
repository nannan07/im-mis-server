package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.Finance;

public interface FinanceMapper {

	List<Finance> draft(Map<String, Object> map);

	int deleteByPrimaryKey(String id);

	int insertSelective(Finance record);

	Finance selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Finance record);

	List<Finance> financeList(Map<String, Object> map);

	List<Finance> selectByProjId(String projId);

	List<Finance> selectByIds(List<String> objIds);

	List<Finance> selectListByProjId(String projId);
	
	List<Finance> selectByContId(String contId);
}