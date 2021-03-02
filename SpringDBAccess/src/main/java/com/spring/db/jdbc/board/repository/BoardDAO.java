package com.spring.db.jdbc.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.score.model.ScoreVO;



@Repository
public class BoardDAO implements IBoardDAO {

	@Autowired
	private JdbcTemplate template;
	
	//내부 클래스 선언.
	class BoardMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setBoardNo(rs.getInt("board_no"));
			board.setContent(rs.getString("content"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			return board;
		}
	}
	
	
	@Override
	public void insertArticle(BoardVO vo) {
		String sql = "INSERT INTO jdbc_board VALUES(bid_seq.NEXTVAL,?,?,?)";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent());
	}

	@Override
	public List<BoardVO> getArticles() {
		String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";
		return template.query(sql, new BoardMapper());
	}

	@Override
	public BoardVO getArticle(int index) {
		String sql = "SELECT * FROM jdbc_board WHERE board_no=?";
		return template.queryForObject(sql, new BoardMapper(),index);
	}

	@Override
	public void deleteArticle(int index) {
		String sql = "DELETE FROM jdbc_board WHERE board_no=?";
		template.update(sql,index);
	}

	@Override
	public void updateArticle(BoardVO vo, int index) {
		String sql="UPDATE jdbc_board SET writer=?,title=?,content=? "
				+ "WHERE board_no=?";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent(),vo.getBoardNo());
	}

}
