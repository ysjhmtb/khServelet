# Maven & Spring 시작하기





## Maven

1) https://maven.apache.org/download.cgi 에서 **Binary zip archive	apache-maven-3.5.4-bin.zip** 다운로드   

2) dev 폴더에 저장   

3) /Users/yunseokjeon/dev/apacheMaven/repository 를 만들고 apacheMaven에 압축이 풀린 메이븐 위치   

4) settings.xml에서 <localRepository>/Users/yunseokjeon/dev/apacheMaven/repository </localRepository>   

5) eclipse >> 환경설정 >> Maven >> UserSettings >> /Users/yunseokjeon/dev/apacheMaven/apache-maven-3.5.4/conf/settings.xml   





## Spring

1) Eclipse Marketplace >> sts 검색 >> 설치   

2) new project >> spring legacy >> spring mvc   

3) the top-level package >> com.kh.firstSpring 일 경우 컨텍스트 루트가 firstSpring이 된다. 이를 기준으로 com.kh.firstSpring.member 와 같이 패키지를 만들게 된다.  

4) src >> main >> webapp >> WEB-INF >> spring >> root-context.xml 과 src >> main >> webapp >> WEB-INF >> spring >> appServlet >> servlet-context.xml 이해 필요.   





[[SPRING] web.xml , root-context.xml , servlet-context.xml 에 관하여...](http://debugdaldal.tistory.com/127)





```xml
<!-- web.xml -->

<!--원본 -->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

	<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/root-context.xml</param-value>
	</context-param>
	
	<!-- Creates the Spring Container shared by all Servlets and Filters -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>

</web-app>








<!-- 블로그 참조 -->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
      <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
      <context-param>  
          <!-- - 루트 컨텍스트로 모든 서블릿과 필터들이 공유함. root-context.xml을 정의 -->
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/root-context.xml</param-value>
      </context-param>
      
      <!-- Creates the Spring Container shared by all Servlets and Filters -->
      <listener> 
   <!-- - 리스너로써 루트 컨텍스트에 정의 되어있는 것들을 모든 서블릿과 필터가 공유할 수 있게 해준다고 함. -->
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
      <!-- Processes application requests -->
      <servlet> <!-- - 서블릿 설정 -->
            <servlet-name>appServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> 
          <!-- - DispatcherServlet으로 앞단에서 요청정보를 핸들링 해줌. -->
            <init-param>
                  <param-name>contextConfigLocation</param-name> 
                  <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value> <!-- -servlet-context.xml을 가르키고 있음. -->
            </init-param>
            <load-on-startup>1</load-on-startup>
      </servlet>
            
      <servlet-mapping> <!-- - appServlet에 대한 url-pattern을 정의 -->
            <servlet-name>appServlet</servlet-name>
            <url-pattern>/</url-pattern>
      </servlet-mapping>
</web-app>



```





```xml
<!-- servlet-context.xml -->

<!-- 원본 -->
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="com.kh.firstSpring" />
	
	
	
</beans:beans>








<!-- 블로그 참조 -->


<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:beans="http://www.springframework.org/schema/beans"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
            http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
      <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
      
      <!-- Enables the Spring MVC @Controller programming model -->
      <annotation-driven /> 
    <!-- - 어노테이션을 사용한다고 선언 -->
    
      <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
      <resources mapping="/resources/**" location="/resources/" /> 
    
    <!-- - HTML 리소스 디렉토리 정의 -->
    <!-- ** 의미 : 폴더에 속해있는 모든 것. -->
    
      <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
      <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"> 
          
          <!-- - ViewResolver로 jsp와 name 을 매핑 -->
            <beans:property name="prefix" value="/WEB-INF/views/" />
            <beans:property name="suffix" value=".jsp" />
      </beans:bean>
      
      <context:component-scan base-package="com.hee.heechart" /> 
    
    <!-- - 베이스 패키지 하위 모든 어노테이션을 스캔해서 빈으로 등록하겠다는 것. -->
     
</beans:beans>



```





```xml
<!-- root-context.xml -->
<!-- 원본.  -->
<!-- beans 설정에 사용됨. -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- Root Context: defines shared resources visible to all other web components -->
		
</beans>

```





5) firstSpring >> Maven >> update project   

6) pom.xml >> **java-version** >> 1.8 >> org.springframework-version >> 5.0.6.RELEASE   

7) home.jsp 에 한글 인코딩을 위해 다음 입력.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```

8) 

web.xml 에서 

```xml
<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
</servlet-mapping>
```

를

```xml
<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>*.do</url-pattern>
</servlet-mapping>
```

와 같이 변경.

9) 

HomeController.java 에서 

`@RequestMapping(value = "/", method = RequestMethod.GET) ` 를 `@RequestMapping(value = "index.do", method = RequestMethod.GET)` 로 변경.

10) 

servlet-context.xml에서   

```xml
<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
```

를 통해 가지는 이점.





MemberController.java 에서 

```java
@Controller
public class MemberController {
	
	@RequestMapping("memberList.do")
	public String memberList() {
		
		
		
		
		return "member/memberList";
	}

}

```

"member/memberList" 라고만 입력해도 prefix와 suffix 가 자동으로 연결되어 완성된다.



## Spring의 구조

[Spring MVC flow with Example](http://www.codenuclear.com/spring-mvc-flow-with-example/)   

[Spring MVC 구조의 처리 과정](http://jeong-pro.tistory.com/96)   

[Spring MVC RESTful Web Service – difference between @Controller and @RestController](http://javasampleapproach.com/spring-framework/spring-mvc-rest-difference-between-controller-and-restcontroller)   



























