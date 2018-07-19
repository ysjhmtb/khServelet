<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberList</title>

<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  
<script>
	function memberPage(userid){
		location.href="/mwp2/selectMember.do?userid=" + userid;
	}
</script>
  
  
</head>
<body>

<table border = "1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>AGE</th>
		<th>EMAIL</th>
		<th>PHONE</th>
		<th>선택</th>
	</tr>
	<c:forEach items = "${list }"	var = "member" >
		<tr>
			<td><c:out value = "${member.userid }"/></td>
			<td><c:out value = "${member.username }"/></td>
			<td><c:out value = "${member.age }"/></td>
			<td><c:out value = "${member.email }"/></td>
			<td><c:out value = "${member.phone }"/></td>
			<td>
				<button onclick="memberPage('<c:out value = "${member.userid }"/>')">선택</button>
			</td>
		</tr>
		
		
	</c:forEach>
</table>
<hr>

<a href="/mwp2/views/mybatis/memberJoin.jsp">멤버 추가</a>
<hr>


<form action="searchMember.do" method="get">
	<select name="condition">
		<option value="id">아이디</option>
		<option value="name">이름</option>
		<option value="age">나이</option>		
	</select>
	
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>


</body>
</html>