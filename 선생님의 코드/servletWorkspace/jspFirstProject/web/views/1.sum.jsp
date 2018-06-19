<%--jsp 주석 태그--%>
<%-- <%@ : (페이지)지시자 태그 - 현재 페이지에 대한 정보 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈 결과 출력</title>
</head>
<body>
<%-- <% %> : 자바 소스를 기술하는 영역 --%>
<%
	//1~10 까지의 합을 구하는 로직
	int total = 0;
	for(int i = 1 ; i <= 10 ; i++){
		total += i;
	}
	
	//String str = null;
	//System.out.println(str.charAt(0));	
%>

<%-- <%= %> : 익스프레션 태그, 자바영역의 값을 출력 할때 사용 --%>
<h4>1부터 10까지의 합은 <%=total%> 입니다.</h4>
<h4>1부터 10까지의 합은 <% out.println(total); %> 입니다.</h4>

</body>
</html>