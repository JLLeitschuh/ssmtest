package com.cjl.model;

import java.io.Serializable;
import java.util.Date;

/*
 * 用户表
 */

public class UserModel implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	//用户表的主键id
	private Long id;
	
	//用户表的姓名
	private String userName;
	
	//用户表的性别
	private String userSex;

	//入职日期
	private Date entryDate;
	
	
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", userSex=" + userSex + "]";
	}


	

}
