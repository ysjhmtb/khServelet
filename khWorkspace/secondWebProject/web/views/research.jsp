<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String name = (String) request.getAttribute("name");
	String color = (String) request.getAttribute("color");
	String reClothes = (String) request.getAttribute("reClothes");
	String foodStr = (String) request.getAttribute("foodStr");
	String animal = (String) request.getAttribute("animal");
%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>취향 조사 결</title>
</head>
<body>
	<h2>개인 취향 테스트 결과(Jsp)</h2>
	<span>이름 : <%=name%></span>
	<br>
	<span style="color: skyblue; font-weight: bold">좋아하는 색 : <%=color%></span>
	<br>
	<span style="color: skyblue; font-weight: bold">좋아하는 동물 : <%=animal%></span>
	<br>
	<span style="color: skyblue; font-weight: bold">좋아하는 음식 : <%=foodStr%></span>
	<br>
	<hr>
	<span style="color: skyblue; font-weight: bold"> <%=color%> 을(를)
		선택하신 당신에겐 <%=reClothes%> 이(가) 어울리실것 같네요~!!"
	</span>

</body>
</html>