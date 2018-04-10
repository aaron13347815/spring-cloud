package com.yuecheng.base.entity;

import java.util.Date;

public class RoleEntity {
	private String roleId;
	private String roleName;
	private Date createDate;
	private String createAuthor;
	private Date lastUpdateDate;
	private String lastUpdateAuthor;
	private char enable;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateAuthor() {
		return createAuthor;
	}
	public void setCreateAuthor(String createAuthor) {
		this.createAuthor = createAuthor;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdateAuthor() {
		return lastUpdateAuthor;
	}
	public void setLastUpdateAuthor(String lastUpdateAuthor) {
		this.lastUpdateAuthor = lastUpdateAuthor;
	}
	public char getEnable() {
		return enable;
	}
	public void setEnable(char enable) {
		this.enable = enable;
	}
	
}
