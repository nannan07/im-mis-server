package com.allmsi.mis.service;

import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.sys.model.ListBean;

/**
 * 项目台账
 * @author sunnannan
 *
 */
public interface ProjectService {

	String insertProject(ProjectVo projectVo);
	
//	String updateProject(ProjectVo projectVo);
	
	String updateEffective(ProjectVo projectVo);

	ProjectVo selectByProjId(String projId);

	ListBean selectProjList(String token,Integer page, Integer pageSize);

	Object listChoose();
}
