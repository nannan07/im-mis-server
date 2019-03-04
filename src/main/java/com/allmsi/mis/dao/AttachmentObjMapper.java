package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.AttachmentObj;

public interface AttachmentObjMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(AttachmentObj record);

    AttachmentObj selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AttachmentObj record);

}