<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.java.member.model.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>
<%
	MemberVo member = (MemberVo)session.getAttribute("user");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  
  
<style>
	body{
		background:url("/mwp/images/background.jpg") no-repeat;
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
	function login(){
		$("#loginForm").submit();
	}
	
	function logout(){
		location.href = "/mwp/logout.do";		
	}
	
	function join(){
		location.href = "/mwp/views/member/memberJoin.jsp";
	}
	
	function mainPage(){
		//request.getContextPath() - /mwp
		//location.href = "/mwp/index.jsp";
		location.href = "<%=request.getContextPath()%>/index.jsp";
	}
	
	function myInfo(){
// 		console.log(localStorage);
// 		localStorage.removeItem("kakao_2e2524e541bae9363d7d85d3d3fbde83");
		Kakao.Auth.getStatus(function(status){
			console.log(status.user.kaccount_email);
		});
//		location.href = "../member/memberUpdate.jsp";
		//location.href = "/mwp/views/member/memberUpdate.jsp";
	}
	
	function noticePage(){
		location.href = "/mwp/noticeList.do";
	}
	
	function boardPage(){
		location.href = "<%=request.getContextPath()%>/boardList.do";
	}
	
	$(function(){
		Kakao.init('2176ef7240bdb4d15b1109660b0f4365');
	    // 카카오 로그인 버튼을 생성합니다.
	    Kakao.Auth.createLoginButton({
	      container: '#kakao-login-btn',
	      success: function(authObj) {
	        alert(JSON.stringify(authObj));
	      },
	      fail: function(err) {
	         alert(JSON.stringify(err));
	      }
	    });
	});
	
	function kakao_logout(){
		Kakao.Auth.logout();
		//페이지 이동
		//다른 로직
	}
	
	$(function(){
		
		//enter key up method를 추천.
		$("#pwdText").change(function(){
			$("#loginForm").submit();
		});
	});
	
</script>
</head>
<body>
	<h1 align="center">My Web Project</h1>
	<div class="loginArea">
	<%if(member == null){ %>
		<form id="loginForm" action="/mwp/login.do" method="post">
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
		<%}else{%>
			<div class="userInfo">
				<p><%=member.getUserName()%>님 방문을 환영 합니다.</p>
				<div id="memberInfoBtn" onclick="myInfo();">정보 수정</div>
				<div id="memberLogoutBtn" onclick="logout();">로그 아웃</div>
			</div>
		<%} %>
	</div>
	<a id="kakao-login-btn"></a>
<!-- 	<a href="http://developers.kakao.com/logout">로그아웃</a> -->
	<button onclick="kakao_logout();">카카오 로그아웃</button>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="mainPage();">HOME</div>
			<div class="menu" onclick="noticePage();">공지사항</div>
			<div class="menu" onclick="boardPage();">게시판</div>
			<div class="menu">사진 게시판</div>
		</div>
	</div>
</body>
</html>
