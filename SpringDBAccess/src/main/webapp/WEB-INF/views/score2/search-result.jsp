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

	<h2>선택한 학생 정보</h2>
	<p>
		# 이름: ${stu.stuName}, # 국어: ${stu.kor }, # 영어: ${stu.eng},
		# 수학: ${stu.math}, # 총점: ${stu.total}, # 평균: ${stu.average}			
	</p>
	
	<a href="<c:url value='/mybatis/score/list'/>">점수 전체조회 </a>
	<a href="<c:url value='/mybatis/score/search'/>">점수 개별조회 </a>
	
</body>
</html>