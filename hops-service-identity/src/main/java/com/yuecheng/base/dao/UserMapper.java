package com.yuecheng.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.entity.UserEntity;

@Mapper
public interface UserMapper {

	/** 批量增  */
	int insertRecords(@Param("users") List<UserEntity> users);
	/** 删  */
	int deleteUserById(@Param("userId") String userId);
	/** 改  */
	int updateUserById(UserEntity entity);
	/** 查多条  */
    List<UserEntity> queryUserPage(UserEntity entity);
	/** 查1条   */
    UserEntity queryById(@Param("userId") String userId);
}
