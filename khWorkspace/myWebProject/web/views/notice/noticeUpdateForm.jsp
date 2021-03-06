<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.java.notice.model.vo.NoticeVo" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정.</title>

<%
	NoticeVo notice = (NoticeVo) request.getAttribute("notice");
%>

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

<script>
	function deleteNotice(){
		if(confirm("삭제하시겠습니까?")){
			location.href = "/mwp/deleteNotice.do?noticeNo=${notice.no}";
		}
		
		
		
	}
</script>



</head>
<body>
	<%@include file="../common/header.jsp" %>
	
	<div class="outer">
		<h2 align="center">공지사항 수정.</h2>
		<div class="tableArea" align="center">
			<form method="post" action="/mwp/updateNotice.do">
			
				<input type="hidden" name="writer" value="${notice.writer}">
				<input type="hidden" name="noticeNo" value="${notice.no}">
				
				<table>
				
				
				<tr>
					<th>제 목 : </th>
					<td colspan="3"><input type="text" name="title" size="33" value="${notice.title}"></td>
				</tr>
				
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="40" rows="15"> <c:out value="${notice.content }"/> </textarea>
					</td>
				</tr>
			</table>
			
			<div align="center">
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="noticePage()">
				<input type="button" value="삭제" onclick="deleteNotice()">
			</div>
				
				
			</form>
		</div>
	</div>
	
	<%@include file="../common/footer.jsp" %>

</body>
</html>