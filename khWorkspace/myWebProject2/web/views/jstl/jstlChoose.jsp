<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> jstl choose </title>
</head>
<body>

	<c:set var="condition" value="${ param.con }"/>
	check value : <c:out value="${condition }"/> <br>
	
	<c:choose>
		<c:when test="${condition eq 1 }">
			전송값은 1입니다.
		
		</c:when>
	
		 <c:when test="${condition eq 2 }">
			전송값은 2입니다.
		
		</c:when>
		
		<c:when test="${condition == 3 }">
			전송값은 3입니다.
		
		</c:when>
		
		<c:otherwise>
			그외 나머지 값이 전송되었습니다. <br> 
			전송값은 <c:out value="${condition }"/> 입니다. <br>
		</c:otherwise>
		
		
		
	</c:choose>
	
	
	

</body>
</html>