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
<title>공지사항 상세보기</title>
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
.tableArea table{
	padding:20px;
}
</style>


<script>
	function noticeList(){
		
		location.href = "/mwp/noticeList.do";
		
	}
	
	function updateNoticePage(){
		location.href = "/mwp/updateNoticeForm.do?noticeNo=<%=notice.getNo()%>";
	}


</script>

</head>
<body>
<%@ include file="../common/header.jsp" %>




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
			
			<div align="center">
				<button onclick="noticeList()">목록으로 돌아가기.</button>
				
				<%if(null != member && member.getUserId().equals("admin")){ %>
					<button onclick="updateNoticePage()">수정하기.</button>
				<%} %>
			
			</div>
		</div>		
	</div>
	
	
	
<%@ include file="../common/footer.jsp" %>	
</body>
</html>






