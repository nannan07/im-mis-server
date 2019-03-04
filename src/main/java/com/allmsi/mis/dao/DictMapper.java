package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.Dict;

public interface DictMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
    
    List<Dict> selectByName(String dCode);
}