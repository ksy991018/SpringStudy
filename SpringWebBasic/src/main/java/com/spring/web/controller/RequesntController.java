package com.spring.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.UserVO;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록해주는 어노테이션
//빈을 등록해놔야 HandlerMapping이  이 클래스의 객체 검색 가능
@Controller
@RequestMapping("/request") //컨트롤러 자체에 공통된 uri를 맵핑
public class RequesntController {
	
	public RequesntController() {
		System.out.println("RequestController 빈 등록!");
	}
	
	//RequestMapping은 어떤 URI로 이 메서드를 작동시킬것인가에 대한 설정
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test에 요청이 들어옴");
		return "test"; //WEB-INF/views/test.jsp로 전달
	}
	
	/*
	 만약 /request/req요청이 들어왔을때 view 폴더 아래에 있는
	 request폴더 아래에 req-ex01.jsp파일을 열도록 메서드를 구성해보세요~
	 */
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req에 요청이 들어옴!");
		return "request/req-ex01";
	}
	
//	@RequestMapping(value="/request/basic01", method=RequestMethod.GET)
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청이 들어옴! GET");
		return "request/req-ex01";
	}
	
	
//	@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청이 들어옴! POST");
		return "request/req-ex01";
	}
	
	//컨트롤러의 요청메서드를 void리턴 타입으로 지정.
	@GetMapping("/req-ex02")
	public void reqEx02() {
		System.out.println("/request/req-ex02 요청입니다!");
		
	}
	
	/////////////////////////////////////////////
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join: GET");
	}
	
	/*
//	1. 전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법.
//	- HttpServletRequest 객체를 활용.
//	 */
//	
//	@PostMapping("/join")
//	public String register(HttpServletRequest request) {
//		System.out.println("/request/join: POST");
//		System.out.println("ID: " + request.getParameter("userId"));
//		System.out.println("PW: " + request.getParameter("userPw") );
//		System.out.println("Hobby " + Arrays.toString(request.getParameterValues("hobby")));
//			
//		return "request/join";
//	}
	
	/*
	 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리.
	 */
//	@PostMapping("/join")
//	public void register(@RequestParam("userId") String id,
//						@RequestParam("userPw") String pw,
//						@RequestParam(value="hobby",required = false, defaultValue = "no hobby person" ) List<String> hobbys) {
//		
//		System.out.println("ID: " + id);
//		System.out.println("PW: "+ pw);
//		System.out.println("HOBBY: "+hobbys);
//	}
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리.
	 */
	
	@PostMapping("/join")
	public void register(UserVO user) {
		System.out.println(user);
	}
	

	@GetMapping("/quiz")
	public String login() {
		System.out.println("/request/quiz 요청");
		return "request/req-quiz";
	}
	
	@PostMapping("/quiz")
	public String login(UserVO userVO) {
		System.out.println();
		String id = userVO.getUserId();
		String pw = userVO.getUserPw();
		if(id.equals("abc1234") && pw.equals("aaa1111")) {
			return "request/login-success";
		}else {
			return "request/login-fail";
		}
	}
}
