<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시글 등록</title>
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
	
	.insertArea{
		width:600px;
		height:450px;
		margin-left:auto;
		margin-right:auto;
	}
	#titleImage{
		width:350px;
		height:200px;
		border:2px dashed white;
		display:table-cell;
	}
	
	#detailImage1, #detailImage2, #detailImage3{
		width:110px;
		height:100px;
		border:2px dashed white;
		display:table-cell;
	}
	
	#titleImage:hover, #detailImage1:hover, #detailImage2:hover, #detailImage3:hover{
		cursor:pointer;
	} 
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<h1 align="center">이미지 등록</h1>
		<form action="/mwp/writeGallery.do" method="post" enctype="multipart/form-data">
		<div class="insertArea">
			<table align="center">
				<tr>
					<td width="100">제목</td>
					<td colspan="3"><input type="text" size="45" name="title"></td>
				</tr>	
				<tr>
					<td>
						대표 이미지
					</td>
					<td colspan="3">
						<div id="titleImage">
							<img id="titleImg" width="350" height="200"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>세부 사진</td>
					<td>
						<div id="detailImage1">
							<img id="detailImg1" width="120" height="100"/>
						</div>
					</td>
					<td>
						<div id="detailImage2">
							<img id="detailImg2" width="120" height="100"/>
						</div>
					</td>
					<td>
						<div id="detailImage3">
							<img id="detailImg3" width="120" height="100"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">
						<textarea name="content" rows="5" cols="45"></textarea>
					</td>
				</tr>
			</table>
			<div id="fileArea">
				<input type="file" id="galleryImage1" name="galleryImage1" 
							multiple="multiple" onchange="printImage(this, 1);"/> 
				<input type="file" id="galleryImage2" name="galleryImage2" 
							multiple="multiple" onchange="printImage(this, 2);"/> 
				<input type="file" id="galleryImage3" name="galleryImage3" 
							multiple="multiple" onchange="printImage(this, 3);"/> 
				<input type="file" id="galleryImage4" name="galleryImage4" 
							multiple="multiple" onchange="printImage(this, 4);"/> 
			</div>	
		</div>
		<div class="btnArea" align="center">
			<input type="button" value="취소"/>
			<input type="submit" value="작성"/>
		</div>
		</form>
	</div>
	<%@ include file="../common/footer.jsp" %>
	<script>
	$(function(){
		$("#fileArea").hide();
		$("#titleImage").click(function(){
			$("#galleryImage1").click();
		});
		$("#detailImage1").click(function(){
			$("#galleryImage2").click();
		});
		$("#detailImage2").click(function(){
			$("#galleryImage3").click();
		});
		$("#detailImage3").click(function(){
			$("#galleryImage4").click();
		});
	});

	function printImage(obj, index){
		if(obj.files && obj.files[0]){
			var reader = new FileReader();
			console.log(reader);
			reader.onload=function(e){
				$("#titleImg").attr("src",e.target.result);
			}
		}
	}
	</script>
</body>
</html>







