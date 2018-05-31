<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
	
	.loginArea > #loginForm{
		float:right;
		
	
	}
	
	#memberLoginBtn, #memberJoinBtn {
	
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
  
  
  

</head>
<body>
	<h1 align = "center">My Web Project</h1>
	<div class = "loginArea">
		<form id = "loginForm" action = "login.do" method = "post">
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
						<input type = "text" name = "userPwd">
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
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>