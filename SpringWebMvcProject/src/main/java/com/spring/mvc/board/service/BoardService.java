package com.spring.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService{

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insert(BoardVO article) {
		mapper.insert(article);
	}

	@Override
	public List<BoardVO> getArticleList(PageVO paging) {
		return mapper.getArticleList(paging);
	}

	@Override
	public BoardVO getArticle(int boardNo) {
		return mapper.getArticle(boardNo);
	}

	@Override
	public int countArticles() {
		return mapper.countArticles();
	}
	
	@Override
	public void updateViewCnt(int boardNo) {
		
		
	}

	@Override
	public void update(BoardVO article) {
		mapper.update(article);
		
	}

	@Override
	public void delete(int boardNo) {
		mapper.delete(boardNo);
	}
	

}
