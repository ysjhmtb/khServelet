<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 1</title>
</head>
<body>
<c:set var="num1" value="500"/>
그냥 출력 : ${num1 } <br>
코어 out 출력 : <c:out value="${num1 }"/>
<hr>

<c:set var="username" value="최범석" scope="request"/>
<c:out value="${requestScope.username }"/><br/>
<c:set var="username" value="홍길동" scope="session"/>
<c:out value="${sessionScope.username }"/><br/>

확인 : <c:out value="${username }"/><br/>

<c:remove var="num1"/>
num1 재출력 : <c:out value="${num1 }"/><br/>

<c:remove var="username"/>
request 값 : <c:out value="${requestScope.username }"/><br/>
session 값 : <c:out value="${sessionScope.username }"/><br/>
<hr>

<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>"/><br/>
<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>" escapeXml="true"/><br/>
<c:out value="해당 숫자를 진하게 하려면 b 태그를 사용하셔야 합니다. <b>500</b>" escapeXml="false"/><br/>
해당 숫자를 강조 하겠습니다. <b><c:out value="500"/></b>

</body>
</html>