<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
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
		$("#noticeForm").attr("action","deleteNotice.do");
		$("#noticeForm").submit();
	}
	
	
</script>

</head>
<body>
<div class="outer">
	<h2 align="center">공지사항 작성</h2>
	<div class="tableArea" align="center">
		<form id="noticeForm" method="post" action="updateNotice.do" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="admin"/>
			<input type="hidden" name="no" value="${notice.no }"/>
			<input type="hidden" name="attach" value="${notice.attach }"/>
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="title" size="33" value="${notice.title }"/>					
					</td>
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
					<th>변경파일 : </th>
					<td colspan="3">
						<input type="file" name="addedFile"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="40" rows="15">${notice.content }</textarea>
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" value="수정"/>
				<input type="button" value="취소" onclick="noticePage();"/>
				<input type="button" value="삭제" onclick="deleteNotice();"/>
			</div>
		</form>
	</div>
</div>
<c:import url="../footer.jsp"/>  
</body>
</html>