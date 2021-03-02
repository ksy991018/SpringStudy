package com.spring.basic.ex04;

import javax.annotation.Resource;

public class Book {
	
	/*
	 # @Resource
	 - 빈을 자동으로 주입하는 아노테이션 입니다.
	 - 필드, 메서드에만 적용이 가능하며, 생성자에서는 적용이 불가능합니다.
	 - name 속성을 통해 특성 bean의 id를 지목할 수 있습니다. 
	 */
	
	//@Autowired
	//@Qualifier("paper2")
	@Resource(name="paper2")
	private Paper paper;

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	
}
