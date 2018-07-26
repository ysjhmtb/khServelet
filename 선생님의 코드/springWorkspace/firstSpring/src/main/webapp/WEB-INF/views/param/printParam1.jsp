<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전달 값 확인</title>
</head>
<body>
	글번호 : ${notice.no }<br/>
	조회수 : ${notice.count}<br/>
	작성자 : ${notice.writer}<br/>
	작성일 : ${notice.date}<br/>
	제목 : ${notice.title }<br/>
	내용 : ${notice.content }<br/>
</body>
</html>