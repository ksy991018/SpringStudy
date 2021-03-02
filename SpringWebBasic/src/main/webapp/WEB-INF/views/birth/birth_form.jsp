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
	<form action="<c:url value='/birth'/>" method="post">
		<fieldset>
			<legend>생일 등록 양식</legend>
			<p>
				# 생년월일: <input type="text" name="birthYear" size="6" maxlength="4"
					placeholder="연도(4자리) "> <select name="birthMonth">
					<c:forEach var="m" begin="1" end="12">
						<option value="${m}">${m}월</option>
					</c:forEach>
				</select> <select name="birthDay">
					<c:forEach var="d" begin="1" end="31">
						<option value="${d}">${d}일</option>
					</c:forEach>
				</select> <input type="submit" value="확인">
			</p>
		</fieldset>
	</form>
</body>
</html>