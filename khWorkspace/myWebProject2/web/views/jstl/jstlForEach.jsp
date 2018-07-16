<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - forEach</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>index</th>
			<th>이름 </th>
			<th>나이 </th>
			<th>전화번호 </th>
			<th>first</th>
			<th>last</th>
		</tr>
		
		<c:forEach items="${requestScope.team }" var="member" varStatus="st">
			
			<tr>
				<td><c:out value="${st.index }"/>,
					<c:out value="${st.count }"/> 
					
				</td>
				
				<td>
					<c:if test="${st.count eq 2 }">
						조장 - 
					</c:if>
					
					<c:if test="${st.count ne 2 }">
						조원 - 
					</c:if>
					
					<c:out value="${member.name }"/>
				</td>
				
				<td><c:out value="${member.age }"/></td>
				
				<td><c:out value="${member.phone }"/></td>
				
				<td>
					<c:out value="${st.first }"/>
				</td>
				
				<td>
					<c:out value="${st.last }"/>
				</td>
				
			</tr>	
			
		
		</c:forEach>
		
	</table>

</body>
</html>