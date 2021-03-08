package com.spring.mvc.board.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터 클래스를 만드려면 HandlerInterceptorAdapter 클래스를 상속.
public class BoardInterceptor extends HandlerInterceptorAdapter {

	//preHandle은 컨트롤러로 들어가기 전 처리해야 할 로직을 작성.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("게시판 인터셉터 발동!");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			System.out.println("회원 인증 실패!");
			response.sendRedirect("/board/list");
			return false;
		}
		
		System.out.println("회원 인증 성공!");
		return true;
	}
	
	//postHandle은 컨트롤러를 나갈 때 공통 처리해야 할 내용을 작성.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}



















