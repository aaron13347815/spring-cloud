package com.yuecheng.base.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuecheng.base.dao.PermissionMapper;
import com.yuecheng.base.entity.PermissionEntity;
import com.yuecheng.base.entity.UserEntity;
import com.yuecheng.base.service.PermissionService;
import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.utils.UUIDTools;
import com.yuecheng.base.vo.PermissionVO;
import com.yuecheng.base.vo.UserVO;
@Service("userServiceImpl")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public PageVO<PermissionVO> queryPermissionPage(PermissionVO permissionVO) {
		// TODO Auto-generated method stub
		PermissionEntity entity = new PermissionEntity();
		BeanUtils.copyProperties(permissionVO, entity);
		PageVO<PermissionEntity> pagevo = null;
		try {
			Page<PermissionEntity> page = PageHelper.startPage(permissionVO.getPageNum(), permissionVO.getPageSize())
					.doSelectPage(() -> permissionMapper.queryPermissionPage(entity));
			 pagevo = new PageVO<>(permissionVO.getPageSize(), permissionVO.getPageNum(), page.getResult(), Integer.valueOf(page.getTotal() + ""));
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		System.out.println(pagevo.getValues().size());
		List<PermissionVO> values = pagevo.getValues().stream().map(x -> {
			PermissionVO vo = new PermissionVO();
			BeanUtils.copyProperties(x, vo);
			return vo;
		}).collect(Collectors.toList());
		return new PageVO<PermissionVO>(pagevo.getPageSize(),pagevo.getPageNum(),values,pagevo.getTotalCount());
	}
	
	@Override
	public void insertRecords(List<PermissionVO> permissions) {
		// TODO Auto-generated method stub
		List<PermissionEntity> list = permissions.stream().map(x -> {
			PermissionEntity entity = new PermissionEntity();
			BeanUtils.copyProperties(x, entity);
			entity.setPermissionId(UUIDTools.create().toString().replace("-",""));
			return entity;
		}).collect(Collectors.toList());
		try {
			permissionMapper.insertRecords(list);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void deletePermissionById(String permissionId) {
		// TODO Auto-generated method stub
		try {
			permissionMapper.deletePermissionById(permissionId);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void updatePermissionById(PermissionVO permissionVO) {
		// TODO Auto-generated method stub
		PermissionEntity entity = new PermissionEntity();
		BeanUtils.copyProperties(permissionVO, entity);
		try {
			permissionMapper.updatePermissionById(entity);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public PermissionVO queryById(String permissionId) {
		// TODO Auto-generated method stub
		PermissionVO pvo = new PermissionVO();
		try {
			PermissionEntity pe = permissionMapper.queryById(permissionId);
			BeanUtils.copyProperties(pvo, pe);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		return pvo;
	}

}
