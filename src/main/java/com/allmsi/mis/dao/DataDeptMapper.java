package com.allmsi.mis.dao;

import java.util.List;

import com.allmsi.mis.model.po.DataDept;

public interface DataDeptMapper {

	int insertDataAuthBantch(List<DataDept> list);

	int selectCountByDeptId(String deptId);

}