package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.ProjectSplit;

public interface ProjectSplitMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectSplit record);

    int insertSelective(ProjectSplit record);

    ProjectSplit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectSplit record);

    int updateByPrimaryKey(ProjectSplit record);
}