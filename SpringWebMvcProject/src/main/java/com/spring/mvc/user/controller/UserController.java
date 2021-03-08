package com.spring.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	//아이디 중복 확인 요청 처리
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		//sql문은 COUNT(*)을 이용하여, 해당 id로 데이터베이스에서 검색이 되었다면 NO를,
		//검색이 되지 않았다면 OK를 리턴해 주세요.
		System.out.println("/user/checkId: POST 요청 발생!");
		System.out.println("param: " + account);
		
		int checkNum = service.checkId(account);
		
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨!");
			return "NO";
		} else {
			System.out.println("아이디 사용 가능!");
			return "OK";
		}	
		
	}
	
	//회원 가입 요청 처리
	@PostMapping("/")
	public String register(@RequestBody UserVO user) {
		System.out.println("/user/: POST 요청 발생!");
		System.out.println("param: " + user);
		
		service.register(user);
		return "joinSuccess";
		
	}
	
	//로그인 요청 처리
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO inputData, /*HttpServletRequest request*/
															HttpSession session) {
		
		/*
		 # 클라이언트가 전송한 id값과 pw값을 가지고 DB에서 회원의 정보를
		 조회하여 불러온 다음, 값 비교를 통해
		 1. 아이디가 없는 경우 클라이언트 측으로 문자열 idFail 전송.
		 2. 비밀번호가 틀렸을 경우 문자열 pwFail 전송
		 3. 로그인 성공 시 문자열 loginSuccess를 전송.
		 */
		
		//서버에서 세션 객체를 얻는 방법.
		//1. HttpSerlvetRequest객체 사용.
		//HttpSession session = request.getSession();
		//2. HttpSession객체 바로 사용.
		
		
		String result = null;
		
		System.out.println("/user/loginCheck요청!: POST");
		System.out.println("param: " + inputData);
		UserVO dbData = service.selectOne(inputData.getAccount());
		
		if(dbData != null) {
			if(dbData.getPassword().equals(inputData.getPassword())) {
				session.setAttribute("login", dbData);
				result = "loginSuccess";
			} else {
				result = "pwFail";
			}
		} else {
			result = "idFail";
		}
		
		return result;
		
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		System.out.println("/user/logout 요청!");
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	
	
}





























