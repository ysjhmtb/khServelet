<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import ="java.util.ArrayList" %>
 <%@page import="com.kh.java.notice.model.vo.NoticeVo"%>
 
<% ArrayList<NoticeVo> list = (ArrayList<NoticeVo>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항.</title>

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
	
	.tableArea{
		width:600px;
		height:400px;
		margin-left:auto;
		margin-right:auto;
		border:1px solid white;
	}
	
	table{
		text-align:center;
	}
	
	
</style>


</head>
<body>
<%@ include file = "../common/header.jsp" %>

<div class="outer">
	<h1>공지사항.</h1>
	<div class="tabelArea">
		<table align="center">
			<tr>
				<th>글 번호.</th>
				<th width="200">글 제목.</th>
				<th width="100">작성자.</th>
				<th>조회 수.</th>
				<th width="100">작성일.</th>
			</tr>	
			
			<%for(NoticeVo n : list){ %>
			
				<tr>
				
					<td><%=n.getNo() %></td>
					<td><a href="/mwp/noticeDetail.do/?noticeNo=<%=n.getNo()%>"><%=n.getTitle() %></a></td>
					<td><%=n.getWriter() %></td>
					<td><%=n.getCount() %></td>
					<td><%=n.getWriteDate() %></td>	
				</tr>
			
			<%} %>
			
			
		</table>
		
	</div>

</div>

<%@ include file = "../common/footer.jsp" %>
	
</body>
</html>