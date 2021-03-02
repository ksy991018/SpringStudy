package com.spring.db.jdbc.score.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.score.commons.ScoreMapper;
import com.spring.db.jdbc.score.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	//내부(중첩) 클래스 (inner class)
	//두 클래스가 굉장히 긴밀한 관계가 있을때 선언이 가능.
	//해당 클래스 안에서만 사용할 클래스를 굳이 새 파일을 만들지 않고도 선언이 가능.
	class ScoreMapper implements RowMapper<ScoreVO> {

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
	
	//	//# 전통적 방식의 JDBC
	//	private String driver = "oracle.jdbc.driver.OracleDriver";
	//	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	//	private String uid = "spring";
	//	private String upw = "spring";

	//	@Override
	//	public void insertScore(ScoreVO scores) {
	//		Connection conn = null;
	//		PreparedStatement pstmt = null;
	//		
	//		String sql = "INSERT INTO scores VALUES "
	//				+ "(id_seq.NEXTVAL,?,?,?,?,?,?)";
	//		
	//		try {
	//			Class.forName(driver);
	//			conn = DriverManager.getConnection(url,uid,upw);
	//			pstmt.setString(1, scores.getStuName());
	//			pstmt.setInt(2, scores.getKor());
	//			pstmt.setInt(3, scores.getEng());
	//			pstmt.setInt(4, scores.getMath());
	//			pstmt.setInt(5, scores.getTotal());
	//			pstmt.setDouble(6, scores.getAverage());
	//			
	//			pstmt.executeUpdate();
	//		} catch(Exception e) {
	//			e.printStackTrace();
	//		}finally {
	//			try {
	//				pstmt.close(); conn.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		
	//	}

	//# Spring-jdbc 방식의 처리: JdbcTemplate 사용
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertScore(ScoreVO scores) {
		String sql = "INSERT INTO scores VALUES (id_seq.NEXTVAL,?,?,?,?,?,?)";
		
		template.update(sql,scores.getStuName(),scores.getKor(),
				scores.getMath(),scores.getEng(),
				scores.getTotal(),scores.getAverage());
	}
		
	@Override
	public List<ScoreVO> selectAllScores() {
		String sql = "SELECT * FROM scores ORDER BY stu_id ASC";
		return template.query(sql, (rs,rowNum)->{
			ScoreVO score = new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setEng(rs.getInt("eng"));
			score.setMath(rs.getInt("math"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			
			return score;
		});
	}

	@Override
	public void deleteScore(int stuNum) {
		String sql = "DELETE FROM scores WHERE stu_id=?";
		template.update(sql, stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		String sql = "SELECT * FROM scores WHERE stu_id=?";
		//queryForObject는 Single row를 리턴할때 사용합니다.
		//query는 multi row를 리턴할 때 사용합니다. 
		return template.queryForObject(sql, new ScoreMapper(),stuNum);
	}

}
