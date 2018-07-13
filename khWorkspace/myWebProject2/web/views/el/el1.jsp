<%@page import="com.kh.java.el.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>값 출력 확인</title>
</head>
<body>
<h3>값 출력 확인</h3>
이름 : <%=m.getName() %><br/>
나이 : <%=m.getAge() %><br/>
전화번호 : <%=m.getPhone() %><br/>

<h3>값 출력 확인el</h3>
이름 : ${requestScope.member.name }<br/>
나이 : ${requestScope.member.age}<br/>
전화번호 : ${requestScope.member.phone }<br/>

<h3>값 출력 확인 scope 생략</h3>
이름 : ${member.name }<br/>
나이 : ${member.age}<br/>
전화번호 : ${member.phone}<br/>
</body>
</html>















