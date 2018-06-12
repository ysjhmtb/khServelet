<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

<style>
.outer{
	width:800px;
	height:570px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	border:1px solid white;
}
.tableArea{
	width:600px;
	height:400px;
	margin-left:auto;
	margin-right:auto;
}
table td{
	text-align:center;
}
.searchArea{
	width:650px;
	margin-left:auto;
	margin-right:auto;
}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="outer">
	<h2 align="center">게시글 작성</h2>
	<div class="tableArea" align="center">
		<form method="post" action="/mwp/writeBoard.do" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="<%=member.getUserId()%>"/>
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="title" size="33"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="45" rows="15"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일 : </th>
					<td>
						<input type="file" name="attFile" id="attFile"/>
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
<%@ include file="../common/footer.jsp" %>
</body>
</html>



