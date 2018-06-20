<%@page import="com.kh.java.gallery.model.vo.AttachmentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<AttachmentVo> list = (ArrayList<AttachmentVo>)request.getAttribute("list");
	AttachmentVo mainImage = list.get(0);
	AttachmentVo detailImage1 = list.get(1);
	AttachmentVo detailImage2 = list.get(2);
	AttachmentVo detailImage3 = list.get(3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판 상세보기</title>
<style>
.outer{
	width:1000px;
	height:850px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	margin-top:50px;
	padding:30px;
}
.titleImageArea{
	width:500;
	height:300;
}

table, table tr, table td{
	background:black;
	color:white;
}

.detailImageArea{
	width:300px;
	height:200px;
	margin:auto;
}

</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="outer">
	<table>
		<tr>
			<td>제목</td>
			<td colspan="5"><%=mainImage.getTitle()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=mainImage.getUsername()%></td>
			<td>작성일</td>
			<td><%=mainImage.getWriteDate()%></td>
			<td>다운로드 횟수</td>
			<td><%=mainImage.getDownloadCount()%></td>
		</tr>
		<tr>
			<td>대표 사진</td>
			<td colspan="5">
				<div class="titleImageArea" align="center">
					<img src="/mwp/upload_gallery/<%=mainImage.getChangeName()%>"/><br>
					<a href="/mwp/upload_gallery/<%=mainImage.getChangeName()%>" download><button>다운로드</button></a>
				</div>
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="5"><%=mainImage.getContent()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<div class="detailImageArea" align="center">
					<img width="200" height="200" src="/mwp/upload_gallery/<%=detailImage1.getChangeName()%>"/><br>
					<a href="/mwp/upload_gallery/<%=detailImage1.getChangeName()%>" download><button>다운로드</button></a>
				</div>
			</td>
			<td>
				<div class="detailImageArea" align="center">
					<img width="200" height="200"  src="/mwp/upload_gallery/<%=detailImage2.getChangeName()%>"/><br>
					<a href="/mwp/upload_gallery/<%=detailImage2.getChangeName()%>" download><button>다운로드</button></a>
				</div>
			</td>
			<td>
				<div class="detailImageArea" align="center">
					<img width="200" height="200"  src="/mwp/upload_gallery/<%=detailImage3.getChangeName()%>"/><br>
					<a href="/mwp/upload_gallery/<%=detailImage3.getChangeName()%>" download><button>다운로드</button></a>
				</div>
			</td>
		</tr>
	</table>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>