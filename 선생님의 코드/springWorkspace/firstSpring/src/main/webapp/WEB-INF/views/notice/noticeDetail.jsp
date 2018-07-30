<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>    
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
	margin:auto;
	border:1px solid white;
}
.tableArea table{
	padding:20px;
}
</style>
<script>
	function updateNoticePage(){
		location.href="updateNoticeForm.do?no=${notice.no}";
	}
</script>
</head>
<body>
	<div class="outer">
		<h2 align="center">공지 사항 내용</h2>
		<div class="tableArea">
			<table>
				<tr>
					<th width="100">제 목 : </th>
					<td colspan="3">${notice.title }</td>
				</tr>
				<tr>
					<th>작성자 : </th>
					<td>${notice.writer }</td>
					<th width="100">작성일 : </th>
					<td>${notice.date }</td>
				</tr>
				<tr>
					<th>첨부파일 : </th>
					<td colspan="3">
						<a href="/firstSpring/resources/upload/${notice.attach }" download>
							${notice.attach }
						</a>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">${notice.content }</td>
				</tr>
			</table>
			<div align="center">
				<button onclick="noticePage();">목록으로</button>
				<c:if test="${!empty user && user.userid eq 'admin'}"> 
					<button onclick="updateNoticePage();">수정하기</button>
				</c:if>
			</div>
		</div>		
	</div>
<c:import url="../footer.jsp"/>	
</body>
</html>











