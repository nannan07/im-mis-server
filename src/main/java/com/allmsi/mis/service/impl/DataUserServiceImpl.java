package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.DataUserMapper;
import com.allmsi.mis.model.po.DataUser;
import com.allmsi.mis.service.DataUserService;
import com.allmsi.sys.util.UUIDUtil;

@Service
public class DataUserServiceImpl implements DataUserService {

	@Resource
	private DataUserMapper dateUserDao;

	@Override
	public int insertSelective(String userId, String type, String... objIds) {
		List<DataUser> list = new ArrayList<DataUser>();
		for (String objId : objIds) {
			list.add(new DataUser(UUIDUtil.getUUID(), objId, userId, type));
		}
		if (list != null && list.size() > 0) {
			return dateUserDao.insertBatch(list);
		}
		return 0;
	}

}
