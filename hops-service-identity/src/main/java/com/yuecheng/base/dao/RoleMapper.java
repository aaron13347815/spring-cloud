package com.yuecheng.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.entity.RoleEntity;

public interface RoleMapper {
	/** 批量增  */
	int insertRecords(@Param("roles") List<RoleEntity> roles);
	/** 删  */
	int deleteRoleById(@Param("roleId") String roleId);
	/** 改  */
	int updateRoleById(RoleEntity entity);
	/** 查多条  */
    List<RoleEntity> queryRolePage(RoleEntity entity);
	/** 查1条   */
    RoleEntity queryById(@Param("roleId") String roleId);
}
