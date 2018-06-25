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
<title>공지사항 팝업!!</title>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<style>
.outer{
	width:300px;
	height:600px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	border:1px solid white;
}
.tableArea{
	width:300px;
	height:400px;
	margin:auto;
	border:1px solid white;
}
</style>
<script>
	$(function(){
		$("#closeBtn").click(function(){
			if($("#dayCheck").prop("checked")){
				localStorage.setItem("dayCheck",new Date());
			}
			close();
		});
	});

</script>
</head>
<body>
<div class="outer">
	<h2 align="center">최근 공지사항</h2>
	<div class="tableArea">
		<table>
			<tr>
				<th width="50">제 목 : </th>
				<!--<td><%=notice.getTitle() %></td>-->
				<td>${notice.title}</td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td colspan="2">${notice.content}</td>
			</tr>
		</table>
	</div>
	<input type="checkbox" id="dayCheck"/> 오늘 하루 동안 열지 않기
	<button id="closeBtn">닫기</button>		
</div>	
</body>
</html>










