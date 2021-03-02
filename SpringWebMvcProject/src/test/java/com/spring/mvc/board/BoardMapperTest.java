package com.spring.mvc.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {

   @Autowired
   private IBoardMapper mapper;
   
   //게시글 등록 단위 테스트
   @Test
   public void insertTest() {
      
      for(int i=1; i<=324; i++) {
         BoardVO article = new BoardVO();
         article.setTitle("테스트 제목입니다." + i);
         article.setWriter("김테스트" + i);
         article.setContent("테스트 중이니까 조용히 하세요!" + i);
         mapper.insert(article);
      }
      
   }
   
   //게시글 목록 조회 테스트
//   @Test
//   public void getListTest() {
////	   List<BoardVO> list = mapper.getArticlList();
////	   for(BoardVO vo:list) {
////		   System.out.println(vo);
////	   }
//	   mapper.getArticlList().forEach(vo-> System.out.println(vo));
//	   
//   }
   
   //게시글 단일 조회 테스트
   //44번글을 조회해서 글 상세 내용을 출력해 주세요
   @Test
   public void getArticleTest() {
	   System.out.println(mapper.getArticle(44));
   }
   
   //게시글 수정 테스트
   //BoardVO객체를 하나 생성하시고, VO setter을 사용하여 수정 내용(제목,내용)을 입력하고
   //수정을 진행해보세요. (1번글의 제목,내용 수정)
   @Test
   public void updateArticleTest() {
	   BoardVO vo = new BoardVO();
	   vo.setBoardNo(1);
	   vo.setTitle("lucytitle");
	   vo.setContent("lucycontent");
	   mapper.update(vo);
	   System.out.println("수정후 정보: "+mapper.getArticle(1));
   }
   
   //게시글 삭제 테스트:: 게시글 번호를 통해 삭제를 확인하세요.
   //3번글을 삭제하세요. 삭제 후 상세보기를 통해 3번글 가져왔을때 null이 리턴되는지 확인
   @Test
   public void deleteArticleTest() {
	   mapper.delete(3);
	   BoardVO vo = mapper.getArticle(3);
	   if(vo==null) {
		   System.out.println("게시물 없음");
	   }else {
		   System.out.println("게시물 있음");
	   }
   }
   
}













