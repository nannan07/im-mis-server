package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.DataDeptMapper;
import com.allmsi.mis.model.po.DataDept;
import com.allmsi.mis.service.DataDeptService;
import com.allmsi.sys.util.UUIDUtil;

@Service
public class DataDeptServiceImpl implements DataDeptService {

	@Resource
	private DataDeptMapper dateDeptDao;

	@Override
	public int insertDataAuthBantch(String objId, String... deptIds) {
		List<DataDept> list = new ArrayList<DataDept>();
		for (String deptId : deptIds) {
			list.add(new DataDept(UUIDUtil.getUUID(), objId, deptId));
		}
		int msg = 0;
		if (list != null && list.size() > 0) {
			msg = dateDeptDao.insertDataAuthBantch(list);
		}
		return msg;
	}

	@Override
	public Integer allCount(String deptId) {
		System.out.println("deptId--"+deptId);
		return dateDeptDao.selectCountByDeptId(deptId);
	}

}
