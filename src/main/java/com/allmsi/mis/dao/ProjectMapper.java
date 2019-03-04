package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.Project;

public interface ProjectMapper {

	Project selectByPrimaryKey(String id);

	int insertSelective(Project record);

	int deleteByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Project project);

	int updateEffective(String id);

	List<Project> selectProjList(Map<String, Object> map);

	List<Project> listChoose();
}