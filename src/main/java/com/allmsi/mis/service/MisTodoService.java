package com.allmsi.mis.service;

import com.allmsi.sys.model.ListBean;

public interface MisTodoService {

	ListBean todoList(String token, String search, String module, Integer page, Integer pageSize);

	ListBean doneList(String token, String search, String module, Integer page, Integer pageSize);

	ListBean self(String token, String search, String module, Integer page, Integer pageSize);

	ListBean dept(String token, String search, String module, Integer page, Integer pageSize);

}
