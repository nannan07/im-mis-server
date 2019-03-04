package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.BusinessMaterials;

public interface BusinessMaterialsMapper {
	int deleteByPrimaryKey(String id);

	int insertSelective(BusinessMaterials record);

	BusinessMaterials selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(BusinessMaterials record);

	List<BusinessMaterials> selectList(Map<String, Object> map);

	int insertList(List<BusinessMaterials> list);
	
	List<BusinessMaterials> selectByProjId(String projId);

}