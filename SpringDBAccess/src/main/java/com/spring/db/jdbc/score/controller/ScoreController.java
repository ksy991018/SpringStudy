package com.spring.db.jdbc.score.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.db.jdbc.score.model.ScoreVO;
import com.spring.db.jdbc.score.service.IScoreService;



@Controller
@RequestMapping("/score")
public class ScoreController {
	
	//컨트롤러와 서비스 계층 사이의 의존성 자동 주입을 위해 변수를 선언
	@Autowired
	private IScoreService service;
	
	
	//점수 등록 화면을 열어주는 처리를 하는 요청 메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: GET");
		return "score/write-form";
	}
	
	//점수 등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
		System.out.println("/score/register: POST");
		System.out.println("param: "+scores);
		service.insertScore(scores);
		return "score/write-result";	
	}
	
	//점수 조체 조회를 처리하는 요청 메서드
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list: GET");
//		List<ScoreVO> list = service.selectAllScores();
		model.addAttribute("sList",service.selectAllScores());
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("stuNum") int n, RedirectAttributes ra) {
		System.out.println("삭제할 학번: " + n);
		service.deleteScore(n);
		ra.addFlashAttribute("message","delSuccess");
		return "redirect:/score/list";
		//삭제처리를 완료하신 후에 list 요청이 다시 컨트롤러로 들어갈수 있도록 처리를 해보세요.
		//list요청이 다시 들어가서 list.jsp로 갔을 때 삭제 이후 간것이 판단되면 alert()을 통해
		//삭제가 완료되었습니다 경고창을 띄워 보세요.(redirect attribute사용)
	}
	
	//점수 개별 조회 화면 열람요청 메서드
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search: GET");
	}
	
//	@GetMapping("/selectOne")
//	public String select(@RequestParam("stuNum") int n,RedirectAttributes ra, Model model) {
//		System.out.println("/score/selectOne: GET");
//		System.out.println("검색할 학번: "+n);
//		ScoreVO score = service.selectOne(n);
//		if(score==null) {
//			System.out.println("score가 없습니다.");
//			ra.addFlashAttribute("msg", "No info");
//		}
//		model.addAttribute("stu", score);
//		return "score/search-result";
//	}
	
	@GetMapping("/selectOne")
	public String select(int stuNum,RedirectAttributes ra, Model model) {
		System.out.println("/score/selectOne: GET");
		ScoreVO vo =service.selectOne(stuNum);
		System.out.println("selectOne Result" +vo);
		model.addAttribute("stu", vo);
		return "score/search-result";
	}
}
