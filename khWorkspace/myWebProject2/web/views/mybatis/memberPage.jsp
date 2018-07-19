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
<form action="/mwp2/updateMember.do" method="get" >

	아이디 : <input name="id" type="text" readonly value="<c:out value='${member.userid }'/>"/><br/>
	이름 : <input name="name" type="text" value="<c:out value='${member.username }'/>"/><br/>
	나이 : <input name="age" type="text" value="<c:out value='${member.age }'/>"/><br/>
	전화번호 : <input name="phone" type="text" value="<c:out value='${member.phone }'/>"/><br/>
	<input type="submit" value="수정"/>
	<a href="deleteMember.do?userid=<c:out value='${member.userid }'/>">멤버탈퇴</a>
	<input type="button" value="목록으로"/>
	
</form>

</body>
</html>










