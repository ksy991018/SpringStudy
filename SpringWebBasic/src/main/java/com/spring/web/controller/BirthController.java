package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.BirthVO;

@Controller
public class BirthController {
	
	//생일을 입력하는 폼을 열어주는 요청 메서드
	@GetMapping("/birth")
	public String birthForm() {
		System.out.println("/birth에 Get요청!");
		return "birth/birth_form";
	}

	@PostMapping("/birth")
	public String sendBirth(@ModelAttribute("birth") BirthVO birth){
		String birthDay = birth.getBirthYear()+birth.getBirthMonth()+birth.getBirthDay();
		System.out.println(birthDay);
		return "birth/birth-result";
	}
}
