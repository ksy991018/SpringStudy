package com.spring.web.service;

import java.util.List;

import com.spring.web.model.BoardVO;

public interface IBoardService {

	//게시글 등록
	void insertArticle(BoardVO vo);
	//전체 게시글 목록 가져오기
	List<BoardVO> getArticles();
	
	//게시글 상세보기
	BoardVO getArticle(int index);
	//게시글 삭제
	void deleteArticle(int index);
	//게시글 수정
	void updateArticle(BoardVO vo, int index);
	
}
