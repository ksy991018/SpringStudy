package com.spring.db.jdbc.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.db.jdbc.board.model.BoardVO;

public interface IBoardMapper {
	//게시글 등록
	void insertArticle(BoardVO vo);
	//전체 게시글 목록 가져오기
	List<BoardVO> getArticles();
	
	//게시글 상세보기
	BoardVO getArticle(int index);
	//게시글 삭제
	void deleteArticle(int index);
	
	//게시글 수정
	void updateArticle(@Param("vo")BoardVO vo,@Param("index") int index);
	
	//게시글 검색
	List<BoardVO> searchArticle(String keyword);
	
}
