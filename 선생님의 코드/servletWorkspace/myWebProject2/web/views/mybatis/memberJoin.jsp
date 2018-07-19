<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mwp2/insertMember.do" method="post">
	아이디 : <input name="id" type="text" /><br/>
	비밀번호 : <input name="pwd" type="password"/><br/>
	이름 : <input name="name" type="text" /><br/>
	나이 : <input name="age" type="text" /><br/>
	전화번호 : <input name="phone" type="text" /><br/>
	성별 : <input name="gender" type="radio" value="M"/> 남
			<input name="gender" type="radio" value="F"/> 여<br/>
	<input type="submit" value="회원추가"/>
	<input type="button" value="목록으로"/>
</form>

</body>
</html>










