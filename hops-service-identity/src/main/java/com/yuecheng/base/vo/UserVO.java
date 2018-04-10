package com.yuecheng.base.vo;

public class UserVO extends BaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3714288882657363577L;
	private String userId;
	private String userName;
	private String userIcon;
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
	
}
