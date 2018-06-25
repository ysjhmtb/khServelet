<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>localStorage</title>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#setItemBtn").click(function(){
			if(null != localStorage){
				console.log("로컬 스토리지 지원 브라우저 입니다.");
			}else{
				console.log("로컬 스토리지를 지원하지 않습니다.");
			}
			
			var key = $("#itemKey").val();
			var value = $("#itemValue").val();
			localStorage.setItem(key, value);
		});
		
		$("#outputBtn").click(function(){
			var key = $("#outputKey").val();
			var text = localStorage.getItem(key);
			alert(text);
			console.log(key, text);
		});
		
		
		$("#removeBtn").click(function(){
			var key = $("#removeKey").val();
			localStorage.removeItem(key);
		});
		
		
		$("#clearBtn").click(function(){
			localStorage.clear();
			console.log(localStorage);
		});
		
	})
</script>
</head>
<body>
	<h1>로컬 스토리지</h1>
	<p>기존의 쿠기와 같은 방식으로 사용자 PC에 데이터 저장</p>
	<p>저장 가능 공간 : 2.5MB~10MB, 갯수 제한이 없다, 값 계속 유지 된다.</p>
	
	<h3>로컬스토리지 항목 추가</h3>
	설정 키 : <input type="text" id="itemKey"/><br>
	설정 값 : <input type="text" id="itemValue"/><br>
	<button id="setItemBtn">값 설정</button>
	<br>
	
	<h3>로컬스토리지 항목 확인</h3>
	키 : <input type="text" id="outputKey"/> 
	<button id="outputBtn">값 확인</button>
	<br>
	
	<h3>로컬 스토리지 항목 삭제 </h3>
	키 : <input type="text" id="removeKey">
	<button id="removeBtn">값 삭제</button>
	<button id="clearBtn">로컬스토리지 전체 삭제</button>
	
	
	<a href="sessionStorage.jsp">세션 스토리지 페이지 이동</a>


	


</body>
</html>