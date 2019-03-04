package com.allmsi.mis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.mis.config.OperationMenu;
import com.allmsi.mis.dao.ContractMapper;
import com.allmsi.mis.dao.ContractPartnerMapper;
import com.allmsi.mis.model.po.Contract;
import com.allmsi.mis.model.po.ContractPartner;
import com.allmsi.mis.model.vo.ContractDraftedVo;
import com.allmsi.mis.model.vo.ContractListVo;
import com.allmsi.mis.model.vo.ContractVo;
import com.allmsi.mis.model.vo.ChoseVo;
import com.allmsi.mis.model.vo.ProjectSpecificVo;
import com.allmsi.mis.model.vo.ProjectVo;
import com.allmsi.mis.service.ContractService;
import com.allmsi.mis.service.ProjectService;
import com.allmsi.mis.service.ProjectSpecificService;
import com.allmsi.mis.third.model.vo.AuthDeptVo;
import com.allmsi.mis.third.model.vo.AuthUserVo;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ContractServiceImpl extends BaseServiceImpl implements ContractService {

	@Resource
	private ContractMapper contarceDao;

	@Resource
	private ProjectService projectService;

	@Resource
	private ProjectSpecificService projectSpecificService;

	@Resource
	private ContractPartnerMapper contractPartnerDao;

	/**
	 * 合同起草，草稿箱
	 */
	@Override
	public ListBean draft(String token, String search, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = getAuthUserId(token);
		map.put("cUserId", userId);
		map.put("search", search);
		List<ContractDraftedVo> list = new ArrayList<ContractDraftedVo>();
		PageHelper.startPage(page, pageSize);
		List<Contract> conList = contarceDao.draft(map);
		for (Contract con : conList) {
			list.add(new ContractDraftedVo(con));
		}
		PageInfo<Contract> pageInfo = new PageInfo<Contract>(conList);
		int total = (int) pageInfo.getTotal();
		return new ListBean(total, list);
	}

	@Override
	public List<ContractVo> selectByProjId(String projId) {// 查询项目ID的所有签署合同
		List<ContractVo> list = new ArrayList<ContractVo>();
		if (StrUtil.isEmpty(projId)) {
			List<Contract> contractList = contarceDao.selectByProjId(projId);
			for (Contract contract : contractList) {
				list.add(new ContractVo(contract));
			}
		}
		return list;
	}

	@Override
	public ContractVo selectByPrimaryKey(String id) {
		Contract contract = contarceDao.selectByPrimaryKey(id);
		return new ContractVo(contract);
	}

	@Override
	public String save(String token, ContractVo contractVo) {
		String userId = getAuthUserId(token);
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		Contract contract = new Contract(contractVo);
		int msg = 0;
		if (StrUtil.isEmpty(contractVo.getId())) {
			contract.setId(UUIDUtil.getUUID());
			contract.setDraft(0);
			msg = contarceDao.insertSelective(contract);
			insertDataUser(userId, OperationMenu.USER_INSERT, contract.getId());// 添加到datauser表
		} else {
			msg = contarceDao.updateByPrimaryKeySelective(contract);
			insertDataUser(userId, OperationMenu.USER_UPDATE, contract.getId());// 添加到datauser表
		}
		return (msg == 0) ? "" : contract.getId();
	}

	private Contract getContract(String token, ContractVo contractVo) {
		AuthUserVo user = getAuthUser(token);
		String userId = user.getId();
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		// 添加立项人
		contractVo.setcUserId(userId);
		contractVo.setContUserId(userId);
		contractVo.setContUserName(user.getUserName());
		// 获取用户部门
		AuthDeptVo authDeptVo = getUserOnthDept(user.getDeptIds(), user.getDeptNames());
		if (authDeptVo != null) {
			contractVo.setContUserDeptId(authDeptVo.getId());
			contractVo.setContUserDeptName(authDeptVo.getDeptName());
		}
		Contract contract = new Contract(contractVo);
		return contract;
	}

	@Override
	public String submit(String token, ContractVo contractVo, String result) {
		String id = contractVo.getId();
		if (OperationMenu.SUBMIT.equals(result)) {// 发起流程
			contractVo.setDraft(1);
			Contract contract = getContract(token, contractVo);
			String projId = contract.getProjId();
			if (StrUtil.notEmpty(projId)) {
				ProjectVo vo = projectService.selectByProjId(projId);// 判断projId 是否合法
				if (vo != null && projId.equals(vo.getProjId())) {
					return updateContractAndProj(token, contractVo);// 更新流程、业务数据
				}
			}
			projId = addProj(contract);
			contract.setProjId(projId);
			ContractVo vo = selectByPrimaryKey(id);
			if (vo != null && StrUtil.notEmpty(vo.getId())) {
				id = updateContract(token, contractVo);
			} else { // 首次发起流程
				id = firstAddContract(token, contractVo);
			}
		} else {// 添加草稿
			contractVo.setDraft(0);
			if (StrUtil.isEmpty(id)) {
				contractVo.setId(UUIDUtil.getUUID());
				id = firstAddContract(token, contractVo);
			} else {// 修改草稿
				id = updateContract(token, contractVo);
			}
		}
		return id;
	}

	private String updateContractAndProj(String token, ContractVo contractVo) {
		String projId = projectService.updateEffective(new ProjectVo(contractVo));// 更新项目份额
		Contract contract = getContract(token, contractVo);
		if (StrUtil.isEmpty(projId)) {
			return "";
		} else {
			contractVo.setProjId(projId);
			updateContract(token, contractVo);
			insertDataUser(contract.getcUserId(), OperationMenu.USER_UPDATE, contract.getId());
			addCommonData(contract.getcUserId(), OperationMenu.USER_UPDATE, contract.getId(), projId);
		}
		return contractVo.getId();
	}

	private String addProj(Contract contract) {
		ProjectVo projVo = new ProjectVo(contract);
		projVo.setContUserId(contract.getcUserId());
		String projId = projectService.insertProject(projVo);
		ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
		projectSpecificVo.setId(UUIDUtil.getUUID());
		projectSpecificVo.setProjId(projId);
		projectSpecificVo.setContractState("审核中");
		projectSpecificVo.setSigningContract("签署合同");
		projectSpecificService.insertProjectSpecificLis(projectSpecificVo);
		addCommonData(contract.getcUserId(), OperationMenu.USER_INSERT, projId);
		return projId;
	}

	private String firstAddContract(String token, ContractVo contractVo) {
		Contract contract = getContract(token, contractVo);
		int msg = contarceDao.insertSelective(contract);
		insertPartnerCompanys(contract.getId(), contract.getPartnerCompanyName(), contract.getcUserId());
		insertDataUser(contract.getcUserId(), OperationMenu.USER_INSERT, contract.getId());
		return (msg == 0) ? "" : contract.getId();
	}

	private String updateContract(String token, ContractVo contractVo) {
		Contract contract = getContract(token, contractVo);
		contarceDao.updateByPrimaryKeySelective(contract);
		contractPartnerDao.deleteByContId(contract.getId());
		insertPartnerCompanys(contract.getId(), contract.getPartnerCompanyName(), contract.getcUserId());
		return contract.getId();
	}

	private boolean insertPartnerCompanys(String contId, List<String> partnerCompanyName, String userId) {
		List<ContractPartner> list = new ArrayList<ContractPartner>();
		int msg = 0;
		if (partnerCompanyName != null && partnerCompanyName.size() > 0) {
			for (String string : partnerCompanyName) {
				list.add(new ContractPartner(UUIDUtil.getUUID(), contId, string, userId, null));
			}
			if (list != null && list.size() > 0) {
				msg = contractPartnerDao.insertBatch(list);
			}
		}
		return (msg == 0) ? false : true;
	}

	@Override
	public String successful(String id) {
		ContractVo contractVo = selectByPrimaryKey(id);// 流程审核成功后
		String projId = contractVo.getProjId();
		List<ContractVo> list = selectByProjId(projId);// 获取项目下的所有合同列表
		Integer totalShareValue = getContractVoForProjectShare(list);// 计算要同步的数值
		return synProject(projId, totalShareValue);// 更新项目台账中的信息
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		contarceDao.deleteByPrimaryKey(id);
		return true;
	}

	private Integer getContractVoForProjectShare(List<ContractVo> contractList) {
		Integer totalShareValue = 0;
		for (ContractVo contractVo : contractList) {
			totalShareValue = getContractVoForProjectShare(Integer.valueOf(totalShareValue),
					Integer.valueOf(contractVo.getProjShareValue()), contractVo.getProjShare());
		}
		return totalShareValue;
	}

	private Integer getContractVoForProjectShare(Integer totalShareValue, Integer projShareValue, String projShare) {
		if ("01".equals(projShare)) {// 购买
			totalShareValue = totalShareValue + projShareValue;
		}
		if ("02".equals(projShare)) {// 卖出
			totalShareValue = totalShareValue - projShareValue;
		}
		if ("03".equals(projShare)) {// 不变

		}
		return totalShareValue;
	}

	private String synProject(String projId, Integer projShareValue) {
		ContractVo contractVo = new ContractVo();
		contractVo.setProjId(projId);
		contractVo.setProjShareValue(String.valueOf(projShareValue));// 合同要同步到项目台账中的信息
		String msg = projectService.updateEffective(new ProjectVo(contractVo));// 更新项目份额
		ProjectSpecificVo projectSpecificVo = new ProjectSpecificVo();
		projectSpecificVo.setProjId(projId);
		projectSpecificVo.setContractState("结束");
		projectSpecificService.upDateProjectSpecificList(projectSpecificVo);
		return (StrUtil.isEmpty(msg)) ? "" : msg;
	}

	@Override
	public ListBean ListByProjId(String projId, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<ContractListVo> contListVo = new ArrayList<ContractListVo>();
		List<Contract> contList = contarceDao.selectByProjId(projId);
		PageInfo<Contract> pageInfo = new PageInfo<Contract>(contList);
		int total = (int) pageInfo.getTotal();
		for (Contract contract : contList) {
			contListVo.add(new ContractListVo(contract));
		}
		return new ListBean(total, contListVo);
	}

	@Override
	public List<ContractVo> selectByIds(List<String> objIds) {
		List<ContractVo> list = new ArrayList<ContractVo>();
		if (objIds != null && objIds.size() > 0) {
			List<Contract> contlist = contarceDao.selectByIds(objIds);
			for (Contract contract : contlist) {
				list.add(new ContractVo(contract));
			}
		}
		return list;
	}

	@Override
	public Object selectListByProjId(String projId) {
		List<Contract> contractList = contarceDao.selectByProjId(projId);
		List<ChoseVo> list = new ArrayList<ChoseVo>();
		for (Contract contract : contractList) {
			list.add(new ChoseVo(contract.getContTitle(), contract.getId()));
		}
		return list;
	}

	@Override
	public Object selectByFin(String finId) {
		List<Contract> contractList = contarceDao.selectByFin(finId);
		List<ChoseVo> list = new ArrayList<ChoseVo>();
		for (Contract contract : contractList) {
			list.add(new ChoseVo(contract.getContTitle(), contract.getId()));
		}
		return list;
	}
}
