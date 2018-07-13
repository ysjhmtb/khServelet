<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연산자</title>
</head>
<body>
연산자를 이용해서 값을 출력
<ul>
	<li>\${2 + 5} -> ${2 + 5}</li>
	<li>\${3 / 4 } -> ${3 / 4 }</li>
	<li>\${7 div 3 } -> ${7 div 3 }</li>
	<li>\${3 % 4 } -> ${3 % 4 }</li>
	<li>\${3 mod 4 } -> ${3 mod 4 }</li>
	<li>\${3 < 4 } -> ${3 < 4 }</li>
	<li>\${3 lt 4 } -> ${3 lt 4 }</li>
	<li>\${3 > 4 } -> ${3 > 4 }</li>
	<li>\${3 gt 4 } -> ${3 gt 4 }</li>
	<li>\${3 == 4 } -> ${3 == 4 }</li>
	<li>\${3 eq 4 } -> ${3 eq 4 }</li>
	<li>\${(3 mod 2) == 1 ? "홀" : "짝"} -> ${(3 mod 2) == 1 ? "홀" : "짝"}</li> 
</ul>









</body>
</html>