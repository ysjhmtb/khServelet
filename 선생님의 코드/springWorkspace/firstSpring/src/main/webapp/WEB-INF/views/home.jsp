<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>스프링 첫 페이지 입니다!!</h1>
<ul>
	<li><a href="paramTest.do?no=3&title=제목test">전달 값 체크(변수명 매칭)</a></li>
	<li><a href="paramTest1.do?no=1&title=제목">전달 값 체크(쿼리스트링)</a></li>
	<li><a href="paramTest2.do?no=1&title=제목">전달 값 체크(객체)</a></li>
	<li><a href="returnParam.do?no=50&title=제목500">리턴 값 확인(모델)</a></li>
	<li><a href="returnParam1.do?no=110&title=모델 뷰 객체 제목">리턴 값 확인(모델-뷰)</a></li>
	<li>
		<form action="/firstSpring/printNotice.do" method="post">
			글번호 : <input type="number" name="no" value="0"/><br/>
			제목 : <input type="text" name="title"/><br/>
			내용 : <input type="text" name="content"/><br/>
			작성자 : <input type="text" name="writer"/><br/>
			조회수 : <input type="number" name="count" value="0"/><br/>
			작성일 : <input type="date" name="date"/><br/>
			<input type="submit" value="작성"/>
		</form>
	</li>
	<li><a href="memberList.do">멤버 목록</a></li>
</ul>
<hr>
<c:if test="${empty sessionScope.user }">
	<form action="login.do" method="post">
		아이디 : <input type="text" name="userid"/><br/>
		비밀번호 : <input type="password" name="password"/><br/>
		<input type="submit" value="로그인"/>
	</form>
</c:if>
<c:if test="${!empty sessionScope.user }">
	${sessionScope.user.username }님 환영합니다.<br/>
	<button onclick="javascript:location.href='logout.do';">로그아웃</button>
</c:if>




</body>
</html>








