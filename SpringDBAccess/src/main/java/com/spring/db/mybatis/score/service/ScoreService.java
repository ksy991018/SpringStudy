package com.spring.db.mybatis.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.db.mybatis.score.model.ScoreVO;
import com.spring.db.mybatis.score.repository.IScoreMapper;





@Service("scoreService2")
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreMapper mapper;
	
	@Override
	public void insertScore(ScoreVO services) {
		services.calcData();
		mapper.insertScore(services);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return mapper.selectAllScores();
	}

	@Override
	public void deleteScore(int stuNum) {
		mapper.deleteScore(stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return mapper.selectOne(stuNum);
	}

}
