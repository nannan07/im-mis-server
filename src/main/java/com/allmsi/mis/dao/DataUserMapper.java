package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.DataUser;

public interface DataUserMapper {

    DataUser selectByPrimaryKey(String id);

	int insertBatch(List<DataUser> list);

}