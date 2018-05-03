package com.yuecheng.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.entity.PermissionEntity;

public interface PermissionMapper {
	/** 批量增  */
	int insertRecords(@Param("permissions") List<PermissionEntity> permissions);
	/** 删  */
	int deletePermissionById(@Param("permissionId") String permissionId);
	/** 改  */
	int updatePermissionById(PermissionEntity entity);
	/** 查多条  */
    List<PermissionEntity> queryPermissionPage(PermissionEntity entity);
	/** 查1条   */
    PermissionEntity queryById(@Param("permissionId") String permissionId);
}
