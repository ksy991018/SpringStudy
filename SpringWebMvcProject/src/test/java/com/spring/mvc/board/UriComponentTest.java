package com.spring.mvc.board;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentTest {

	@Test
	public void testUriComp() {
		//uri를 쉽게 작성할수 있도록 도와주는 유틸 클래스 UriComponentsBuilder 사용하기
		UriComponents ucp= UriComponentsBuilder.newInstance().path("/board/list")
															.queryParam("page", 3)
															.queryParam("countPerPage", 20)
															.queryParam("condition","title" )
															.queryParam("keyword", "메롱")
															.build();
		System.out.println(ucp.toUriString());
	}
	
}
