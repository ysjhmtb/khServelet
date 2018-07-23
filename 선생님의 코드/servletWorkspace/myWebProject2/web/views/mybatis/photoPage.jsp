<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호 : <c:out value="${photo.no }"/><br/>
	제목 : <c:out value="${photo.title }"/><br/>
	내용 : <c:out value="${photo.content }"/><br/>
	조회수 : <c:out value="${photo.readCount }"/><br/>
	작성일 : <c:out value="${photo.writeDate }"/><br/>
	작성자 : <c:out value="${photo.userId }"/><br/>
	<hr>
	<p>댓글</p>
	<c:forEach items="${photo.reply}" var="reply">
		<c:out value="${reply.writer }"/> - 
		<c:out value="${reply.content }"/> <br/>
	</c:forEach>
	
	
		
	
	
</body>
</html>










