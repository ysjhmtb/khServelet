<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입.</title>


<style>
	.outer{
		width: 600px;
		height: 500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border: 1px solid white;
	}
	
	#idCheckBtn, #searchAddressBtn, #joinMainBtn, #joinBtn{
		background:orangered;
		order-radius:5px;
		width:100px;
		height:25px;
		text-align:center;
		cursor:pointer;
	}
	
	
	#joinMainBtn, #joinBtn{
		display:inline-block;
		
		
	}
	
	
	#searchAddressBtn, #joinBtn{
		background:yellowgreen;
		
	}
	
	
	
	
</style>

<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  
<script>
	function memberJoin(){
		$("#joinForm").submit();
		
		
	}
	
	function validate(){
		
		if($("#userPwd").val() == $("#userPwd2").val()){
			$("#passChkSpan").text("입력하신 비밀번호가 일치하지 않습니다.");
			$("#userPwd2").focus();
			return false;
		}
		
		//다른 값들을 체크하는 로직 추가.(유효성 검사 로직 추가 영역.)
		
		return true;
	}
	
	

</script>

</head>
<body>
	<div class="outer">
		<h2 align="center">회원가입.</h2>
		<form id="joinForm" method="post" action="/mwp/join.do" onsubmit="return vallidate();">
			<table>
				<tr>
					<td width="200px"> <span class="import">*</span>아이디.</td>
					<td> <input type="text" name="userId" id="userId" required> </td>
					<td width="200px"> <div id="idCheckBtn">중복 확인.</div> </td>
				</tr>
					
				<tr>
					<td><span class="import">*</span>비밀번호.</td>
					<td><input type="password" name="userPwd" id="userPwd" required></td>
					<td></td>
				</tr>
				
				<tr>
					<td><span class="import">*</span>비밀번호 확인.</td>
					<td><input type="password" name="userPwd2" id="userPwd2" required></td>
					<td><span id="passChkSpan"></span></td>
				</tr>
				
				<tr>
					<td><span class="import">*</span>이름.</td>
					<td><input type="text" name="userName" id="userName" required></td>
					<td></td>
				</tr>
				
				
				<tr>
					<td>성별.</td>
					<td>
						<input type="radio" name="gender" value="M" checked>남성.
						<input type="radio" name="gender" vlaue="F">여성.
					</td>
					<td></td>
				
				</tr>
				
				<tr>
					<td>나이.</td>
					<td><input type="number" name="age" min="10" max="100" 
							value="20"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>이메일.</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>전화번호.</td>
					<td>
						<input type="text" name="phone1" id="phone1"  size="2"> - 
						<input type="text" name="phone2" id="phone2" size="2"> -
						<input type="text" name="phone3" id="phone3" size="2"> 
					
					</td>
					<td></td>
				</tr>
				
				<tr>
					<td>우편번호.</td>
					<td><input type="text" name="zipcode" id="zipcode" readonly></td>
					<td></td>
				</tr>
				
				<tr>
					<td>주소.</td>
					
					<td><input type="text" name="address1" id="address1" readonly></td>
					
					<td><div id="searchAddrBtn">주소 검색.</div></td>
				
				</tr>
				
				<tr>
					<td>상세주소.</td>
					
					<td><input type="text" name="address2" id="address2"></td>
					
					<td></td>
				
				</tr>
				
				<tr>
					<td>취미.</td>
					<td>
						<input type="checkBox" id="game" name="hobby" value="게임">
						<lable for="game">게임.</lable>
					
						<input type="checkBox" id="climbing" name="hobby" value="등산">
						<lable for="climbing">등산.</lable>
						
						<input type="checkBox" id="sing" name="hobby" value="노래">
						<lable for="sing">노래.</lable>
						
						<input type="checkBox" id="board" name="hobby" value="보드">
						<lable for="board">보드.</lable>
						
						<input type="checkBox" id="read" name="hobby" value="독서">
						<lable for="read">독서.</lable>
						
						<input type="checkBox" id="etc" name="hobby" value="기타">
						<lable for="etc">기타.</lable>
					
					</td>
					
					<td></td>
				</tr>
				
			
			</table>
			
			<br>
			
			<div class="btns" align="center">
			
				<div id="joinMainBtn" > 메인으로 이동.</div>
				<div id="joinMainBtn"  onclick="memberJoin()"> 회원가입.</div>
			</div>
		
		</form>
	</div>

	<%@ include file = "../common/footer.jsp" %>
</body>
</html>