package com.spring.mvc.test;

import java.util.List;

public class Person {
	
	private String name;
	private int age;
	private List<String> hobbys;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	

}
