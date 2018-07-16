<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - url</title>
</head>
<body>
	오늘의 추천 야식 : <c:out value="${param.mns }"/> <br>
	오늘의 추천 영화 : <c:out value="${param.movie }"/> <br>
	
	

</body>
</html>