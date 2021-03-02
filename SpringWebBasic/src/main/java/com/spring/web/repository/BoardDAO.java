package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	private List<BoardVO> articles = new ArrayList<BoardVO>();
	
	
	@Override
	public void insertArticle(BoardVO vo) {
		articles.add(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		return articles;
	}

	@Override
	public BoardVO getArticle(int index) {
		return articles.get(index);
	}

	@Override
	public void deleteArticle(int index) {
		articles.remove(index);
	}

	@Override
	public void updateArticle(BoardVO vo, int index) {
		articles.set(index, vo);
	}

}
