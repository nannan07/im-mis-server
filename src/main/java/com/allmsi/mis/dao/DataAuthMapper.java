package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.DataAuth;

public interface DataAuthMapper {

	int insertDataAuthBantch(List<DataAuth> list);

	int deleteByObjIdAndAuthId(DataAuth dataAuth);

	DataAuth selectByObjIdAndUserId(DataAuth dateAuth);
}