<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session Storage</title>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		if(null != sessionStorage){
			console.log("세션 스토리지 지원 브라우저 입니다.");
		}else{
			console.log("세션 스토리지를 사용하실수 없습니다.");
		}
		
		$("#setItemBtn").on("click",function(){
			var key = $("#itemKey").val();
			var value = $("#itemValue").val();
			sessionStorage.setItem(key, value);
			console.log(sessionStorage);
		});
		
		$("#outputBtn").on("click", function(){
			var key = $("#outputKey").val();
			var value = sessionStorage.getItem(key);
			console.log(value);
		});
		
		$("#removeBtn").on("click", function(){
			var key = $("#removeKey").val();
			sessionStorage.removeItem(key);
			console.log(sessionStorage);
		});
		
		
		$("#clearBtn").on("click",function(){
			sessionStorage.clear();
		});
	});
</script>
</head>
<body>
<h1>세션 스토리지</h1>
<p>웹 브라우저에 값을 저장 하는 기술 중 하나</p>
<p>접속 종료 시(브라우저 종료) 데이터가 삭제 됨, 메모리에 제한이 없다</p>

<h3>세션 스토리지 항목 추가</h3>
설정 키 : <input type="text" id="itemKey"/><br>
설정 값 : <input type="text" id="itemValue"/><br>
<button id="setItemBtn">값 설정</button>
<hr>
<h3>세션 스토리지 항목 확인</h3>
항목 키 : <input type="text" id="outputKey"/><br>
<button id="outputBtn">값 확인</button>
<hr>
<h3>세션 스토리지 항목 삭제</h3>
삭제 키 : <input type="text" id="removeKey"/><br>
<button id="removeBtn">항목 삭제</button> <button id="clearBtn">모든 항목 삭제</button>















</body>
</html>