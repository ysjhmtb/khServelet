<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<!-- 
		
<resultMap type="Photo" id="resultPhoto">
	<id property="no" column="NO"/>
	<result property="title" column="TITLE"/>
	<result property="content" column="CONTENT"/>
	<result property="readCount" column="READ_COUNT"/>
	<result property="writeDate" column="WRITE_DATE"/>
	<result property="userId" column="USER_ID"/>
	<collection property="reply" column="NO" ofType="Reply" resultMap="replyMap"/>
</resultMap>

<resultMap type="Reply" id="replyMap">
	<id property="no" column="R_NO"/>
	<result property="photoNo" column="PHOTO_NO"/>
	<result property="writer" column="WRITER"/>
	<result property="content" column="R_CONTENT"/>
	<result property="writeDate" column="R_DATE"/>
</resultMap>
	 -->
	
	제목 : <c:out value='${photo.title }'/> <br>
	내용 : <c:out value='${photo.content }'/> <br>
	읽은 횟수 : <c:out value='${photo.readCount }'/> <br>	
	작성 시간 : <c:out value='${photo.writeDate }'/> <br>
	작성자 : <c:out value='${photo.userId }'/> <br>
	
	<c:forEach items="${photo.reply }" var="reply" varStatus="status">
	댓글 : <br>
	<c:out value='${reply.no }'/> <br>
	<c:out value='${reply.photoNo }'/> <br>
	<c:out value='${reply.writer }'/> <br>
	<c:out value='${reply.content }'/> <br>
	<c:out value='${reply.writeDate }'/><br>
	</c:forEach>
	


</body>
</html>










