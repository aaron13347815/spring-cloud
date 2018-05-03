package com.yuecheng.base.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuecheng.base.dao.RoleMapper;
import com.yuecheng.base.entity.RoleEntity;
import com.yuecheng.base.service.RoleService;
import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.utils.UUIDTools;
import com.yuecheng.base.vo.RoleVO;
@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public PageVO<RoleVO> queryRolePage(RoleVO roleVO) {
		// TODO Auto-generated method stub
		RoleEntity entity = new RoleEntity();
		BeanUtils.copyProperties(roleVO, entity);
		PageVO<RoleEntity> pagevo = null;
		try {
			Page<RoleEntity> page = PageHelper.startPage(roleVO.getPageNum(), roleVO.getPageSize())
					.doSelectPage(() -> roleMapper.queryRolePage(entity));
			 pagevo = new PageVO<>(roleVO.getPageSize(), roleVO.getPageNum(), page.getResult(), Integer.valueOf(page.getTotal() + ""));
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		List<RoleVO> values = pagevo.getValues().stream().map(x -> {
			RoleVO vo = new RoleVO();
			BeanUtils.copyProperties(x, vo);
			return vo;
		}).collect(Collectors.toList());
		return new PageVO<RoleVO>(pagevo.getPageSize(),pagevo.getPageNum(),values,pagevo.getTotalCount());
	}
	
	@Override
	public void insertRecords(List<RoleVO> roles) {
		// TODO Auto-generated method stub
		List<RoleEntity> list = roles.stream().map(x -> {
			RoleEntity entity = new RoleEntity();
			BeanUtils.copyProperties(x, entity);
			entity.setRoleId(UUIDTools.create().toString().replace("-",""));
			return entity;
		}).collect(Collectors.toList());
		try {
			roleMapper.insertRecords(list);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void deleteRoleById(String roleId) {
		// TODO Auto-generated method stub
		try {
			roleMapper.deleteRoleById(roleId);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void updateRoleById(RoleVO roleVO) {
		// TODO Auto-generated method stub
		RoleEntity entity = new RoleEntity();
		BeanUtils.copyProperties(roleVO, entity);
		try {
			roleMapper.updateRoleById(entity);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public RoleVO queryById(String roleId) {
		// TODO Auto-generated method stub
		RoleVO rolevo = new RoleVO();
		try {
			RoleEntity ue = roleMapper.queryById(roleId);
			BeanUtils.copyProperties(rolevo, ue);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		return rolevo;
	}
}
