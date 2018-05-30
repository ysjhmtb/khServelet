<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>today's menu</title>
</head>
<body>
	<h1>today's menu</h1>
	
	<form method="get" action="/jfp/selectMenu.do">
		<select name="menu">
			<option value="food1">라.돈.밥.</option>
			<option value="food2">누네띠네.</option>
			<option value="food3">콩나물국밥.</option>
			<option value="food4">라볶이.</option>
			<option value="food5">null</option>
		</select><br>
		<input type="submit" value="menu sel">
	</form>
	
	
	

</body>
</html>