<%@page import="com.kh.java.notice.model.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	NoticeVo notice = (NoticeVo)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항!!</title>
<style>
.outer{
	width:800px;
	height:500px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	padding:20px;
	border:1px solid white;
}
</style>
</head>
<body>
<div class="outer">
		<h2 align="center">공지 사항 내용</h2>
		<div class="tableArea">
			<table>
				<tr>
					<th width="100">제 목 : </th>
					<td colspan="3"><%=notice.getTitle() %></td>
				</tr>
				<tr>
					<th>작성자 : </th>
					<td><%=notice.getName() %></td>
					<th width="100">작성일 : </th>
					<td><%=notice.getWriteDate() %></td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4"><%=notice.getContent() %></td>
				</tr>
			</table>
		</div>		
	</div>
</body>
</html>