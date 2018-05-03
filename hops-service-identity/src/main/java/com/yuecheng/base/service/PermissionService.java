package com.yuecheng.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.vo.PermissionVO;

public interface PermissionService {
	/** 批量增  */
	void insertRecords(@Param("permissions") List<PermissionVO> permissions);
	/** 删  */
	void deletePermissionById(@Param("permissionId") String permissionId);
	/** 改  */
	void updatePermissionById(PermissionVO permissionVO);
	/** 查多条分页  */
	PageVO<PermissionVO> queryPermissionPage(PermissionVO permissionVO);
	/** 查1条   */
	PermissionVO queryById(@Param("permissionId") String permissionId);
}
