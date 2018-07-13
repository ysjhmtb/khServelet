<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 출력</title>
</head>
<body>
이름 : ${requestScope.member.name}<br/>
나이 : ${requestScope.member.age }<br/>
전화번호 : ${requestScope.member.phone }<br/>
<hr>
이름 : ${sessionScope.member.name}<br/>
나이 : ${sessionScope.member.age }<br/>
전화번호 : ${sessionScope.member.phone }<br/>
<hr>
이름 : ${member.name}<br/>
나이 : ${member.age }<br/>
전화번호 : ${member.phone }<br/>
<hr>
page -> request -> session -> application
값이 유지되는 작은 범위의 scope 부터 검색 해서 값이 존재할 경우
해당 스코프의 값 출력










</body>
</html>