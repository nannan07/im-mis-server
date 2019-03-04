package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.PosterMapper;
import com.allmsi.mis.model.po.Poster;
import com.allmsi.mis.model.vo.PosterVo;
import com.allmsi.mis.service.PosterService;

@Service
public class PosterServiceImpl implements PosterService {

	@Resource
	private PosterMapper posterDao;
	
	@Override
	public List<PosterVo> selectPosterList() {
		List<PosterVo> posterVoList = new ArrayList<>();
		List<Poster> posterList = posterDao.selectPosterList();
		for (Poster poster : posterList) {
			posterVoList.add(new PosterVo(poster));
		}
		return posterVoList;
	}

}
