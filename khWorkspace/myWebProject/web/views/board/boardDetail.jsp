<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.java.board.model.vo.CommentVo"%>
<%@page import="com.kh.java.board.model.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo board = (BoardVo)request.getAttribute("board");
	ArrayList<CommentVo> cList = (ArrayList<CommentVo>)request.getAttribute("cList");
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
.tableArea table,.tableArea table td,.tableArea table th{
	border:1px solid white;
}
.commentArea{
	width:800px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
}
.commentWriteArea{
	width:800px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	margin-bottom:50px;
}

</style>
<script>
	function bModifyPage(){
		location.href="/mwp/updateBoardForm.do?boardNo=<%=board.getNo()%>";
	}
	function boardPageList(){
		location.href = "<%=request.getContextPath()%>/boardList.do?currentPage=<%=request.getParameter("currentPage")%>";
	}
	function writeComment(){
		$("#commentForm").submit();
	}
	function updateCommentForm(obj, flag){
		var $textArea = $(obj).parent().parent().next().find("textarea");
		$textArea.prop("readonly", !flag);
		if(flag){
			$(obj).hide();
			$(obj).siblings(".deleteBtn").hide();
			$(obj).siblings(".updateBtn").show();
			$(obj).siblings(".cancelBtn").show();
		}else{
			$(obj).siblings(".modifyBtn").show();
			$(obj).siblings(".deleteBtn").show();
			$(obj).siblings(".updateBtn").hide();
			$(obj).hide();
		}
	}
	function updateComment(obj, cno){
		// 댓글 수정 -> 댓글 번호, 댓글 내용이 필요.
		var commentValue = $(obj).parent().parent().next().find("textarea").val();
		var cno = cno;
		
		
		
		location.href
		="updateComment.do?cno=" + cno + "&content=" + commentValue + "&bno=<%=board.getNo()%>";
	}
	
	function deleteComment(cno, bno){
		var cno = cno;
		var bno = bno;
		location.href = "deleteComment.do?cno=" + cno + "&bno=" + bno;
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
			<%if(null != board.getAttachFile()){ %>
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
				<td colspan="5">
					첨부파일이 존재하지 않습니다.
				</td>
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
		<button onclick="boardPageList();">목록으로</button>
		<%if(null != member && member.getUserId().equals(board.getWriter())){ %>
			<button onclick="bModifyPage();">수정하기</button>
		<%} %>
	</div>
	<div class="commentArea">
		<table width="800">
				<!-- 이름(작성일)  ---------------------<수정하기, 삭제하기> -->
				<!-- 댓글 내용 															-->
			<%for(CommentVo c : cList){ %>
			<tr>
				<td><%=c.getWriterNm() %>(<%=c.getWriteDate() %>)</td>
				<td align="right">
				<%if(member.getUserId().equals(c.getWriter())){ %>
					<input type="button" class="modifyBtn" value="수정" onclick="updateCommentForm(this, true);"/>
					<input type="button" class="deleteBtn" value="삭제" 
						onclick="deleteComment(<%=c.getCno()%>,<%=board.getNo()%>);"/>
					<input type="button" class="updateBtn" style="display:none;" 
						value="작성 완료" onclick="updateComment(this,<%=c.getCno()%>);"/>
					<input type="button" class="cancelBtn" style="display:none;" value="취소" 
						onclick="updateCommentForm(this, false);"/>
				<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea cols="108" rows="4" readonly><%=c.getContent() %></textarea>
				</td>
			</tr>
			<%} %>
		</table>
	</div>
	<%if(member != null){ %>
	<div class="commentWriteArea">
		댓글
		<form method="post" id="commentForm" action="writeComment.do">
			<table width="800">
				<input type="hidden" name="bno" value="<%=board.getNo()%>"/>
				<input type="hidden" name="writer"	value="<%=member.getUserId() %>"/>
				<tr>
					<td>
						<textarea cols="90" rows="4" name="content"></textarea>
					</td>
					<td>
						<!-- <input type="submit" value="댓글작성"/> -->
						<input type="button" onclick="writeComment();" value="댓글작성"/>
					</td>
				</tr>
			</table>		
		</form>
	</div>
	<%} %>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>










