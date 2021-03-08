package com.spring.mvc.board.repository;

import java.util.List;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;

//게시판 관련 CRUD 추상 메서드를 선언.
public interface IBoardMapper {

	//게시글 등록 기능
	void insert(BoardVO article);
		
	//게시글 상세 조회 기능
	BoardVO getArticle(int boardNo);
	
	//게시글 조회수 상승 처리
	void updateViewCnt(int boardNo);
	
	//게시글 수정 기능
	void update(BoardVO article);
	
	//게시글 삭제 기능
	void delete(int boardNo);
	
	//검색, 페이징 기능이 모두 포함된 게시물 목록 조회 기능 (최종)
	List<BoardVO> getArticleList(SearchVO search);
	int countArticles(SearchVO search);
	
	
	
	
	
	//제목으로 검색 기능
	//List<BoardVO> getArticleListByTitle(SearchVO search);
	
	//제목으로 검색 이후 게시물 수 조회 기능
	//int countArticlesByTitle(SearchVO search);
	
}
















