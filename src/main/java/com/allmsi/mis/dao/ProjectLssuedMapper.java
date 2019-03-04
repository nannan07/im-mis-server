package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.ProjectLssued;

public interface ProjectLssuedMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(ProjectLssued record);

    ProjectLssued selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectLssued record);
    
    List<ProjectLssued> selectByProjId(String projId);

}