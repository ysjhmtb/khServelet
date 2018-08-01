<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>      
<!DOCTYPE html>
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>

<meta charset="UTF-8">
<title>공지사항 수정</title>
<style>
.outer{
	width:800px;
	height:900px;
	background:black;
	color:gray;
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
	$(function() {
	  $('#summernote').summernote({
		  height: 600
	  });
	});
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
						<textarea id="summernote" name="content">${notice.content }</textarea>
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