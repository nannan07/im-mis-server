package com.allmsi.mis.service;

import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.sys.model.ListBean;

/**
 * 项目进度
 * @author sunnannan
 *
 */
public interface ProjectSpecificService {

	ListBean selectProjectSpecificList(String token,Integer page, Integer pageSize);

	String saveProjectSpecific(ProjectSpecificVo projectSpecificVo);

	boolean delProjectSpecific(String projId);
	
	String upDateProjectSpecificList(ProjectSpecificVo projectSpecificVo);
	
	String insertProjectSpecificLis(ProjectSpecificVo projectSpecificVo);

}
