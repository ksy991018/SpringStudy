package com.spring.web.model;

public class BirthVO {

	private String birthYear;
	private String birthMonth;
	private String birthDay;
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		if(Integer.parseInt(birthMonth)<10) {
			this.birthMonth = 0+birthMonth;
			return;
		}
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		if(Integer.parseInt(birthDay)<10) {
			this.birthDay = 0+birthDay;
			return;
		}
		this.birthDay = birthDay;
	}
	
	
}
