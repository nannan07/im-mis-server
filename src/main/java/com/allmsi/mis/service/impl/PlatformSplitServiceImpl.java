package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.PlatformSplitMapper;
import com.allmsi.mis.model.po.PlatformSplit;
import com.allmsi.mis.model.vo.PlatformSplitVo;
import com.allmsi.mis.service.PlatformSplitService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PlatformSplitServiceImpl implements PlatformSplitService {

	@Resource
	private PlatformSplitMapper PlatformSplitDao;
	
	@Override
	public String save(PlatformSplitVo platformSplitVo) {
		PlatformSplit platformSplit = new PlatformSplit(platformSplitVo);
		int msg = 0;
		if(StrUtil.isEmpty(platformSplit.getId())) {
			platformSplit.setId(UUIDUtil.getUUID());
			msg = PlatformSplitDao.insertSelective(platformSplit);
		}else {
			msg = PlatformSplitDao.updateByPrimaryKeySelective(platformSplit);
		}
		return (msg == 0 ) ? "" : platformSplit.getId();
	}

	@Override
	public boolean del(String id) {
		PlatformSplitDao.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public PlatformSplitVo selectByPrimaryKey(String id) {
		PlatformSplit platformSplit = PlatformSplitDao.selectByPrimaryKey(id);
		return new PlatformSplitVo(platformSplit);
	}

	@Override
	public ListBean selectList(Integer page,Integer pageSize) {
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<PlatformSplitVo> PlatformSplitVo = new ArrayList<PlatformSplitVo>();
		List<PlatformSplit> PlatformSplit = PlatformSplitDao.selectList();
		PageInfo<PlatformSplit> pageInfo = new PageInfo<PlatformSplit>();
		int total = (int)pageInfo.getTotal(); 
		for (PlatformSplit platformSplit2 : PlatformSplit) {
			PlatformSplitVo.add(new PlatformSplitVo(platformSplit2));
		}
		return new ListBean(total,PlatformSplitVo);
	}

}
