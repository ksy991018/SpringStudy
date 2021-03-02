﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
header.masthead {
	display: none;
}
</style>
<br />
<br />
<div class="container">

	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header text-white"
					style="background-color: #643691;">${article.boardNo }번게시물 내용</div>
				<div class="card-body">


					<div class="form-group">
						<label>작성자</label> <input type="text" class="form-control"
							name='writer' value="${article.writer}" readonly>
					</div>

					<div class="form-group">
						<label>제목</label> <input type="text" class="form-control"
							name='title' value="${article.title }" readonly>
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="5" name='content' readonly>${article.content }</textarea>
					</div>

					<form id="formObj" role="form" action="<c:url value='/board/delete'/>" method="post">
					 
					 	<input type="hidden" name="boardNo" value="${article.boardNo}">

						<input type="button" value="목록" class="btn" id="list-btn" 
							style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
						<input type="button" value="수정" class="btn"  id="modBtn"
							style="background-color: orange; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
						<input type="submit" value ="삭제" class="btn"  onclick="return confirm('정말로 삭제하시겠습니까?')"
							style="background-color: red; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
					</form>



				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />

<script>
		const msg="${msg}";
		if(msg==="modSuccess"){
			alert("게시글 수정이 완료되었습니다.");
		}

		//제이쿼리의 시작.
		$(function() {
			
			//목록버튼 클릭 이벤트 처리.
			$("#list-btn").click(function() {
				console.log("목록 버튼이 클릭됨!");
				location.href="/board/list";
			}); //목록버튼 처리끝.
			
			//변수는 let, 상수는 const로 선언
			//cost formElement = document.getElementById("formObj"); //vanilla js(순수 자바스크립트)
			const formElement = $("#formObj"); //제이쿼리 방식
			
			$("#modBtn").click(function() {
				console.log("수정 버튼이 클릭됨!");
				formElement.attr("action","/board/modify");
				formElement.attr("method","get");
				formElement.submit();
			});
			
		}); //제이쿼리의 끝.
		
</script>