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
<title>게시글 수정</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="outer">
	<h2 align="center">게시글 수정</h2>
	<div class="tableArea" align="center">
		<form method="post" action="/mwp/updateBoard.do" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="<%=board.getWriter()%>"/>
			<input type="hidden" name="boardNo" value="<%=board.getNo()%>"/>
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="title" size="33" value="<%=board.getTitle()%>"/>
					</td>
				</tr>
				<!-- file - value 속성은 사용자 피씨의 자원에
							 직접 접근 한다는 것이기 때문에 보안에 취약하다 -->
<!-- 				<tr> -->
<!-- 					<td>첨부파일</td> -->
<!-- 					<td colspan="4"> -->
<%-- 						<input type="file" name="file" value="<%=board.getAttachFile()%>"/> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
				<%if(null != board.getAttachFile()){ %>
				<tr>
					<th>미리보기</th>
					<td colspan="3">
						<a target="_blank" href="/mwp/upload/<%=board.getAttachFile()%>"><%=board.getAttachFile()%></a>
					</td>
				<tr>
				<%} %>
				<tr>
					<th>새 파일</th>
					<td colspan="3">
						<input type="file" name="newFile"/>
						<input type="hidden" name="oldFile" value="<%=board.getAttachFile() %>"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="40" rows="15"><%=board.getContent() %></textarea>
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
<%@ include file="../common/footer.jsp" %>
</body>
</html>


