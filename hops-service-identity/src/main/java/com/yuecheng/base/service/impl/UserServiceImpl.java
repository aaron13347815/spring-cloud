package com.yuecheng.base.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuecheng.base.dao.UserMapper;
import com.yuecheng.base.entity.UserEntity;
import com.yuecheng.base.service.UserService;
import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.utils.UUIDTools;
import com.yuecheng.base.vo.UserVO;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public PageVO<UserVO> queryUserPage(UserVO userVO) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userVO, entity);
		PageVO<UserEntity> pagevo = null;
		try {
			Page<UserEntity> page = PageHelper.startPage(userVO.getPageNum(), userVO.getPageSize())
					.doSelectPage(() -> userMapper.queryUserPage(entity));
			 pagevo = new PageVO<>(userVO.getPageSize(), userVO.getPageNum(), page.getResult(), Integer.valueOf(page.getTotal() + ""));
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		System.out.println(pagevo.getValues().size());
		List<UserVO> values = pagevo.getValues().stream().map(x -> {
			UserVO vo = new UserVO();
			BeanUtils.copyProperties(x, vo);
			return vo;
		}).collect(Collectors.toList());
		return new PageVO<UserVO>(pagevo.getPageSize(),pagevo.getPageNum(),values,pagevo.getTotalCount());
	}
	
	@Override
	public void insertRecords(List<UserVO> users) {
		// TODO Auto-generated method stub
		List<UserEntity> list = users.stream().map(x -> {
			UserEntity entity = new UserEntity();
			BeanUtils.copyProperties(x, entity);
			entity.setUserId(UUIDTools.create().toString().replace("-",""));
			return entity;
		}).collect(Collectors.toList());
		try {
			userMapper.insertRecords(list);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void deleteUserById(String userId) {
		// TODO Auto-generated method stub
		try {
			userMapper.deleteUserById(userId);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public void updateUserById(UserVO userVO) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userVO, entity);
		try {
			userMapper.updateUserById(entity);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
	}

	@Override
	public UserEntity queryById(String userId) {
		// TODO Auto-generated method stub
		UserEntity ue = new UserEntity();
		try {
			ue = userMapper.queryById(userId);
		} catch (Exception e) {
			throw new RuntimeException("数据库操作异常",e);
		}
		return ue;
	}


}
