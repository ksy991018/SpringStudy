package com.spring.mvc.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
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
	public BoardVO getArticle(int boardNo) {
		return mapper.getArticle(boardNo);
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

	@Override
	public int countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}
	
	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
		return mapper.getArticleList(search);
	}
	
//	@Override
//	public List<BoardVO> getArticleListByTitle(SearchVO search) {
////		Map<String,Object> map = new HashMap<>();
////		map.put("keyword",keyword);
////		map.put("PageVO",paging);
//		List<BoardVO> list = mapper.getArticleListByTitle(search);
//		System.out.println(list);
//		return mapper.getArticleListByTitle(search);
//	}
//
//	@Override
//	public int countArticlesByTitle(SearchVO search) {
//		return mapper.countArticlesByTitle(search);
//	}
//	
//	

}
