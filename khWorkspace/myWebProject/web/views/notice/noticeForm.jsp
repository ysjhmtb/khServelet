<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성.</title>


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

	<%@include file="../common/header.jsp" %>
	
	<div class="outer">
		<h2 align="center">공지사항 작성.</h2>
		<div class="tableArea" align="center">
			<form method="post" action="/mwp/writeNotice.do">
			
				<input type="hidden" name="writer" value="<%=member.getUserId()%>">
				
				<table>
				<tr>
					<th>제 목 : </th>
					<td colspan="3"><input type="text" name="title" size="33"></td>
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
				<input type="submit" value="작성">
				<input type="button" value="취소" onclick="noticePage()">
			</div>
				
				
			</form>
		</div>
	</div>
	
	<%@include file="../common/footer.jsp" %>
	
</body>
</html>