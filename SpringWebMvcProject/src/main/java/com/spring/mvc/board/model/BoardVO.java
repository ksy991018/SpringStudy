package com.spring.mvc.board.model;

import java.sql.Timestamp;

public class BoardVO {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Timestamp regDate;
	private int viewCnt;
	
	//신규 게시물에 new 마크를 붙일지 말지를 결정하는 논리필드 선언.
	private boolean newMark;
	
	public boolean isNewMark() {
		return newMark;
	}
	
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	
	
	
	

}
