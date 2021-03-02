<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> ${boardNo}번 게시물 내용</h2>
	<p>
		# 글 번호: ${boardNo} <br>
		# 작성자: ${article.writer} <br>
		# 제목:  ${article.title }<br>
		# 내용: <textarea rows="3">${article.content }</textarea>
	</p>
	
	<a href="<c:url value='/board/list'/>">글 목록보기</a>
	<a href="<c:url value='/board/modify?boardNo=${boardNo}'/>">글 수정하기</a>
</body>
</html>