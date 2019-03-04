package com.allmsi.mis.service;

import com.allmsi.sys.model.ListBean;

public interface PlatformService {

	ListBean selectList(Integer page,Integer pageSize);
}
