<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</style>

</head>
<body>
	<div class="outer">
		<h2 align="center">회원가입.</h2>
		<form >
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
						<input type="text" name="phone1" id="phone1" > - 
						<input type="text" name="phone2" id="phone2" > -
						<input type="text" name="phone3" id="phone3" > 
					
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
			
			<div class="btns">
			
				<div id="joinMainBtn" > 메인으로 이동.</div>
				<div id="joinMainBtn" > 회원가입.</div>
			</div>
		
		</form>
	</div>

</body>
</html>