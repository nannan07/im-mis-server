package com.allmsi.mis.dao;

import com.allmsi.mis.model.po.Attachment;

public interface AttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attachment record);

	int deleteByFileId(String id);

}