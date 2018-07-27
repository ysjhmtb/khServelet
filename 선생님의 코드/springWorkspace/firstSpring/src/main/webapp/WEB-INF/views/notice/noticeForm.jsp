<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
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
	<h2 align="center">공지사항 작성</h2>
	<div class="tableArea" align="center">
		<form method="post" action="writeNotice.do" 
								enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${user.userid }"/>
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="title" size="33"/>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<input type="file" name="file"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="40" rows="15"></textarea>
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" value="작성"/>
				<input type="button" value="취소" onclick="noticePage();"/>
			</div>
		</form>
	</div>
</div>
<c:import url="../footer.jsp"/> 
</body>
</html>













