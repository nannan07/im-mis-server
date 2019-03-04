package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.DictMapper;
import com.allmsi.mis.model.po.Dict;
import com.allmsi.mis.model.vo.DictVo;
import com.allmsi.mis.service.DictService;
import com.allmsi.sys.model.ListBean;
import com.github.pagehelper.PageInfo;

@Service
public class DictServiceImpl implements DictService {

	@Resource
	private DictMapper dictMapper;
	
	@Override
	public ListBean selectByName(String dCode) {
		List<Dict> dict = dictMapper.selectByName(dCode);
		PageInfo<Dict> pageInfo = new PageInfo<Dict>(dict);
		int total = (int) pageInfo.getTotal();
		List<DictVo> dictVo = new ArrayList<DictVo>();
		for (Dict dict2 : dict) {
			dictVo.add(new DictVo(dict2));
		}
		return new ListBean(total,dictVo);
	}

}
