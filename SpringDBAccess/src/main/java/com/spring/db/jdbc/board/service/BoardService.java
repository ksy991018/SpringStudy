package com.spring.db.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.IBoardDAO;
import com.spring.db.jdbc.board.repository.IBoardMapper;



@Service
public class BoardService implements IBoardService {

	//JDBC Template을 이용한 SQL처리.
//	@Autowired
//	private IBoardDAO dao;
	
	//MyBatis를 이용한 SQL처리
	@Autowired
	private IBoardMapper mapper;
	
	//한번에 변경 : alt + shift + r
	@Override
	public void insertArticle(BoardVO vo) {
		mapper.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		return mapper.getArticles();
	}

	@Override
	public BoardVO getArticle(int index) {
		return mapper.getArticle(index);
	}

	@Override
	public void deleteArticle(int index) {
		mapper.deleteArticle(index);
	}

	@Override
	public void updateArticle(BoardVO vo, int index) {
		mapper.updateArticle(vo, index);
	}

	@Override
	public List<BoardVO> searchArticle(String keyword) {
		return mapper.searchArticle("%"+keyword+"%");
	}


}
