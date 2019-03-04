package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.ReceiptMapper;
import com.allmsi.mis.model.po.Receipt;
import com.allmsi.mis.model.vo.ReceiptVo;
import com.allmsi.mis.service.ReceiptService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Resource
	private ReceiptMapper receiptDao;
	
	@Override
	public String save(ReceiptVo receiptVo) {
		Receipt receipt = new Receipt(receiptVo);
		int msg = 0;
		if(StrUtil.isEmpty(receipt.getId())) {
			receipt.setId(UUIDUtil.getUUID());
			msg = receiptDao.insertSelective(receipt);
		}else {
			msg = receiptDao.updateByPrimaryKeySelective(receipt);
		}
		return (msg == 0) ? "" : receipt.getId();
	}

	@Override
	public boolean del(String id) {
		receiptDao.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public ReceiptVo selectByPrimaryKey(String id) {
		Receipt receipt = receiptDao.selectByPrimaryKey(id);
		return new ReceiptVo(receipt);
	}

	@Override
	public ListBean selectReceiptList(String contId,Integer page,Integer pageSize) {
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<ReceiptVo> receiptVoList = new ArrayList<ReceiptVo>();
		List<Receipt> receiptList = receiptDao.selectReceiptList(contId);
		PageInfo<Receipt> pageInfo = new PageInfo<Receipt>(receiptList);
		int total = (int)pageInfo.getTotal();
		for (Receipt receipt : receiptList) {
			receiptVoList.add(new ReceiptVo(receipt));
		}
		return new ListBean(total,receiptVoList);
	}

}
