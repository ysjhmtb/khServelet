<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - if</title>
</head>
<body>
	<c:if test="${con eq 3 }">
		전송 된 값이 3이 맞습니다.<br/>
	</c:if>
	<c:if test="${con ne 3 }">
		전송 된 값이 3이 아닙니다.<br/>
	</c:if>
	무조건 출력 되는 영역<br/>





</body>
</html>