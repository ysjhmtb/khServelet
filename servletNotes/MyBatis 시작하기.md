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

  <typeAliases>
  	<typeAlias type="com.kh.java.mybatis.model.vo.Member" alias="Member"/>
  
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
    SELECT USERID, USERNAME,AGE, EMAIL, PHONE
	FROM MEMBER
	ORDER BY USERNAME
  </select>
  
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
<h1>mybatis</h1>
<a href="memberList.do">select</a>
```

<br>

8) **MemberListServlet.java**

```java
package com.kh.java.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.el.model.vo.Member;
import com.kh.java.mybatis.model.service.MybatisService;


@WebServlet("/memberList.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberListServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new MybatisService().selectMemberList();
		System.out.println(list);
		
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

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.el.model.vo.Member;
import com.kh.java.mybatis.model.dao.MybatisDao;

public class MybatisService {
	
	MybatisDao dao = new MybatisDao();

	public List<Member> selectMemberList(){ 
		
		//오토 커밋을 막기 위해서 false로 설정.
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list = dao.selectMemberList(session);
		session.close();
		
		return list;
		
		
	}
	
}

```

<br>

10) **MybatisDao.java** 

```java
package com.kh.java.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.el.model.vo.Member;

public class MybatisDao {

	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList("MemberMapper.selectMemberList");
	}

}


```

<br>

































