package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.Receipt;

public interface ReceiptMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Receipt record);

    Receipt selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Receipt record);

    List<Receipt> selectReceiptList(String contId);
}