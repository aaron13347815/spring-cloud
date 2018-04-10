package com.yuecheng.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.entity.UserEntity;
import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.vo.UserVO;

public interface UserService {
	/** 批量增  */
	void insertRecords(@Param("users") List<UserVO> users);
	/** 删  */
	void deleteUserById(@Param("userId") String userId);
	/** 改  */
	void updateUserById(UserVO userVO);
	/** 查多条分页  */
	PageVO<UserVO> queryUserPage(UserVO userVO);
	/** 查1条   */
    UserEntity queryById(@Param("userId") String userId);
}
