package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.commons.PageCreator;
import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//검색 처리 이후 게시글 목록 불러오기 요청
	@GetMapping("list")
	public String list(SearchVO search, Model model) {
		
		System.out.println("페이지 번호: " + search.getPage());
		System.out.println("검색 조건: " + search.getCondition());
		System.out.println("검색어: " + search.getKeyword());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		List<BoardVO> list = service.getArticleList(search);
		pc.setArticleTotalCount(service.countArticles(search));
		System.out.println(pc);
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);

		
		return "board/list";
	}
	
	/*
	//검색 처리 이후 게시글 목록 불러오기 요청(너무 비효율적이라 사용하지 않겠습니다..)
	@GetMapping("/list")
	public String list(Model model, SearchVO search) {
		
		System.out.println("페이지 번호: " + search.getPage());
		System.out.println("검색 조건: " + search.getCondition());
		System.out.println("검색어: " + search.getKeyword());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		List<BoardVO> list = null;
		
		if(search.getCondition().equals("title")) {
			System.out.println("제목 검색 요청이 들어옴!");
			list = service.getArticleListByTitle(search);
			System.out.println("mapper result: " + list);
			pc.setArticleTotalCount(service.countArticlesByTitle(search));
			System.out.println(pc);

		} else if(search.getCondition().equals("content")) {
			
		} else if(search.getCondition().equals("writer")) {
			
		} else {
			list = service.getArticleList(search);
			pc.setArticleTotalCount(service.countArticles());
			System.out.println(pc);
		}

		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		
		return "board/list";
	}
	*/
	
	/*
	//페이징 처리 이후 게시글 목록 불러오기 요청.
	@GetMapping("list")
	public String list(PageVO paging, Model model) {
		List<BoardVO> list = service.getArticleList(paging);
		
		System.out.println("URL: /board/list -> GET, result: " + list.size());
		System.out.println("페이지 번호: " + paging.getPage());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}
	*/
	
	/*
	//게시글 목록 불러오기
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getArticleList();
		
		System.out.println("URL: /board/list GET -> result: " + list.size());
		model.addAttribute("articles", list);
		
		return "board/list";
	}
	*/
	
	//글 작성 페이지 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("URL: /board/write -> GET");
	}
	
	//게시글 DB 등록 요청
	//글 등록 이후에 목록 요청이 자동으로 들어갈 수 있게끔 처리해 주시고
	//'글 등록이 완료되었습니다!' 경고창이 뜰 수  있도록 처리해 주세요. (글 등록 후에 목록으로 갔을 때만 뜨는 경고창)
	//("msg", "regSuccess")
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		
		System.out.println("URL: /board/write -> POST");
		service.insert(article);
		
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";
	}
	
	//게시물 상세 조회 요청
	@GetMapping("/content/{boardNo}")
	//@PathVariable은 URL 경로에 변수를 포함시켜 주는 방식.
	//null이나 공백이 들어갈 수 있는 파라미터값이라면 적용하지 않는 것을 추천.
	//파라미터값에 .이 포함되어 있다면 .뒤의 값은 잘립니다.
	public String content(@PathVariable int boardNo, Model model, 
						  @ModelAttribute("p") SearchVO search) {
		System.out.println("URL: /board/content -> GET");
		System.out.println("parameter(글 번호): " + boardNo);
		BoardVO vo = service.getArticle(boardNo);
		System.out.println("result data: " + vo);
		model.addAttribute("article", vo);
		
		return "board/content";
	}
	
	//게시글 수정 페이지 이동 요청.
	@GetMapping("/modify")
	public void modify(int boardNo, Model model, @ModelAttribute("p") PageVO paging) {
		System.out.println("URL: /board/modify -> GET");
		System.out.println("parameter(글 번호): " + boardNo);
		model.addAttribute("article", service.getArticle(boardNo));
	}
	
	//게시물 수정 요청
	//수정 처리하고 나서 수정된 글의 상세보기 페이지로 이동시켜 주세요.
	//ra 활용해서 '게시글 수정이 완료되었습니다.' 경고창 하나 띄워 주세요. ("msg", "modSuccess")
	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes ra) {
		System.out.println("URL: /board/modify -> POST");
		service.update(article);
		
		ra.addFlashAttribute("msg", "modSuccess");
		
		return "redirect:/board/content/" + article.getBoardNo();
	}
	
	//게시물 삭제 처리
	@PostMapping("/delete")
	public String remove(int boardNo, RedirectAttributes ra) {
		System.out.println("URL: /board/delete -> POST");
		System.out.println("parameter(글 번호): " + boardNo);
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/board/list";
		
	}
	

}
























