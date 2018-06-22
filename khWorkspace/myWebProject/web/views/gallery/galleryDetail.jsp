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
	height:1000px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	margin-top:50px;
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

#replyArea{
	width:1000px;
	margin-bottom:50px;
}

.commentWriteArea{
	width:1000px;
	background:black;
	color:white;
	margin-left:auto;
	margin-right:auto;
	margin-bottom:80px;
}
li{
	background:black;
}

ul{
	padding:0px;
	list-style:none;
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
	<br>
	<%if(null != member){ %>
	<div class="commentWriteArea">
		<form method="post" id="commentForm" action="writeComment.do">
			<table width="800">
				<input type="hidden" name="bno" id="bno" value="<%=mainImage.getBno()%>"/>
				<input type="hidden" name="writer"	id="writer" value="<%=member.getUserId() %>"/>
				<tr>
					<td>
						<textarea cols="90" rows="4" name="content" id="content"></textarea>
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
	<div id="replyArea">
		<ul id="replyList">
<!-- 			<li>아이디(이름) - 작성한 내용</li>			 -->
		</ul>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
<script>

	$(function(){
		//댓글 목록 조회 servlet 호출
		//화면에 반영
		var $replyList = $("#replyList");
	   var str = "<span>testtest</span>";
	   $replyList.text(str);
	});


	function writeComment(){
		var bno = $("#bno").val();
		var writer = $("#writer").val();
		var content = $("#content").val();
		
		$.ajax({
			url : "/mwp/writeCommentGallery.do",
			type : "get",
			data : {bno : bno, writer : writer, content : content},
			success : function(data){
				var $replyList = $("#replyList");
				$replyList.find("li").remove();
				
				for(var key in data){
					var comment = data[key];
					var $li = $("<li>");
					//아이디(이름) - 작성한 내용
					$li.text(comment.writer + 
							"(" + comment.writerNm + ") - " + comment.content);
					$replyList.append($li);
				}
			}, error : function(e){
				console.log(e);
			}
		});
	}

</script>
















</body>
</html>