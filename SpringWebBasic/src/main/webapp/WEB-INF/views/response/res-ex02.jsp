<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자의 입력값을 Model 객체를 활용하여 전달하기!</h2>

	<form action="<c:url value='/response/join'/>" method="post">
		<fieldset>
			<legend>회원 가입 양식</legend>
			<p>
				# ID: <input type="text" name="userId" size="10"><br>
				# PW : <input type="password" name="userPw" size="10"><br>
				# NAME : <input type="text" name="userName" size="10"><br>
				# HOBBY : 
				<input type="checkbox" name="hobby" value="soccer">축구 &nbsp;
				<input type="checkbox" name="hobby" value="read">독서 &nbsp;
				<input type="checkbox" name="hobby" value="music">음악감상
			
				<br>
				<input type="submit" value="확인">
			</p>
			
		</fieldset>
	
	</form>
</body>
</html>