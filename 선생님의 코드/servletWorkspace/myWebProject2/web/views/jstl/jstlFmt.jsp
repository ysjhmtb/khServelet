<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - fmt</title>
</head>
<body>
	기본 값 출력 : <c:out value="${price }"/><br/>
	화폐 단위로 출력 : <fmt:formatNumber value="${price }" type="currency"/><br/>
	%로 출력 : <fmt:formatNumber value="${percent }" type="percent"/><br/>
	<c:out value="${percent * 100}"/> % 
	<!-- to_char() -> string -->
	<hr>
	기본 데이트 출력 : <c:out value="${now }"/><br/>
	기본 포멧(date) : <fmt:formatDate type="date" value="${now }"/><br/>
	기본 포멧(time) : <fmt:formatDate type="time" value="${now }"/><br/>
	기본 포멧(both) : <fmt:formatDate type="both" value="${now }"/><br/>
	
	date - dateStyle(long) : 
		<fmt:formatDate type="date" dateStyle="long" value="${now }"/><br/>
	time - timeStyle(medium) : 
		<fmt:formatDate type="time" timeStyle="medium" value="${now }"/><br/>
	
	



















	
	
	
</body>
</html>