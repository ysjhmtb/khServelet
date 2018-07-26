<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/firstSpring/resources/js/jquery-3.3.1.min.js"></script>


<style>
	body{
		/* background:url("/resources/images/background.jpg") no-repeat; */
		background-size:cover;
	}
	.wrap{
		background:black;
		width:100%;
		height:50px;
	}
	.menu{
		background:black;
		color:white;
		width:150px;
		height:50px;
		vertical-align:middle;
		text-align:center;
		display:table-cell;
	}
	.nav{
		width:600px;
		margin-left:auto;
		margin-right:auto;
	}
	.menu:hover{
		background:lightgray;
		color:orangered;
		font-weight:bold;
		cursor:pointer;
	}
	
	.loginArea > #loginForm, .userInfo{
		float:right;
	}
	
	#memberLoginBtn, #memberJoinBtn, #memberInfoBtn, #memberLogoutBtn{
		display:inline-block;
		vertical-align:middle;
		text-align:center;
		cursor:pointer;
		width:150px;
		height:30px;
		border-radius:5px;
		background:orangered;
		color:white;
	}
	
	.tile{
		width:150px;
		height:150px;
		background:black;
		display:inline-block;
	}
	.first-line{
		margin-top:10%;
	}
	
	.tile-menu:hover{
		background:skyblue;
		cursor:pointer;
		color:white;
	}
	.notile{
		visibility:hidden;
	}
	.tile1{
		background:darkgray;
	}
	.footer{
		position:fixed;
		left:0;
		bottom:0;
		background:brown;
		color:white;
		text-align:center;
		width:100%;
	}
</style>

<script>
	$(function(){
		alert('연동 확인');
	});
	
	function join(){
		location.href = "memberJoinForm.do";
	}

</script>

</head>
<body>
	<h1 align="center">My Web Project</h1>
	<div class="loginArea">
	
	
	<c:if test="${empty sessionScope.user}">
		<form id="loginForm" action="/mwp/login.au" method="post">
			<table>
				<tr>
					<td>아이디 : </td>
					<td>
						<input type="text" name="userId"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td>
						<input type="password" name="userPwd" id="pwdText"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="memberLoginBtn" onclick="login();">로그인</div>
						<div id="memberJoinBtn" onclick="join();">회원가입</div>
					</td>
				</tr>
			</table>		
		</form>
	</c:if>
	
	<c:if test="${!empty sessionScope.user }">
		<div class="userInfo">
			<p>${user.userName}님 방문을 환영 합니다.</p>
			<div id="memberInfoBtn" onclick="myInfo();">정보 수정</div>
			<div id="memberLogoutBtn" onclick="logout();">로그 아웃</div>
		</div>
	</c:if>
		
		
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="mainPage();">HOME</div>
			<div class="menu" onclick="noticePage();">Notice</div>
			<div class="menu" onclick="boardPage();">Board</div>
			<div class="menu" onclick="galleryPage();">Gallery</div>
		</div>
	</div>
</body>
</html>









