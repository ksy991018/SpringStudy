package com.spring.db.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.db.jdbc.score.model.ScoreVO;

//JdbcTemplate에서 Select 쿼리를 위한 ResultSet 사용을 편하게 하기위한 클래스를 생성
//RowMapper 인터페이스를 구현합니다.

public class ScoreMapper implements RowMapper<ScoreVO> {

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreVO score = new ScoreVO();
		score.setStuId(rs.getInt("stu_id"));
		score.setStuName(rs.getString("stu_name"));
		score.setKor(rs.getInt("kor"));
		score.setEng(rs.getInt("eng"));
		score.setMath(rs.getInt("math"));
		score.setTotal(rs.getInt("total"));
		score.setAverage(rs.getDouble("average"));
		
		return score;
	}
	

}
