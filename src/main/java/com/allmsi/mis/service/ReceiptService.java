package com.allmsi.mis.service;

import com.allmsi.mis.model.vo.ReceiptVo;
import com.allmsi.sys.model.ListBean;

public interface ReceiptService {

	String save(ReceiptVo receiptVo);
	
	boolean del(String id);
	
	ReceiptVo selectByPrimaryKey(String id);
	
	ListBean selectReceiptList(String contId,Integer page,Integer pageSize);
}
