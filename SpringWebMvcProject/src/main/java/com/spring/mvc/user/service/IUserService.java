package com.spring.mvc.user.service;

import com.spring.mvc.user.model.UserVO;

public interface IUserService {
	
	//아이디 중복 체크 기능
	int checkId(String account);
	
	//회원 가입 기능
	void register(UserVO user);
	
	//회원 정보 조회 기능
	UserVO selectOne(String account);
	
	//회원 탈퇴 기능
	void delete(String account);

}
