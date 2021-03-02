package com.spring.mvc.board.commons;

public class PageVO {

	private int page;
	private int countPerPage; //한 페이지당 들어갈 게시물의 수.
	
	public PageVO() {
		this.countPerPage=10;
		this.page=1;
		
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
