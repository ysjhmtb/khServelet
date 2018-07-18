<%@page import="com.kh.java.notice.model.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
					<td colspan="3"> <c:out value="${notice.title }" /> </td>
				</tr>
				<tr>
					<th>작성자 : </th>
					<td> <c:out value="${notice.writer }"/> </td>
					<th width="100">작성일 : </th>
					<td> <c:out value="${notice.writeDate }"/> </td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4"> <c:out value="${notice.content }"/> </td>
				</tr>
			</table>
			
			<div align="center">
				<button onclick="noticeList()">목록으로 돌아가기.</button>
				
				<c:if test="${ (!empty member) && (\"admin\".equals(member.userId)) }">
					<button onclick="updateNoticePage()">수정하기.</button>
				
				</c:if>
			
			</div>
		</div>		
	</div>
	
	
	
<%@ include file="../common/footer.jsp" %>	
</body>
</html>






