package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.PlatformSplit;

public interface PlatformSplitMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(PlatformSplit record);

    PlatformSplit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformSplit record);

    List<PlatformSplit> selectList();
}