package com.allmsi.mis.service;


import com.allmsi.mis.model.vo.BusinessMaterialsVo;
import com.allmsi.sys.model.ListBean;

public interface BusinessMaterialsService {

	ListBean selectList(Integer page,Integer pageSize,String bizId);
    
    BusinessMaterialsVo selectById(String id);

	String insertSelective(BusinessMaterialsVo materialsVo);

	String updateByPrimaryKeySelective(BusinessMaterialsVo materialsVo);

	boolean deleteByPrimaryKey(String id);
	
	//boolean insertList(BusinessMaterialsListVo businessMaterialsListVo);
}
