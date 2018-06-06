<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.kh.java.member.model.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>

<%
	MemberVo member = (MemberVo)session.getAttribute("user");
%>

<meta charset="UTF-8">
<title>Insert title here</title>

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
		magin-left:auto;
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
	
	#memberLoginBtn, #memberJoinBtn, #memberInfoBtn, #memberLogoutBtn {
	
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
		margin-up:10%;
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

	<script
	  src="https://code.jquery.com/jquery-3.3.1.js"
	  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	  crossorigin="anonymous"></script>
	  
	<script>
		function login(){
			$("#loginForm").submit();
			
		}
		
		
		function logout(){
			location.href = "/mwp/logout.do";
			
		}
		
		function join(){
			location.href = "/mwp/views/member/memberJoin.jsp"
		}
		
		function mainPage(){
			//request.getContextPath() : /mwp
			//location.href = "/mwp/index.jsp";
			
			/*
			request.getContextPath() : 프로젝트의 context path 반환.
			/example
			
			
			
			request.getRequestURI() : 웹 전체 경로 반환.
			
			/example/index.jsp
			
			
			
			request.getHeader("REFERER") : 요청을 한 부모요청의 URL 반환.
			
			현재 페이지 : localhost:8080/example/test1.do
			
			요청 페이지 : localhost:8080/example/test.do
			
			localhost:8080/example/test.do 반환.
			
			
			
			request.getRealPath("/") : 서버 또는 로컬의 웹앱 서버의 docBase 설정값 반환.
			
			요청  : localhost:8080/example/test.jsp
			
			반환 : D:/Project/webapps/example
			
			*/
			location.href = "<%=request.getContextPath()%>/index.jsp";
			
			
		}
		
		function myInfo(){
			location.href = "/mwp/views/member/memberUpdate.jsp"
			
		}
	</script>
  
  
  

</head>
<body>
	<h1 align = "center">My Web Project</h1>
	<div class = "loginArea">
	
	<%if(member == null) {%>
	
		<form id = "loginForm" action = "/mwp/login.do" method = "post">
			<table>
				<tr>
					<td>id :</td>
					<td>
						<input type = "text" name = "userId">
					</td>
				
				</tr>
				
				<tr>
					<td>password :</td>
					<td>
						<input type = "password" name = "userPwd">
					</td>
				
				</tr>
				
				<tr>
					<td colspan = "2">
						<div id = "memberLoginBtn" onclick = "login()">sign in</div>
						<div id = "memberJoinBtn" onclick = "join()">sign up</div>
					</td>
				</tr>
			
			</table>
		
		</form>
		
		<%} else{%>
			<div class="userInfo">
			
				<p><%= member.getUserName() %>님 방문을 환영합니다.</p>
				<div id="memberInfoBtn" onclick="myInfo();">정보 수정.</div>
				<div id="memberLogoutBtn" onclick="logout();">로그 아웃.</div>
			
			</div>
			
		
		<%} %>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>