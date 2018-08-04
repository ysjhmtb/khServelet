<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>     
<!DOCTYPE html>
<html>
<head>



<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>

<!-- include summernote-ko-KR -->
<script src="resources/js/summernote-ko-KR.js"></script>





<meta charset="UTF-8">
<title>공지사항 작성</title>
<style>
.outer{
	width:800px;
	height:900px;
	background:black;
	color:gray;
	margin-left:auto;
	margin-right:auto;
	padding:20px;
	border:1px solid white;
}
</style>




<script>

	/*
		ronlobo commented on 3 Sep 2013
		The images are stored as base64. You could convert them 
		when storing to a real image and replace the src 
		with location of the new image.
		https://github.com/summernote/summernote/issues/46#issuecomment-23706833
		
		에디터에 입력된 사진들이 어느 경로에 저장되는지 궁금했는데 아마도 사진이 인코딩되어 
		html 속에 존재하는 것 같다.
		
		
	*/
	
	/*
	If we use Summernote editor by normal process 
	then it is not possible to upload images on the server 
	because Summernote converts images to Base 64 format 
	so when we save an image in the database then it takes 
	too much space in the database. 
	But with the help of some code we can upload images 
	on the server through summernote editor. 
	We have to use a default “onImageUpload” summernote function 
	for image uploading.
	
	https://webkul.com/blog/image-upload-summernote/


	*/



	$(document).ready(function() {
	  $('#summernote').summernote({
		  height:600,
		  lang: 'ko-KR' // default: 'en-US'
		  
		  /* 
		  	https://stackoverflow.com/questions/21628222/summernote-image-upload
		  	
		  	onImageUpload: function(files, editor, welEditable) {
                sendFile(files[0], editor, welEditable);
            } */
	  });
	  
	  /*
	  function sendFile(file, editor, welEditable) {
          data = new FormData();
          data.append("file", file);
          $.ajax({
              data: data,
              type: "POST",
              url: "http://localhost/firstSpring/resources/upload",
              cache: false,
              contentType: false,
              processData: false,
              success: function(url) {
                  editor.insertImage(welEditable, url);
              }
          });
      }
	  */
	  
	});
	
	
</script>

</head>
<body>
<div class="outer">
	<h2 align="center">공지사항 작성</h2>
	<div class="tableArea" align="center">
		<form method="post" action="writeNotice.do" 
								enctype="multipart/form-data">
			<input type="hidden" name="writer" value="${user.userid }"/>
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="title" size="33"/>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<input type="file" name="file"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea id="summernote"  name="content"></textarea>
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
<c:import url="../footer.jsp"/> 
</body>
</html>













