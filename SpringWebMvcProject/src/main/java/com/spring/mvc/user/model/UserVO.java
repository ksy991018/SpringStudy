package com.spring.mvc.user.model;

import java.sql.Timestamp;

public class UserVO {
	
	private String account;
	private String password;
	private String name;
	private Timestamp regDate;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "UserVO [account=" + account + ", password=" + password + ", name=" + name + ", regDate=" + regDate
				+ "]";
	}
	
	
	

}
