package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.Poster;

public interface PosterMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Poster record);

    Poster selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Poster record);
    
    List<Poster> selectPosterList();

}