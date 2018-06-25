<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Web Project</title>
</head>
<body>
	<%@ include file="views/common/header.jsp" %>
	<div class="background" align="center">
		<div class="first-line">
			<div class="tile tile-menu"></div>
			<div class="tile tile1"></div>
			<div class="tile tile-menu"></div>
			<div class="tile notile"></div>
			<div class="tile tile1"></div>
		</div>
		<div class="second-line">
			<div class="tile notile"></div>
			<div class="tile tile1"></div>
			<div class="tile notile"></div>
			<div class="tile tile1"></div>
			<div class="tile tile-menu"></div>
		</div>
	</div>
	<%@ include file="views/common/footer.jsp" %>
	<!-- include 시에 해당 파일의 내용이 소스 형태로 추가 -->
	<script>
		$(function(){
			//팝업창 띄우기
			var value = localStorage.getItem("dayCheck");
			var today = new Date().getDate();
			
			console.log(today, value, value.split(" ")[2]);
		
			if(null == value || today != value.split(" ")[2]){
				window.open("/mwp/noticePopup.do","_blank","width=300, height=400,left=200,top=200");
			}
		});
	</script>
</body>
</html>











