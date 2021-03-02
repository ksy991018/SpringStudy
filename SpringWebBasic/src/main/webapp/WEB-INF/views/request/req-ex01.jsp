<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> req-ex01 파일입니다~</h2>
	<p>컨트롤러 테스트 중입니다~</p>
	
	<form action="/web/request/basic01">
		<input type="submit" value="GET 요청!">
	</form>
	
	<form action="/web/request/basic01" method="POST">
		<input type="submit" value="POST 요청!">
	
	</form>
</body>
</html>