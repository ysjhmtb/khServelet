<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - choose</title>
</head>
<body>
	<c:set var="condition" value="${param.con}"/>
	값 확인 : <c:out value="${condition }"/><br/>
	<c:choose>
		<c:when test="${condition == 1 }">
			전송 값은 1 입니다.
		</c:when>
		<c:when test="${condition == 2 }">
			전송 값은 2 입니다.
		</c:when>
		<c:when test="${condition == 3 }">
			전송 값은 3 입니다.
		</c:when>
		<c:otherwise>
			그 외 값이 전송 되었습니다. <br/>
			전송 값은 <c:out value="${condition }"/> 입니다.
		</c:otherwise>
	</c:choose>
</body>
</html>