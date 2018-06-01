<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String msg = (String) request.getAttribute("msg");

%>

<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지.</title>

<style>
	.outer{
		width: 600px;
		height: 500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border: 1px solid white;
	}
</style>

</head>
<body>
	<%@ include file = "header.jsp" %>
	<div class="outer">
		<h1>서비스 에러 발생!!!</h1>
		<h3>ERROR : <%= msg %></h3>
		<h4>해당 사항 관련 문의는 010-1234-5678 로 연락 바랍니다.</h4>
		<!-- <a href="/mwp/index.jsp">메인 페이지로 이동.</a> -->
	</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>

