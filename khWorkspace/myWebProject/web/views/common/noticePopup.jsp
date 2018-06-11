<%@page import="com.kh.java.notice.model.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    
<%
	NoticeVo notice = (NoticeVo)request.getAttribute("notice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 팝업!!</title>

<style>
.outer{
	width:300px;
	height:400px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	padding:20px;
	border:1px solid white;
}
.tableArea{
	width:300px;
	height:400px;
	margin-left:auto;
	margin-right:auto;
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
					<th width="50">제 목 : </th>
					<%-- <td><%=notice.getTitle() %></td> --%>
					<td>${notice.title}</td>
				</tr>
				
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<%-- <td colspan="2"><%=notice.getContent() %></td> --%>
					<td>${notice.content}</td>
				</tr>
			</table>
			
			
		</div>		
	</div>
	
	
</body>
</html>