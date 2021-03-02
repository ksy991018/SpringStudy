package com.spring.mvc.board.commons;

//페이지 알고리즘에 의해 이전, 다음 버튼 및 페이지 버튼 개수 및 번호를 관장할 객체.
public class PageCreator {

	//페이지 번호와 한 페이지당 들어갈 게시물의 개수를 갖고있는 객체
	private PageVO paging;
	private int articleTotalCount; //게시판의 총 게시물수
	private int beginPage; //시작 페이지 번호
	private int endPage; //끝 페이지 번호
	private boolean prev; //이전 버튼 활성화 여부
	private boolean next; //다음 버튼 활성화 여부
	
	//한 화면에 보여질 페이지 버튼 수
	private final int displayPageNum = 10;
	
	//페이징 알고리즘을 수행할 메서드 선언.
	private void calcDataOfPage() {
		
		//보정 전 끝 페이지 구하기
		endPage = (int) (Math.ceil(paging.getPage()/(double)displayPageNum) * displayPageNum);
		
		//시작 페이지 번호 구하기
		beginPage = (endPage-displayPageNum)+1;
		// 현재 시작 페이지가 1이라면 이전버튼 활성화 여부를 false로 지정
		prev = (beginPage==1)? false:true;
		//마지막 페이지인지 여부 확인 후 다음 버튼 비활성화 판단
		next = (articleTotalCount < (endPage*paging.getCountPerPage()))? false:true;
		//다음버튼이 비활성화라면 끝 페이지 재보정 하기.
		if(!isNext()) {
			endPage =  (int)Math.ceil(articleTotalCount/(double)paging.getCountPerPage());
		}
	}
	
	public PageVO getPaging() {
		return paging;
	}
	public void setPaging(PageVO paging) {
		this.paging = paging;
	}
	public int getArticleTotalCount() {
		return articleTotalCount;
	}
	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", articleTotalCount=" + articleTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
	
	
}
