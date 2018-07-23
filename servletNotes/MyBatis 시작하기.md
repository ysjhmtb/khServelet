[MyBatis 시작하기](http://www.mybatis.org/mybatis-3/ko/getting-started.html#) 

<br>

1) mybatis jar를 **WEB-INF/lib**에 위치시킨다.

<br>

2) **web/resource** 폴더 생성

<br>

3) web/resource/mybatis/**mybatis-config.xml**  <br>

**XML에서 SqlSessionFactory 빌드하기** 의 아래에 위치한 부분의 예시 참조.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

<!-- http://www.mybatis.org/mybatis-3/ko/configuration.html#settings  -->

 <settings>
 	<setting name="jdbcTypeForNull" value="NULL"/>
 	<setting name="mapUnderscoreToCamelCase" value="true"/> 	
 </settings>


  <typeAliases>
  	<typeAlias type="com.kh.java.mybatis.model.vo.Member" alias="Member"/>
  	<typeAlias type="com.kh.java.mybatis.model.vo.Search" alias="Search"/>
  	<typeAlias type="com.kh.java.mybatis.model.vo.Photo" alias="Photo"/>
  	<typeAlias type="com.kh.java.mybatis.model.vo.PhotoReply" alias="Reply"/>
  
  </typeAliases>
  
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@localhost:59161:XE"/>
        <property name="username" value="jsp"/>
        <property name="password" value="jsp"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="/mybatis/sql/memberMapper.xml"/>
    <mapper resource="/mybatis/sql/photoMapper.xml"/>
  </mappers>
  
  
  
</configuration>
```

<br>

4) resource/mybatis/sql/**memberMapper.xml** <br>

**매핑된 SQL 구문 살펴보기** 의 아래에 위치한 부분의 예시 참조.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  

<mapper namespace="MemberMapper">

<select id="selectMemberList" resultType="Member">
SELECT USERID, USERNAME, AGE, EMAIL, PHONE FROM MEMBER ORDER BY USERNAME
</select>

<select id="selectMemberSearch" parameterType="Search" resultType="Member">
SELECT USERID, USERNAME, AGE, EMAIL, PHONE FROM MEMBER
<if test="condition == 'name'"> WHERE USERNAME LIKE '%' || #{keyword} || '%' </if>
<if test="condition == 'id'"> WHERE USERID = #{keyword} </if>
<if test="condition == 'age'"> WHERE AGE >= TO_NUMBER(#{keyword}) </if>


ORDER BY USERNAME
</select>

<select id="selectMemberSearch2" parameterType="Search" resultType="Member">
SELECT USERID, USERNAME, AGE, EMAIL, PHONE FROM MEMBER
<choose>
	<when test="condition == 'name'"> WHERE USERNAME LIKE '%' || #{keyword} || '%' </when>
	<when test="condition == 'id'"> WHERE USERID = #{keyword} </when>
	<otherwise> WHERE AGE >= TO_NUMBER(#{keyword}) </otherwise>
</choose>



ORDER BY USERNAME
</select>

<select id="selectMember" parameterType="string" resultType="Member">
SELECT USERID, PASSWORD, USERNAME, GENDER, AGE, EMAIL, PHONE, ADDRESS, HOBBY, ENROLLDATE FROM MEMBER WHERE USERID = #{test}
</select>

<update id="updateMember" parameterType="Member">
UPDATE MEMBER SET USERNAME=#{username}, AGE=#{age}, PHONE=#{phone} WHERE USERID=#{userid}
</update>

<delete id="deleteMember" parameterType="string"> DELETE FROM MEMBER WHERE USERID = #{id} </delete>

<insert id="insertMember" parameterType="Member">
INSERT INTO MEMBER(USERID, PASSWORD, USERNAME, GENDER, AGE, PHONE, ENROLLDATE) VALUES (#{userid}, #{password}, #{username}, #{gender}, #{age}, #{phone}, SYSDATE)
</insert>


</mapper>
```

resource/mybatis/sql/**photoMapper.xml**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  
<mapper namespace="PhotoMapper">

<!--
<collection property="reply" column="NO" ofType="Reply" resultMap="replyMap"/>

게시글 하나에 대해 여러 댓글을 담는 리스트. 여러 댓글이 공통적으로 하나의 게시글에 연동되므로
column="NO"이다.
-->

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


 
 <select id="selectPhotoList" resultType="Photo">
	<include refid="photoHeader"/>
</select>

<!-- 
<select id="selectPhotoList" resultMap="resultPhoto">
	SELECT NO, TITLE, CONTENT, READ_COUNT, WRITE_DATE, USER_ID FROM PHOTO
</select> 
-->

<select id="selectPhoto" parameterType="hashmap" resultMap="resultPhoto">
	SELECT P.NO, P.TITLE, P.CONTENT, P.READ_COUNT,
	  P.WRITE_DATE, P.USER_ID,
	  R.NO AS "R_NO", P.NO AS "PHOTO_NO", R.WRITER,
	  R.CONTENT AS "R_CONTENT",
	  R.WRITE_DATE AS "R_DATE"
	
	FROM PHOTO P
	JOIN PHOTO_REPLY R
	ON P.NO = R.PHOTO_NO
	
	WHERE P.NO = #{no}
</select>



<sql id="photoHeader">
	SELECT NO, TITLE, CONTENT, READ_COUNT, WRITE_DATE, USER_ID FROM PHOTO
</sql>



</mapper>
```







<br>

5)  Properties >> Java Build Path >> Add Folder >> resource 폴더를 더하기.

<br>

6) **MySqlFactory.java** (보통은 common 폴더에 위치) <br>

**XML에서 SqlSessionFactory 빌드하기** 의 아래에 위치한 부분의 예시를 참조.

```java
package com.kh.java.mybatis.model.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlFactory {
	
	public static SqlSessionFactory getSqlSessionFactory(){
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}


```

<br>

7) **index.jsp**

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스 페이지</title>
</head>
<body>
<h1>EL 수업 목록</h1>
<a href="/mwp2/el1.do">1.기본 객체(vo) 정보 출력</a><br/>
<a href="/mwp2/el2.do">2.기본 객체(map) 정보 출력</a><br/>
<a href="/mwp2/el3.do">3.기본 객체(list) 정보 출력</a><br/>
<a href="/mwp2/el4.do">4.기본 객체(array) 정보 출력</a><br/>
<a href="/mwp2/views/el/el5.jsp">5.연산자 출력</a><br/>
<a href="/mwp2/el6.do">6.내장객체(scope) 출력</a><br/>
<a href="/mwp2/views/el/elForm.jsp">7. 폼 데이터 전송 시 출력</a> <br>

<a href="/mwp2/views/jstl/jstlIndex.jsp">JSTL index</a>


<h1>mybatis</h1>
<a href="memberList.do">member</a>
<a href="photoList.do">photo</a>

</body>
</html>










```

<br>

8) **MemberListServlet.java**

```java
package com.kh.java.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.mybatis.model.service.MybatisService;
import com.kh.java.mybatis.model.vo.Member;


@WebServlet("/memberList.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberListServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new MybatisService().selectMemberList();
		System.out.println(list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/jstl/memberList.jsp");
		request.setAttribute("list", list);
		view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


```

<br>

9) **MybatisService.java**

```java
package com.kh.java.mybatis.model.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.dao.MybatisDao;
import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Photo;
import com.kh.java.mybatis.model.vo.Search;

public class MybatisService {
	
	MybatisDao dao = new MybatisDao();

	public List<Member> selectMemberList(){ 
		
		//오토 커밋을 막기 위해서 false로 설정.
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list = dao.selectMemberList(session);
		session.close();
		
		return list;
		
		
	}

	public Member selectMember(String userid) {
		
		//SqlSession이 기존의 Connection과 유사함.
		SqlSession session 
			= MySqlFactory.getSqlSessionFactory().openSession(false);
		Member member 
			= dao.selectMember(session, userid);
		session.close();
		return member;
		 
	}

	public int updateMember(Member member) {
		SqlSession session 
		= MySqlFactory.getSqlSessionFactory().openSession(false);
		
		int result = dao.updateMember(session, member);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

	public int deleteMember(String userid) {
		SqlSession session 
		= MySqlFactory.getSqlSessionFactory().openSession(false);
		int result = dao.deleteMember(session, userid);
		
		if(0 < result){
			session.commit();
		}else{
			session.rollback();
		}
		session.close();
		return result;
	}

	public int insertMember(Member member) {
		
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		int result = dao.insertMember(session, member);
		
		if(0 < result) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
		
		
	}

	public List<Member> selectMemberSearch(Search search) {
		
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list = dao.selectMemberSearch(session, search);
		
		session.close();
		return list;
	}

	public List<Photo> selectPhotoList() {
		
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Photo> list = dao.selectPhtoList(session);
		session.close();
		return list;
	}

	public Photo selectPhoto(HashMap<String, String> params) {
		
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		Photo photo = dao.selectPhoto(session, params);
		session.close();
		return photo;
	}

	
	
	
	
	
	
}


```

<br>

10) **MybatisDao.java** 

```java
package com.kh.java.mybatis.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Photo;
import com.kh.java.mybatis.model.vo.Search;


public class MybatisDao {

	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList("MemberMapper.selectMemberList");
	}

	public Member selectMember(SqlSession session, String userid) {
		return session.selectOne("MemberMapper.selectMember",userid);		
	}

	public int updateMember(SqlSession session, Member member) {
		return session.update("MemberMapper.updateMember", member);
	}

	public int deleteMember(SqlSession session, String userid) {
		return session.delete("MemberMapper.deleteMember", userid);
	}

	public int insertMember(SqlSession session, Member member) {
		return session.insert("MemberMapper.insertMember", member);
	}

	public List<Member> selectMemberSearch(SqlSession session, Search search) {
		return session.selectList("MemberMapper.selectMemberSearch2", search);
	}

	public List<Photo> selectPhtoList(SqlSession session) {
		return session.selectList("PhotoMapper.selectPhotoList");
	}

	public Photo selectPhoto(SqlSession session, HashMap<String, String> params) {
		return session.selectOne("PhotoMapper.selectPhoto", params);
	}

	

}



```

<br>

































