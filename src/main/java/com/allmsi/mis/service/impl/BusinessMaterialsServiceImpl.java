package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.BusinessMaterialsMapper;
import com.allmsi.mis.model.po.BusinessMaterials;
import com.allmsi.mis.model.vo.BusinessMaterialsVo;
import com.allmsi.mis.service.BusinessMaterialsService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BusinessMaterialsServiceImpl implements BusinessMaterialsService {

	@Resource
	private BusinessMaterialsMapper materialsdao;
	
	@Override
	public ListBean selectList(Integer page,Integer pageSize,String bizId) {
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bizId", bizId);
		PageHelper.startPage(page, pageSize);
		List<BusinessMaterialsVo> materVoList = new ArrayList<BusinessMaterialsVo>();
		List<BusinessMaterials> materList = materialsdao.selectList(map);
		PageInfo<BusinessMaterials> pageInfo = new PageInfo<BusinessMaterials>(materList);
		for (BusinessMaterials materials : materList) {
			materVoList.add(new BusinessMaterialsVo(materials));
		}
		int total = (int) pageInfo.getTotal();
		return new ListBean(total,materVoList);
	}

	@Override
	public BusinessMaterialsVo selectById(String id) {
		BusinessMaterials materials = materialsdao.selectByPrimaryKey(id);
		return new BusinessMaterialsVo(materials);
	}

	@Override
	public String insertSelective(BusinessMaterialsVo materialsVo) {
		BusinessMaterials businessMaterials = new BusinessMaterials(materialsVo);
		businessMaterials.setId(UUIDUtil.getUUID());
		int msg = materialsdao.insertSelective(businessMaterials);
		return (msg == 0) ?  "" : businessMaterials.getId();
	}

	@Override
	public String updateByPrimaryKeySelective(BusinessMaterialsVo materialsVo) {
		BusinessMaterials materials = new BusinessMaterials(materialsVo);
		int msg = materialsdao.updateByPrimaryKeySelective(materials);
		return (msg == 0) ? "" : materialsVo.getId();
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		materialsdao.deleteByPrimaryKey(id);
		return true;
	}

//	@Override
//	public boolean insertList(BusinessMaterialsListVo businessMaterialsListVo) {
//		List<BusinessMaterials> bizlist = new ArrayList<BusinessMaterials>();
//		if(businessMaterialsListVo.getList() != null && businessMaterialsListVo.getList().size() > 0) {
//			for (BusinessMaterialsOneVo businessMaterialsOneVo : businessMaterialsListVo.getList()) {
//				BusinessMaterials businessMaterials = new BusinessMaterials();
//				businessMaterials.setId(UUIDUtil.getUUID());
//				businessMaterials.setBizId(businessMaterialsListVo.getBizId());
//				businessMaterials.setProjId(businessMaterialsListVo.getProjId());
//				businessMaterials.setMaterType(businessMaterialsOneVo.getMaterType());
//				businessMaterials.setUrl(businessMaterialsOneVo.getUrl());
//				businessMaterials.setcUserId(businessMaterialsOneVo.getcUserId());
//				bizlist.add(businessMaterials);
//			}
//			return (materialsdao.insertList(bizlist) == 0) ? false : true ;
//		}
//		
//		return true;
//	}

}
