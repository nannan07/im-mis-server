package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.dao.BusinessMapper;
import com.allmsi.mis.dao.BusinessMaterialsMapper;
import com.allmsi.mis.dao.ContractMapper;
import com.allmsi.mis.dao.FinanceMapper;
import com.allmsi.mis.dao.PaymentMapper;
import com.allmsi.mis.dao.ProjectLssuedMapper;
import com.allmsi.mis.dao.ProjectMapper;
import com.allmsi.mis.dao.ProjectSpecificMapper;
import com.allmsi.mis.model.po.Business;
import com.allmsi.mis.model.po.BusinessMaterials;
import com.allmsi.mis.model.po.Contract;
import com.allmsi.mis.model.po.Finance;
import com.allmsi.mis.model.po.Payment;
import com.allmsi.mis.model.po.Project;
import com.allmsi.mis.model.po.ProjectLssued;
import com.allmsi.mis.model.po.ProjectSpecific;
import com.allmsi.mis.model.vo.ChoseVo;
import com.allmsi.mis.model.vo.Project4ListVo;
import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.mis.service.ProjectService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProjectServiceImpl extends BaseServiceImpl implements ProjectService {

	@Resource
	private ProjectMapper projectDao;
	@Resource
	private BusinessMaterialsMapper businessMaterialsDao;
	@Resource
	private ProjectLssuedMapper projedctLssuedDao;
	@Resource
	private BusinessMapper businessDao;
	@Resource
	private ContractMapper contractDao;
	@Resource
	private FinanceMapper financeDao;
	@Resource
	private PaymentMapper paymentDao;

	@Resource
	private ProjectSpecificMapper projectSpecificDao;

	@Override
	public ListBean selectProjList(String token, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<Project4ListVo> projListVolist = new ArrayList<Project4ListVo>();
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = getAuthUserId(token);
		map.put("authId", userId);
		List<Project> projlist = projectDao.selectProjList(map);
		PageInfo<Project> pageInfo = new PageInfo<Project>(projlist);
		int total = (int) pageInfo.getTotal();
		for (Project project : projlist) {
			projListVolist.add(new Project4ListVo(project));
		}
		return new ListBean(total, projListVolist);
	}

	@Override
	public String insertProject(ProjectVo projectVo) {
		if (projectVo == null) {
			System.out.println("insert");
			return null;
		}
		Project project = new Project(projectVo);
		String id = UUIDUtil.getUUID();
		project.setId(id);
		project.setIsEffective(0);
		project.setProjId(id);
		project.setcTime(new Date());
		int msg = projectDao.insertSelective(project);
		ProjectSpecific record = new ProjectSpecific(project);
		record.setId(UUIDUtil.getUUID());
		record.setBizState("审核中");
		projectSpecificDao.insertSelective(record);
		return (msg == 0) ? "" : project.getProjId();
	}

	@Override
	public String updateEffective(ProjectVo projectVo) {
		System.out.println("projectVo---"+projectVo.getProjId());
		if (projectVo == null || StrUtil.isEmpty(projectVo.getProjId())) {
			return "";
		}
		// 查询项目台账
		int msg = 0;
		String nId = UUIDUtil.getUUID();
		String projId = projectVo.getProjId();
		Project project = projectDao.selectByPrimaryKey(projId);
		if (project != null) {
			projectDao.updateEffective(projId);
			project.setId(nId);
			msg = projectDao.insertSelective(project);
			Project nProject = new Project(projectVo);
			nProject.setId(nId);
			projectDao.updateByPrimaryKeySelective(nProject);
			System.out.println("msg---"+msg);
		}
		return (msg == 0) ? "" : projId;
	}

	@Override
	public ProjectVo selectByProjId(String projId) {
		Project project = projectDao.selectByPrimaryKey(projId);
		List<BusinessMaterials> bizMaterials = businessMaterialsDao.selectByProjId(projId);
		List<ProjectLssued> projectLssued = projedctLssuedDao.selectByProjId(projId);
		List<Business> bizList = businessDao.selectByProjId(projId);
		List<Contract> contList = contractDao.selectByProjId(projId);
		List<Finance> finList = financeDao.selectByProjId(projId);
		List<Payment> payList = paymentDao.selectByProjId(projId);
		ProjectVo projectVo = new ProjectVo(project);
		projectVo.setBizMaterials(bizMaterials);
		projectVo.setProjLssued(projectLssued);
		projectVo.setBizList(bizList);
		projectVo.setContList(contList);
		projectVo.setFinList(finList);
		projectVo.setPayList(payList);
		return projectVo;
	}

	@Override
	public Object listChoose() {
		List<Project> projlist = projectDao.listChoose();
		List<ChoseVo> list = new ArrayList<ChoseVo>();
		for (Project project : projlist) {
			list.add(new ChoseVo(project.getProjName(), project.getProjId()));
		}
		return list;
	}
}
