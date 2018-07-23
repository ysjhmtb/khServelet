<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberList</title>
<script type="text/javascript" src="/mwp2/resource/js/jquery-3.3.1.min.js"></script>
<script>
function memberPage(no){
	location.href = "/mwp2/selectPhoto.do?no=" + no;	
}

</script>

</head>
<body>

<table border = "1">
	<tr>
		<th>NO</th>
		<th>TITLE</th>
		<th>조회수</th>
		<th>작성자</th>
		<th>선택</th>
	</tr>
	<c:forEach items = "${list }"	var = "photo" >
		<tr>
			<td><c:out value = "${photo.no }"/></td>
			<td><c:out value = "${photo.title }"/></td>
			<td><c:out value = "${photo.readCount }"/></td>
			<td><c:out value = "${photo.userId }"/></td>
			<td>
				<button onclick="memberPage('<c:out value = "${photo.no }"/>')">선택</button>
			</td>
		</tr>
	</c:forEach>
</table>















</body>
</html>