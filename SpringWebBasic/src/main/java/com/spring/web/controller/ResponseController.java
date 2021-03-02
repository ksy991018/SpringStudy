package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01")
	public void resEx01() {}
	
	//1. Model객체를 사용하여 화면에 데이터 전송하기.
//	@GetMapping("/test")
//	public void test(@RequestParam("age") int age,Model model) {
//		model.addAttribute("age",age);
//		model.addAttribute("nick","멍멍이");
//		
//	}
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송 처리
	// @RequestParm + model.addAttribute
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) {
		model.addAttribute("nick","멍멍이");
//		model.addAttribute("age",age); 이미 ModelAttribute에서 처리
	}
	
	//3. ModelAndView 객체를 활용한 처리
	@GetMapping("/test2")
	public ModelAndView test2() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName","김철수");
//		mv.setViewName("/response/test2"); 데이터 1개만 보낼때는 밑에처럼 가능
		return new ModelAndView("/response/test2","userName","홍길동");
	}
	
	//res-ex02.jsp파일을 열람하는 요청 메서드 작성
	@GetMapping("/res-ex02")
	public void resEx02() {}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user, Model model) {
//		model.addAttribute("user",user);
		
		return "response/test3";
	}
	
//	<%--
//    1. res-quiz 파일의 화면처리를 할 수 있는 메서드를 생성하세요. (res-quiz 맵핑)
//    2. 폼 태그의 action URL은 res-login으로 설정하세요.
//     아이디와 비밀번호를 사용자에게 입력할 수 있는 창을 제공하세요.
//    3. ID: kim123, PW: kkk1234 라면 res-quiz-success.jsp 페이지로
//     이동해서 "로그인 성공!" "(kim123)님 환영합니다!" 를 출력.
//     
//    4. ID나 비밀번호가 틀렸다면 res-quiz-fail.jsp 페이지로 이동해서
//    "로그인 실패!" "(입력한 ID)는 회원이 아니거나 비밀번호가 다릅니다." 를 출력.
//  --%>
	
	///////////////////////////////////////////////
	//퀴즈
	
	//퀴즈 화면처리
	@GetMapping("/res-quiz")
	public void resQuiz() {}
	
	//커맨드 객체와 Model을 사용한 방식
//	@PostMapping("/res-login")
//	public String login(UserVO user, Model model) {
//		String id = user.getUserId();
//		String pw = user.getUserPw();
//		model.addAttribute("user",user);
//		if(id.equals("kim1234") && pw.equals("kkk1234")) {
//			return "response/res-quiz-success";
//		}else {
//			return "response/res-quiz-fail";
//		}
//	}
	
	@PostMapping("/res-login")
	public String resLogin(@ModelAttribute("userId") String id,
			@RequestParam("userPw") String pw) {
		if(id.equals("kim1234") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		}else {
			return "response/res-quiz-fail";
		}
	}
	
	///////////////////////////////////////
	
	//Redirect 처리
	@GetMapping("/login")
	public String login() {
		System.out.println("/login: GET요청 발생!");
		return "response/res-redirect-form";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId") String id,
						@RequestParam("userPw") String pw,
						@RequestParam("userPwChk") String pwChk,
						RedirectAttributes ra) {
		System.out.println("/login: POST요청 발생!");
		System.out.println("ID: " + id);
		System.out.println("PW: "+ pw);
		System.out.println("CHK: " + pwChk);
		
		if(id.equals("")) {
//			model.addAttribute("msg","아이디는 필수값이에요!");
			ra.addFlashAttribute("msg","아이디는 필수값이에요!");
			return "redirect:/response/login";
		}else if(!pw.equals(pwChk)) {
			ra.addFlashAttribute("msg","비밀번호 확인란을 체크하세요!");
			return "redirect:/response/login";
		}
		return "";
	}
    
}
