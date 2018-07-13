<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 확인</title>
</head>
<body>
이름 : ${param.name}<br>
나이 : ${param.age}<br>

취미 : 
${paramValues.hobby[0] }, ${paramValues.hobby[1] }
</body>
</html>