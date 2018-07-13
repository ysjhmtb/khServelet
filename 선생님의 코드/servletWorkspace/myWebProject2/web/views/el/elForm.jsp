<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>값 전송 확인</title>
</head>
<body>
<form action="el7.jsp" method="post">
	<label for="name">이름 : </label><input type="text" name="name" id="name"/><br>
	<label for="age">나이 : </label><input type="text" name="age" id="age"/><br>
	<input type="checkbox" name="hobby" value="sing">노래<br>
	<input type="checkbox" name="hobby" value="game">게임<br>
	<input type="checkbox" name="hobby" value="billiards">당구<br>
	<input type="checkbox" name="hobby" value="book">독서<br>
	<input type="submit" value="전송"/>
</form>
</body>
</html>