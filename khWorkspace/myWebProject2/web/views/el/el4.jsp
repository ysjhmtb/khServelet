<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체 값 확인</title>
</head>
<body>
<%-- <%= %> -> out.print(member.getAge()); --%>
<%-- ${} -> out.print();  --%>

이름1 : ${member[0].name}<br/>
나이1 : ${member[0].age}<br/>
전화번호1 : ${member[0].phone }<br/>


이름2 : ${member[1].name }<br/>
나이2 : ${member[1].age }<br/>
전화번호2 : ${member[1].phone }<br/>

</body>
</html>







