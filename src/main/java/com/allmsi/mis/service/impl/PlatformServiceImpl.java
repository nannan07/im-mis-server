package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.PlatformMapper;
import com.allmsi.mis.model.po.Platform;
import com.allmsi.mis.model.vo.PlatformVo;
import com.allmsi.mis.service.PlatformService;
import com.allmsi.sys.model.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PlatformServiceImpl implements PlatformService {

	@Resource
	private PlatformMapper platformDao;
	
	@Override
	public ListBean selectList(Integer page,Integer pageSize) {
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<PlatformVo> platformVoList = new ArrayList<PlatformVo>();
		List<Platform> platformList = platformDao.selectList();
		for (Platform platform : platformList) {
			platformVoList.add(new PlatformVo(platform));
		}
		PageInfo<Platform> pageInfo = new PageInfo<Platform>(platformList);
		int total = (int)pageInfo.getTotal();
		return new ListBean(total,platformVoList);
	}

}
