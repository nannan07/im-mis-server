package com.allmsi.mis.service;

import java.util.List;

import com.allmsi.mis.model.vo.FinanceVo;
import com.allmsi.sys.model.ListBean;

public interface FinanceService {

	ListBean draft(String token,String search, Integer page, Integer pageSize);

	FinanceVo selectByPrimaryKey(String id);

	String save(String token,FinanceVo financeVo);

	String submit(String token, FinanceVo financeVo,String result);

	String successful(String id);

	boolean deleteByPrimaryKey(String id);
	
	ListBean selectByProjId(String projId,Integer page,Integer pageSize);
	
	List<FinanceVo> selectByIds(List<String> objIds);

	Object selectListByProjId(String projId);
}
