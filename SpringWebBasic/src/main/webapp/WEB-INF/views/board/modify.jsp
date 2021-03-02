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
	<h2>${boardNo}번 게시물 내용</h2>
	<form method="post">
		<input type="hidden" name="boardNo" value="${boardNo}">
		<p>
			# 작성자: <input type="text" name="writer" value="${article.writer}"> <br>
			# 제목: <input type="text" name="title" value="${article.writer}"><br>
			# 내용: <textarea rows="3" name="content">${article.content}</textarea> <br>
			<input type="submit" value="수정완료">
		</p>
	</form>
</body>
</html>