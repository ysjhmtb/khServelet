<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 선택 결과</title>
<%
	String name = (String)request.getAttribute("name");
	String menu = (String)request.getAttribute("menu");
	int price = (int)request.getAttribute("price");
%>
</head>
<body>
<!-- 	XX로 가서 XX를 먹으려고 합니다. -->
<!-- 	가격은 XX 입니다. -->
<!-- if(price == 0){ -->
<!-- }else{ -->
<!-- } -->
<%if(price != 0){ %>
	<h1>
		<%=name %>로 가서 <%=menu %>를 먹으려고 합니다. <br>
		가격은 <%=price %> 입니다.	
	</h1>
<%}else{ %>
	<h1>오늘은 강제 다이어트 하는 날입니다.</h1>
<%} %>	
<!-- 	0원 일 경우에는 '오늘은 강제 다이어트 하는 날 입니다.' -->
</body>
</html>





