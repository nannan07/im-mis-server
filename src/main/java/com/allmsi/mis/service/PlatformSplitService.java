package com.allmsi.mis.service;


import com.allmsi.mis.model.vo.PlatformSplitVo;
import com.allmsi.sys.model.ListBean;

public interface PlatformSplitService {

	String save(PlatformSplitVo platformSplitVo);
	
	boolean del(String id);
	
	PlatformSplitVo selectByPrimaryKey(String id);

	ListBean selectList(Integer page,Integer pageSize);
}
