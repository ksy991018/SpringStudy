package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//글 작성 화면
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	//작성된 글 등록 처리 요청
	//메서드 이름 -> write()
	//작성된 글을 리스트에 등록한 후 /board/list.jsp파일로 응답할 수 있도록
	//(글 목록 보여달라는 요청이 자동으로 들어와야 합니다.)
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write: POST");
		service.insertArticle(article);
		
		return "redirect:/board/list";
	}
	
	
	//글 목록 화면 요청
	//메서드 이름-> list()
	//DB 대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
	//브라우저에 글 목록을 띄워주시면 되겠습니다
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("list",service.getArticles());
		return "board/list";
	}
	
	@GetMapping("/content")
	public void content(Model model,@RequestParam("boardNo") int n) {
		System.out.println("/board/content?boardNo="+n +": GET");
		model.addAttribute("article",service.getArticle(n));
		model.addAttribute("boardNo", n);
	}
	
	//어짜피 boardNo은 받아서 다시 model에 담아줘야하기때문에 modelAttribute가 더간편
//	@GetMapping("/content")
//	public void content(@ModelAttribute("boardNo") int n,@RequestParam("boardNo") int n) {
//		System.out.println("/board/content?boardNo="+n +": GET");
//		model.addAttribute("article",service.getArticle(n));
////		model.addAttribute("boardNo", n);
//	}
	
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo +":GET");
		model.addAttribute("article", service.getArticle(boardNo));
	}
	
	//글 수정 요청
	//수정 처리 완료 이후에 방금 수정된 글의 상세보기 페이지로 이동시켜주세요.
	@PostMapping("/modify")
	public String modify(BoardVO article, @RequestParam("boardNo") int boardNo) {
		System.out.println("/board/modify?boardNo=" +boardNo + ": POST");
		service.updateArticle(article, boardNo);
		return "redirect:/board/content?boardNo=" +boardNo;
	}
	
	//글 삭제요청
	@GetMapping("/delete")
	public String delete(@RequestParam("boardNo") int boardNo) {
		System.out.println("/board/delete?boardNo"+boardNo);
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
}
