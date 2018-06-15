<%@page import="com.kh.java.board.model.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo board = (BoardVo)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
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
	width:800px;	
	margin-left:auto;
	margin-right:auto;
}
a{
	text-decoration:none;
	color:white;
}
table, table td, table th{
	border:1px solid white;
}
</style>



<script>
	function bModifyPage(){
		location.href = "/mwp/updateBoardForm.do?boardNo="+<%=board.getNo()%>;
	}
	
	function bDeletePage(){
		location.href = "/mwp//deleteBoard.do?boardNo="+<%=board.getNo()%>;
	}

</script>

</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="outer">
	<h2 align="center">게시글 상세 내용</h2>
	<div class="tableArea">
		<table width="800">
			<tr>
				<th>제목</th>
				<td colspan="5"><%=board.getTitle()%></td>
			</tr>	
			<tr>
				<th width="200">작성자</th>
				<td><%=board.getWriterName() %></td>
				<th width="100">조회수</th>
				<td><%=board.getCount() %></td>
				<th width="100">작성일</th>
				<td><%=board.getWriteDate() %></td>
			</tr>
			
			
			<%if(null != board.getAttachFile()) {%>
			
			<tr>
				<th>미리보기</th>
				<td colspan="5">
					<a target="_blank" href="/mwp/upload/<%=board.getAttachFile()%>">파일 미리보기</a>
				</td>
			</tr>
			<tr>
				<th>첨부파일(다운)</th>
				<td colspan="5">
					<a href="/mwp/fileDownload.do?filename=<%=board.getAttachFile()%>"><%=board.getAttachFile()%></a>
				</td>
			</tr>
			
			<%}else{ %>
			
			<tr>
				<th>첨부파일</th>
				<td colspan="5">첨부파일이 없습니다.</td>
			
			</tr>
			
			
			<%} %>
			
			
			
			
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td colspan="6">
					<p><%=board.getContent() %></p>
				</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<button onclick="boardPage();">목록으로</button>
		<%if(null != member && member.getUserId().equals(board.getWriter())){ %>
			<button onclick="bModifyPage();">수정하기</button>
			<button onclick="bDeletePage()">삭제하기</button>
		<%} %>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>










