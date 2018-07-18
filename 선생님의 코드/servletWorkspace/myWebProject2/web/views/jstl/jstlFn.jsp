<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - function</title>
<style>
tr.even{
	background:yellow;
}
tr.odd{
	background:grey;
}
</style>
</head>
<body>
	전송 값 출력 : <c:out value="${requestScope.text }"/><br/>
	길이 확인 : <c:out value="${fn:length(text) }"/><br/>
	배열 데이터로 출력 : 
	<!-- 글자 수가 2개 초과할때 '이름' -> 이름 대신에 '글자 수 초과' -->
	<!-- 홀수 행 - 배경색 회색, 짝수 행 - 배경색 노란색 -->
	<table border="1">
		<tr>
			<th>번호</th>
			<th>음식 이름</th>
			<th>글자수</th>
			<th>이름2</th>
		</tr>
		<c:forEach items="${fn:split(text,',') }" var="Hfood" varStatus="status">
			<c:if test="${status.count % 2 eq 0 }">
				<tr class="even">
			</c:if>
			<c:if test="${status.count % 2 ne 0 }">
				<tr class="odd">
			</c:if>
				<td><c:out value="${status.count }"/></td>
				<td><c:out value="${Hfood }"/></td>
				<td><c:out value="${fn:length(Hfood) }"/></td>
				<td>
					<c:if test="${fn:length(Hfood) gt 2 }">
						<c:out value="글자수 초과"/>
					</c:if>
					<c:if test="${fn:length(Hfood) le 2 }">
						<c:out value="${Hfood }"/>
					</c:if>
				</td>
			</tr>
		</c:forEach> 
	</table>
	<hr>
	join 확인 : <c:out value="${fn:join(fn:split(text,','),'===') }"/><br/>
	
	<c:set var="foods" value="${fn:split(text,',')}"/>
	<c:set var="outputStr" value="${fn:join(foods,'//') }"/>
	join 세분화 확인 :  <c:out value="${outputStr }"/>
	
	
	
	
	
	
</body>
</html>












