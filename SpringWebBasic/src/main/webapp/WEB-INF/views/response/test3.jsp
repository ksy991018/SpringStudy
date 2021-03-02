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

   <h2>회원 가입 정보 출력하기</h2>
   <p>
      # 회원 전체 정보: ${user} <br>
      # 아이디: ${user.userId} <br>
      # 비밀번호: ${user.userPw} <br>
      # 이름: ${user.userName} <br>
      # 취미: 
      <c:if test="${user.hobby != null}">
         <c:forEach var="h" items="${user.hobby}">
            ${h}&nbsp;
         </c:forEach>
      </c:if>
      <c:if test="${user.hobby == null}">
         이 사람은 취미가 없네?
      </c:if>
   </p>

</body>
</html>









