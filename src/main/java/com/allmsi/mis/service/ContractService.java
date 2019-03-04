package com.allmsi.mis.service;

import java.util.List;

import com.allmsi.mis.model.vo.ContractVo;
import com.allmsi.sys.model.ListBean;

public interface ContractService {
	
	ListBean draft(String token, String search, Integer page, Integer pageSize);
	
	List<ContractVo> selectByProjId(String projId);

	ContractVo selectByPrimaryKey(String id);

	String save(String token,ContractVo contractVo);

	String successful(String id);

	boolean deleteByPrimaryKey(String id);
	
	ListBean ListByProjId(String projId,Integer page,Integer pageSize);
	
	List<ContractVo> selectByIds(List<String> objIds);

	String submit(String token, ContractVo contractVo, String result);

	Object selectListByProjId(String projId);

	Object selectByFin(String finId);
}
