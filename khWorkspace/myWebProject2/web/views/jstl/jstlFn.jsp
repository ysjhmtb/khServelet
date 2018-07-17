<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> jstl - function </title>
</head>
<body>
	전송 값 출력 : <c:out value="${requestScope.text }" /> <br>
	길이 확인: <c:out value="${fn:length(text) }"/> <br>
	배열 데이터로 출력 : 
	
	<!-- 글자수가 두개를 초과할 때, 이름 대신에 글자 수 초과 출력   -->
	<!-- 홀수 행 - 배경색 회색, 짝수 행 - 배경색 노란색   -->
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>음식이름</th>
			<th>글자 수</th>
		
		</tr>
		
		<c:forEach items="${fn:split(text,',')}" var="Hfood" varStatus="status">
		
			<c:if test="${ ( (status.count + 1) % 2 ) == 0 }">
				<tr bgcolor = "gray">
					<td><c:out value="${status.count }"/></td>
					
					<c:if test="${fn:length(Hfood) > 2 }">
						<td> <c:out value="글자 수를 초과하였습니다."/> </td>
					</c:if>
					
					<c:if test="${fn:length(Hfood) <= 2 }">
						
						<td><c:out value="${Hfood }" /></td>
					</c:if>
					
					<td><c:out value="${fn:length(Hfood) }"/></td>
				</tr>
			
			</c:if>
			
			<c:if test="${ ( (status.count + 1) % 2 ) != 0 }">
				<tr bgcolor = "yellow">
					<td><c:out value="${status.count }"/></td>
					
					<c:if test="${fn:length(Hfood) > 2 }">
						<td> <c:out value="글자 수를 초과하였습니다."/> </td>
					</c:if>
					
					<c:if test="${fn:length(Hfood) <= 2 }">
						
						<td><c:out value="${Hfood }" /></td>
					</c:if>
					
					<td><c:out value="${fn:length(Hfood) }"/></td>
				</tr>
			
			</c:if>
					
		</c:forEach>
				
	</table>
	
	<hr>
	
	join 확인 : <c:out value="${fn:join( fn:split(text,','), '===' ) }"/> <br>
	<!-- join 확인 : 감자===피자   -->
	
	<c:set var="foods" value="${ fn:split(text,',') }"/>
	<c:set var="outputStr" value="${ fn:join(foods,'//') }" />
	
	join 세분화 확인 : <c:out value="${outputStr }"/> 
	
	
	
	
	
</body>
</html>