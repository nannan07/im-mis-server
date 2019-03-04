package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.Business;

public interface BusinessMapper {
	List<Business> draft(Map<String, Object> map);

	Business selectByPrimaryKey(String id);

	int insertSelective(Business record);

	int updateByPrimaryKeySelective(Business record);

	int deleteByPrimaryKey(String id);

	List<Business> selectByProjId(String projId);

	List<Business> selectByIds(List<String> objIds);
}