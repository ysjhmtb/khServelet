<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax study</title>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#submit1").click(function(){
			var name = $("#username").val();
			$.ajax({
				url : "/mwp/test1.do", 
				type : "post",
				data : {username : name},
				success : function(data){
					console.log("성공!!");
				},error : function(e){
					console.log("요청 실패!!");
				},complete : function(data){
					console.log("무조건 실행 되는 함수!!");
				}
			});
		});
		
		$("#submit2").click(function(){
			$.ajax({
				url : "/mwp/test2.do",
				type : "post",
				success : function(data){
					console.log(data);
					$("#message").val(data);
				},error : function(data){
					console.log(data);
				}
			});
		});
		
		$("#submit3").click(function(){
			$.ajax({
				url : "/mwp/test3.do",
				type : "post",
				data : {num1 : $("#firstNum").val(), num2 : $("#secondNum").val()},
				success : function(data){
					console.log(data);
					$("#outputDiv1").text(data);
				},error : function(e){
					console.log(e);
				}
			});
		});
		
		$("#checkIdBtn").click(function(){
			var inputId = $("#userId").val();
			$.ajax({
				url : "/mwp/idCheck.do",
				type : "post",
				data : {userId : inputId},
				success : function(data){
					$("#outputDiv2").text(data);
					if(data == "사용가능한 아이디 입니다."){
						$("#outputDiv2").css("color", "green");
					}else{
						$("#outputDiv2").css("color", "red");
					}
				},error : function(e){
					console.log(e);
				}
			});
		});
		
		$("#submit4").click(function(){
			var jsonData = new Object();
			jsonData.food1 = $("#food1").val();
			jsonData.food2 = $("#food2").val();
			jsonData.food3 = $("#food3").val();
			
			$.ajax({
				url : "/mwp/test4.do",
				type : "get",
				data : jsonData,
				success : function(data){
					console.log("전송 성공");
				},error : function(e){
					console.log(e);
				}
			});
		});
		
		//서버에서 전송값 문자열 타입의 경우만 json으로 파싱 되는 이유
		$("#submit5").click(function(){
			$.ajax({
				url : "/mwp/test5.do",
				type : "get",
				success : function(data){
					console.log(data);
					var result = data.id + "/" + data.age + "/" 
											+ data.addr + "/" + data.email + "/" + data.gender;
					$("#outputDiv3").text(result);
				},error : function(e){
					console.log(e);
				}
			});
		});
		
		$("#submit6").click(function(){
			$.ajax({
				url : "/mwp/test6.do",
				type : "get",
				data : {index:$("#userIndex").val()},
				success : function(data){
					console.log(data);
					var user;
					var resultStr = "";
					for(var key in data){
						user = data[key];
						resultStr += user.userId + "/" + user.age + "/" 
											+decodeURIComponent(user.username) + "<br>"; 
					}
					$("#outputDiv4").html(resultStr);
				},error : function(e){
					console.log("error", e);
				}
			});
		});
		
		
		
	});

</script>
</head>
<body>
	<h1>Ajax Study!!!</h1>
	
	<h3>1. 화면에 값 입력 후 서버 전송</h3>
	이름 : <input type="text" id="username" /><br>
	<button id="submit1">서버 전송</button>
	<hr>
	<h3>2. 서버에서 전송 값 화면 출력</h3>
	<button id="submit2">서버 전송</button><br>
	메세지 : <input type="text" id="message"/>
	<hr>
	
	<h3>3. 화면에서 값 전송 후 해당 값 처리 결과 화면 출력</h3>
	<p>숫자 2개를 전송 -> 두수의 합</p>
	첫번째 숫자 : <input type="text" id="firstNum"/><br>
	두번째 숫자 : <input type="text" id="secondNum"/><br>
	<button id="submit3">서버 전송</button>
	<div id="outputDiv1" style="border:1px solid red; height:auto;"></div>
	<hr>
	
	<h3>실습1. 아이디 중복 체크</h3>
	아이디 : <input type="text" id="userId"/> <button id="checkIdBtn">중복체크</button>
	<div id="outputDiv2" style="border:1px solid red; height:auto;"></div>
	
	<h3>4. 화면에서 객체로 데이터 전달</h3>
	메뉴1 : <input type="text" id="food1"/><br>
	메뉴2 : <input type="text" id="food2"/><br>
	메뉴3 : <input type="text" id="food3"/><br>
	<button id="submit4">서버 전송</button>
	<hr>
	
	<h3>5. 서버에서 객체로 데이터 전달</h3>
	<button id="submit5">서버 전송</button>
	<div id="outputDiv3" style="border:1px solid red; height:auto;"></div>
	<hr>
	
	<h3>6. 서버에서 리스트 형태의 데이터 전달</h3>
	인덱스 : <input type="text" id="userIndex"/><br>
	<button id="submit6">서버 전송</button>
	<div id="outputDiv4" style="border:1px solid red; height:auto;"></div>
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>