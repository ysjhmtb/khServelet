<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입.</title>

<!-- https://spi.maps.daum.net/postcode/guidessl  -->  
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>


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


  
<script>
	function memberJoin(){
		$("#joinForm").submit();
		
		
	}
	
	function validate(){
		
		if($("#userPwd").val() != $("#userPwd2").val()){
			$("#passChkSpan").text("입력하신 비밀번호가 일치하지 않습니다.");
			$("#userPwd2").focus();
			return false;
		}
		
		//다른 값들을 체크하는 로직 추가.(유효성 검사 로직 추가 영역.)
		
		return true;
	}
	
	function openAddressPopup(){
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                
                /* 
                
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr; 
                
                */
                
				$("#zipcode").val(data.zonecode);
                $("#address1").val(fullAddr);
                
                
                // 커서를 상세주소 필드로 이동한다.
                /* 
                
                document.getElementById('sample6_address2').focus(); 
                
                */
                
                $("#address2").focus();
            }
        }).open();
	}
	
	
	
	//???????????
	$(function(){
		$("#idCheckBtn").click(function(){
			console.log("test");
			
			var inputId = $("#userId").val();
			console.log(inputId);
			
			$.ajax({
				url : "/mwp/idCheck.do",
				type : "post",
				data : {userId : inputId},
				success : function(data){
					console.log(data);
					
				}, error : function(e){
					console.log(e);
				}
				
			});
		});		
	});
	
	

</script>

</head>
<body>
	<div class="outer">
		<h2 align="center">회원가입.</h2>
		<form id="joinForm" method="post" action="/mwp/join.do" onsubmit="return validate();">
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
						<input type="radio" name="gender" value="F">여성.
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
					<td><input type="text" name="zipcode" id="zipcode" ></td>
					<td></td>
				</tr>
				
				<tr>
					<td>주소.</td>
					
					<td><input type="text" name="address1" id="address1" ></td>
					
					<td><div id="searchAddrBtn" onclick="openAddressPopup()">주소 검색.</div></td>
				
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
			
				<!-- 헤더에 선언된 mainPage() -->
			
				<div id="joinMainBtn" onclick="mainPage()" > 메인으로 이동.</div>
				<div id="joinBtn"  onclick="memberJoin()"> 회원가입.</div>
			</div>
		
		</form>
	</div>

	<%@ include file = "../common/footer.jsp" %>
</body>
</html>