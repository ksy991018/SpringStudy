package com.spring.basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

	@Autowired
	private Monitor monitor;
	
	@Autowired
	private Mouse mouse;
	
	@Autowired
	private Keyboard keyboard;
	
	public void computerInfo() {
		System.out.println("*** 컴퓨터의 정보 ***");
		monitor.info();
		keyboard.info();
		mouse.info();
	}
}
