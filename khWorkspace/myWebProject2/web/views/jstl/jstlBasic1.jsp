<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- https://www.apache.org/dist/tomcat/taglibs/taglibs-standard-1.2.5/README_bin.txt  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 1</title>
</head>
<body>
	
	<!-- 페이지 스코프에 저장.  -->
	<c:set var="num1" value="500"/>	
	그냥 출력 : ${num1 } <br>	
	코어 out 출력 : <c:out value="${num1}"/> <br>
	
	<c:set var="username" value="최범석" scope="request"/> <br>
	<c:out value="${requestScope.username }"/> <br>
	<c:set var="username" value="홍길동" scope="session"/> <br>
	<c:out value="${sessionScope.username }"/> <br>
	
	<!-- request영역의 변수가 출력된다. -->	
	<c:out value="${username }"/> <br>
	
	
	<c:remove var="num1"/>
	코어 out 출력 : <c:out value="${num1}"/> <br>
	
	
	<c:remove var="username"/>
 	request 값 : <c:out value="${requestScope.username }"/> <br>
 	session 값 : <c:out value="${sessionScope.username }"/> <br>
 	
 	<hr>
 	
 	<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>"/> <br>
 	<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>" 
 		escapeXml="true"/> <br>
	<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>" 
 		escapeXml="false"/> <br>
 		
 	해당 숫자를 강조하겠습니다. <b><c:out value="500"/></b>
	
	
	<hr>
	
	
	
	

</body>
</html>