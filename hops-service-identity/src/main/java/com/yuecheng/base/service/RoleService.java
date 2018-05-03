package com.yuecheng.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuecheng.base.utils.PageVO;
import com.yuecheng.base.vo.RoleVO;

public interface RoleService {
	/** 批量增  */
	void insertRecords(@Param("roles") List<RoleVO> roles);
	/** 删  */
	void deleteRoleById(@Param("roleId") String roleId);
	/** 改  */
	void updateRoleById(RoleVO roleVO);
	/** 查多条分页  */
	PageVO<RoleVO> queryRolePage(RoleVO roleVO);
	/** 查1条   */
    RoleVO queryById(@Param("roleId") String roleId);
}
