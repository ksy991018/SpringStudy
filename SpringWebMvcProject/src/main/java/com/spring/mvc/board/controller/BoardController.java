package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.commons.PageCreator;
import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
//	//게시글 목록 불러오기
//	@GetMapping("/list")
//	public void list(Model model) {
//		System.out.println("/board/list : GET요청!");
//		List<BoardVO> list = service.getArticlList();
//		System.out.println("URL: /board/list GET -> result: " + list.size());
//		model.addAttribute("articles",list);
//	}
	
	//페이징 처리 이후 게시글 목록 불러오기 요청.
	@GetMapping("list")
	public String list(PageVO paging, Model model) {
		System.out.println("URL: /board/list -> GET");
		List<BoardVO> list = service.getArticleList(paging);
		
		System.out.println("result: " + list.size());
		System.out.println("페이지 번호: " + paging.getPage());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("pc", pc);
		model.addAttribute("articles", list);
		
		return "board/list";
	}
	
	
	//글 작성 페이지 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("URL: /board/write -> GET");
	}
	
	//게시글 DB등록 요청
	//글 등록 이후에 목록 요청이 자동으로 들어갈수 있게 처리
	//글 등록이 완료되었습니다! 경고창이 뜨도록 처리. (글 등록후에 목록으로 갔을때만 뜨는 경고창)
	//("msg","regSuccess")
	
	@PostMapping("/write")
	public String insertArticle(BoardVO article,RedirectAttributes ra) {
		System.out.println("URL: /board/write -> POST");
		System.out.println("param" + article);
		service.insert(article);
		ra.addFlashAttribute("msg","regSuccess");
		return "redirect:/board/list";
	}
	
	//@PathVariable은 URL경로에 변수를 포함시켜주는 방식.
	//NULL이나 공백이 들어갈수있는 파라미터값이라면 적용하지 않는것을 추천
	//파라미터값에 .이 포함되어있다면 .뒤의 값을 잘립니다.
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable int boardNo,Model model) {
		System.out.println("URL: /board/contet -> GET");
		System.out.println("parameter(글 번호): "+boardNo);
		BoardVO vo = service.getArticle(boardNo);
		System.out.println("Result data: "+vo);
		model.addAttribute("article",vo);
		return "board/content";
	}
	
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("URL: /board/modify -> GET");
		System.out.println("parameter(글 번호) " + boardNo);
		model.addAttribute("article",service.getArticle(boardNo));
	}
	
	//게시물 수정 요청
	//수정 처리하고 나서 수정된 글의 상세보기 페이지로 이동
	//ra활용하여 게시글 수정이 완료되었습니다. 경고창 하나 띄워주세요. ("msg","modSuccess")
	@PostMapping("/modify")
	public String modify(BoardVO article,RedirectAttributes ra) {
		System.out.println("URL: /board/modify -> POST");
		service.update(article);
		ra.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/content?boardNo="+article.getBoardNo();	
	}
	
	//게시글 삭제처리
	@PostMapping("/delete")
	public String delete(int boardNo,RedirectAttributes ra) {
		System.out.println("URL: /board/delete -> POST");
		System.out.println("parameter(글번호)" +boardNo);
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/list";
	}
}
