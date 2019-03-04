package com.allmsi.mis.service;

import com.allmsi.sys.model.ListBean;

public interface HomeService {

	Integer urgentLevel(String token);
	
	Integer allCount(String token);

	ListBean toall(String token);

	Integer todoCount(String token);

	Object home(String token);
}
