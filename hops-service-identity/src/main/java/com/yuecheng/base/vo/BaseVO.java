package com.yuecheng.base.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1405653214505056698L;
	//第几页
	private Integer pageNum = 1;
	//每页多少条
	private Integer pageSize = 20;
	//新增时间
	private Date createDate;
	//新增人
	private String createAuthor;
	//最后修改时间
	private Date lastUpdateDate;
	//最后修改人
	private String lastUpdateAuthor;
	//状态
	private char enable;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
