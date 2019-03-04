package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.Platform;

public interface PlatformMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Platform record);

    Platform selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Platform record);

    List<Platform> selectList();
}