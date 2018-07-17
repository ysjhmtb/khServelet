<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl Index</title>
</head>
<body>
<h1>JSTL 목록</h1>
<p>JavaServer Page Standards tag lib</p>
<ul>
<li>
	<a href="jstlBasic1.jsp">1. basic jstl 1</a>
</li>
<li>
	<a href="/mwp2/jstlIf.do?condition=5">2. jstl - if</a>
</li>
<li>
	<a href="jstlChoose.jsp?con=3">3. jstl - choose</a>
</li>
<li>
	<form action="jstlToken.jsp" method="get">
		취미를 입력 하십시오(여러개일 경우 ','로 구분하여 주십시오)<br/>
		취미 : <input type="text" name="hobby" />
		<input type="submit" value="취미 확인"/>
	</form>
</li>
<li>
	<a href="/mwp2/jstlForEach.do">5. jstl - forEach</a>
</li>

<c:url var="urlPage" value="jstlUrl.jsp">
	<c:param name="mns" value="chicken"/>
	<c:param name="movie" value="antman"/>
</c:url>
<li>
	<a href="<c:out value="${urlPage }"/>">6. jstl - url</a>
</li>

<li>
	<a href="/mwp2/jstlFmt.do"/>7. jstl - formatter</a>
</li>

<li>
	8. jstl - function
		
	<form action="/mwp2/jstlFn.do" method="get">
		복날 음식 종류를 아는대로 입력해 주십시오.(여러개일 경우 ,로 구분하여 주십시오.)<br/>
		음식 : <input type="text" name="inputText" />
		<input type="submit" value="음식 전송"/>
	</form>
	
</li>

</ul>
저장 된 이름 : ${username}









</body>
</html>