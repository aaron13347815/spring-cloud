package com.yuecheng.base.entity;

import java.util.Date;

public class UserEntity {
	private String userId;
	private String userName;
	private String userIcon;
	private Date createDate;
	private String createAuthor;
	private Date lastUpdateDate;
	private String lastUpdateAuthor;
	private char enable;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
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
