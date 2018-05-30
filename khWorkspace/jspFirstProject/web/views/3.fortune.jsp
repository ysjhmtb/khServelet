<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.Date, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 운세.</title>

<%

	
%>

</head>
<body>
	<!--XXXX년 XX월 XX일 오늘의 운세.  -->
	
	<select>
		<option value="1">쥐띠.</option>
		<option value="2">소띠.</option>
		<option value="3">호랑이띠.</option>
		<option value="4">토끼띠.</option>
		<option value="5">용띠.</option>
		<option value="6">뱀뛰.</option>
		<option value="7">말띠.</option>
		<option value="8">양띠.</option>
		<option value="9">원숭이띠.</option>
		<option value="10">닭띠.</option>
		<option value="11">개띠.</option>
		<option value="12">돼지띠.</option>
	</select>
	
	<hr>
	
	<!-- 페이지 지시자의 인클루드 속성은 해당 파일(서블릿)을 추가한다.
	스크립틀릿, 선언문에서 변수 및 메소드 중복 선언 불가.   -->
	<%@ include file = "2.today.jsp" %>
	
	

</body>
</html>


