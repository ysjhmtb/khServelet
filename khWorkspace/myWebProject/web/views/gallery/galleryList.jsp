<%@page import="com.kh.java.gallery.model.vo.AttachmentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<AttachmentVo> list 
				= (ArrayList<AttachmentVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판</title>
<style>
	.outer{
		width:1000px;
		height:700px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	
	.thumnailArea{
		width:800px;
		height:550px;
		margin-left:auto;
		margin-right:auto;
	}
	
	.image-list{
		width:240px;
		border:1px solid white;
		display:inline-block;
		margin:10px;
		align:center;
	}
	
	.image-list:hover{
		opacity:0.7;
		cursor:pointer;
	}
</style>

<script>
	function moveGalleryForm(){
		location.href="/mwp/views/gallery/galleryFrom.jsp";
		
	}

</script>

</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
	<br>
		<h1 align="center">이미지 게시판</h1>
		<div class="thumnailArea">
			<%for(int i = 0; i < list.size() ; i++){ %>
			<%	AttachmentVo av = list.get(i); %>			
				<div class="image-list" align="center">
					<div>
						<img src="/mwp/photoUpload/<%=av.getChangeName()%>" 
									width="200px" height="150px"/>
					</div>
					<p>
						<%=av.getBno()%>. <%=av.getTitle()%><br>
						다운로드 : <%=av.getDownloadCount()%>
					</p>				
				</div>
			<%} %>
		</div>
		<div class="searchArea" align="center">
			<select id="searchCondition">
				<option value="0">전체</option>
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">작성자</option>
			</select>		
			<input type="text" id="searchText" placeholder="검색어 입력"/>
			<input type="button" value="검색하기" onclick=""/>
			<%if(null != member){%>
				<input type="button" value="작성하기" onclick="moveGalleryForm()"/>
			<%} %>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>
















