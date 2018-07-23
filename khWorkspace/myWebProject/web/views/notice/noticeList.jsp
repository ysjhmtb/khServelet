<%@page import="com.kh.java.notice.model.vo.NoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<% ArrayList<NoticeVo> list 
				= (ArrayList<NoticeVo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항 목록</title>
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
		width:600px;
		margin-left:auto;
		margin-right:auto;
	}
	
	a{
		color:white;
	}
</style>
<script>
	function searchNotice(){
		var condition = $("#searchCondition").val();
		var searchText = $("#searchText").val();
		//쿼리 스트링(파라미터 값 작성 방법)
		//url?key1=value1&key2=value2;
		location.href = "/mwp/searchNotice.do?condition=" + condition
																		+ "&keyword=" + searchText;
		
	}
	
	
	function writeNotice(){
		
		location.href = "/mwp/views/notice/noticeForm.jsp";
		
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
				<th>글번호</th>
				<th width="200">글제목</th>
				<th width="100">작성자</th>
				<th>조회수</th>
				<th width="100">작성일</th>
			</tr>
			
			
			
			<c:if test="${fn:length(list) == 0 }">
				<tr>
					<td colspan="5">조회 된 공지사항이 없습니다.</td>
				</tr>
			</c:if>
			
			
			<c:if test="${fn:length(list) != 0 }">
				<c:forEach items="${list }" var="noticeVo" varStatus="status">					
					<tr>
						<td>${noticeVo.nno }</td>
						<td>
							<a href="/mwp/noticeDetail.do?noticeNo=${noticeVo.nno }">${noticeVo.ntitle }</a>
						</td>						
						<td>${noticeVo.name }</td>						
						<td>${noticeVo.ncount }</td>						
						<td>${noticeVo.ndate }</td>
					</tr>
				</c:forEach>	
			</c:if>
						
		</table>
	</div>
	
	
	<div class="searchArea" align="center">
		<select id="searchCondition">
			<option value="0">전체</option>
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>		
		<input type="text" id="searchText" placeholder="검색어 입력"/>
		<input type="button" value="검색하기" onclick="searchNotice();"/>
		

		<c:if test="${!empty member && (member.userId).equals('admin') }">
			<input type="button" value="작성하기" onclick="writeNotice();"/>
		</c:if>
		
	</div>
</div> 


<%-- <div class="outer">
	<h1 align="center">공지사항</h1>
	<div class="tableArea">
		<table align="center">
			<tr>
				<th>글번호</th>
				<th width="200">글제목</th>
				<th width="100">작성자</th>
				<th>조회수</th>
				<th width="100">작성일</th>
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="5">조회 된 공지사항이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(NoticeVo n : list){ %>
				<tr>
					<td><%=n.getNo() %></td>			
					<td>
	<a href="/mwp/noticeDetail.do?noticeNo=<%=n.getNo() %>"><%=n.getTitle() %></a>
					</td>			
					<td><%=n.getName() %></td>			
					<td><%=n.getCount() %></td>			
					<td><%=n.getWriteDate() %></td>			
				</tr>
				<%} %>
			<%} %>
		</table>
	</div>
	<div class="searchArea" align="center">
		<select id="searchCondition">
			<option value="0">전체</option>
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>		
		<input type="text" id="searchText" placeholder="검색어 입력"/>
		<input type="button" value="검색하기" onclick="searchNotice();"/>
		<%if(null != member && "admin".equals(member.getUserId())){ %>
			<input type="button" value="작성하기" onclick="writeNotice();"/>
		<%} %>
	</div>
</div> --%>







<%@ include file="../common/footer.jsp" %>
</body>
</html>





