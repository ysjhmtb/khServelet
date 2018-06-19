<%@page import="com.kh.java.common.PageInfo"%>
<%@page import="com.kh.java.board.model.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BoardVo> list = (ArrayList<BoardVo>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getTotalCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
	height:300px;
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
<script>
	function writeBoard(){
		location.href="views/board/boardForm.jsp";
	}
	function searchBoard(){
		var condition = $("#searchCondition").val();
		var searchText = $("#searchText").val();
		//쿼리 스트링(파라미터 값 작성 방법)
		//url?key1=value1&key2=value2;
		location.href = "/mwp/searchBoard.do?condition=" + condition
																		+ "&keyword=" + searchText;
	}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="outer">
	<h1 align="center">공지사항</h1>
	<div class="tableArea">
		<table align="center">
			<tr>
				<th width="100">글번호</th>
				<th width="300">글제목</th>
				<th width="100">작성자</th>
				<th width="100">조회수</th>
				<th width="150">작성일</th>
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="5">조회 된 게시글이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(BoardVo n : list){ %>
				<tr>
					<td><%=n.getNo()%></td>			
					<td>
						<%=n.getTitle()%>
<!-- 						if()// (O) 출력 -->
<!-- 						else // (X) 출력 -->
						<%if(null != n.getAttachFile()){ %>
							(O)
						<%}else{ %>
							(X)
						<%} %>
					</td>			
					<td><%=n.getWriterName() %></td>			
					<td><%=n.getCount()%></td>			
					<td><%=n.getWriteDate() %></td>			
				</tr>
				<%} %>
			<%} %>
		</table>
	</div>
	
	<!-- 페이징 처리 부분     <<	1 2 3 4 5 6 7 ... >>  -->	
	<div class="pageArea" align="center">
		<button onclick="movePage(1);"> << </button>
		<%for(int i = startPage ; i <= endPage ; i++){ %>
			<%if(currentPage == i){ %>
				<button disabled><%=i %></button>
			<%}else{ %>
				<button onclick="movePage(<%=i%>);"><%=i %></button>
			<%} %>
		<%} %>
		<button onclick="movePage(<%=maxPage%>);"> >> </button>
	</div>
	
	
	
	
	
	<br>
	<div class="searchArea" align="center">
		<select id="searchCondition">
			<option value="0">전체</option>
			<%if(request.getAttribute("condition") != null){%>
				<option value="1" selected>제목</option>
			<%}else{ %>
				<option value="1">제목</option>
			<%} %>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>		
		<input type="text" id="searchText" placeholder="검색어 입력" value="<%=request.getAttribute("keyword")%>"/>
		<input type="button" value="검색하기" onclick="searchBoard();"/>
		<%if(null != member){%>
			<input type="button" value="작성하기" onclick="writeBoard();"/>
		<%} %>
	</div>
</div>
<script>
$(function(){
	$(".tableArea td").mouseenter(function(){
		$(this).parent().css("background","darkgray");
		$(this).parent().css("cursor","pointer");
	}).mouseout(function(){
		$(this).parent().css("background","black");
	}).click(function(){
		var boardNo = $(this).parent().children().eq(0).text();
		location.href = "/mwp/selectBoard.do?boardNo=" + boardNo + "&currentPage=" + <%=currentPage%>; 		
	});
});
function movePage(pageNum){
	location.href = "/mwp/searchBoard.do?currentPage=" + pageNum + "&keyword=<%=request.getAttribute("keyword")%>&condition=<%=request.getAttribute("condition")%>";
}

</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









