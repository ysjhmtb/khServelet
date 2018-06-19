<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 운세</title>
<%
	//Date date = new Date();
	//String str3 = String.format("%tY년 %tm월 %td일", date, date, date);
%>
</head>
<body>
<!-- 	XXXX년 XX월 XX일 오늘의 운세 -->
	<p>오늘의 운세</p>
	<select>
		<option value="1">쥐띠</option>
		<option value="2">소띠</option>
		<option value="3">호랑이띠</option>
		<option value="4">토끼띠</option>
		<option value="5">용띠</option>
		<option value="6">뱀띠</option>
		<option value="7">말띠</option>
		<option value="8">양띠</option>
		<option value="9">원숭이띠</option>
		<option value="10">닭띠</option>
		<option value="11">개띠</option>
		<option value="12">돼지띠</option>
	</select>
	<hr>
	<!-- include : 현재 페이지에 해당 파일(서블릿)을 추가 한다.
	스크립틀릿, 선언문 에서 변수 및 메소드 중복 선언 불가-->
	<%@ include file="2.today.jsp" %>	
</body>
</html>










