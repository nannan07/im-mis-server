package com.allmsi.mis.service;

import java.util.List;

import com.allmsi.mis.model.vo.BusinessVo;
import com.allmsi.sys.model.ListBean;

public interface BusinessService {

	ListBean draft(String token,String search, Integer page, Integer pageSize);

	BusinessVo selectByPrimaryKey(String id);

	String submit(String token, BusinessVo businessVo, String result);

	String successful(String token, String id);

	boolean deleteByPrimaryKey(String id);

	ListBean selectByProjId(String projId, Integer page, Integer pageSize);

	List<BusinessVo> selectByIds(List<String> objIds);
}
