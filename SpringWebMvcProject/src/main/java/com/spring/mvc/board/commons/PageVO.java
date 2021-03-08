package com.spring.mvc.board.commons;

public class PageVO {
	
	private int page; //사용자가 요청한 페이지 번호
	private int countPerPage; //한 페이지당 들어갈 게시물의 수.
	
	//처음 board 목록 요청을 보낼 때, 1페이지 요청이 들어갈 수 있도록 멤버변수를 초기화.
	public PageVO() {
		this.page = 1;
		this.countPerPage = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}

	
	
	
}
