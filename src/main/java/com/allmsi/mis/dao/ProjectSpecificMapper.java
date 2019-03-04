package com.allmsi.mis.dao;

import java.util.List;
import java.util.Map;

import com.allmsi.mis.model.po.ProjectSpecific;

public interface ProjectSpecificMapper {

    List<ProjectSpecific> selectList(Map<String,Object> map);

	ProjectSpecific selectByPrimaryKey(String id);

    int insertSelective(ProjectSpecific record);

	int updateByPrimaryKeySelective(ProjectSpecific record);

	int delByProjId(String projId);
}