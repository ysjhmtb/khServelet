## 에러가 발생한 경우 rollback 실행되도록 설정



root-context.xml

```xml

<beans xmlns:tx="http://www.springframework.org/schema/tx" >

<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <tx:method name="select*" read-only="true" />
        <tx:method name="insert*" rollback-for="Exception"/>
        <tx:method name="update*" rollback-for="Exception"/>
        <tx:method name="delete*" rollback-for="Exception"/>
    </tx:attributes>
    </tx:advice>

    <aop:config proxy-target-class="true">
        <aop:pointcut expression="execution(* com.kh.firstSpring..*Service.*(..))" 
                      id="serviceMethod"/>
        <aop:advisor advice-ref="txAdvice" id="transactionAdvisor"
                     pointcut-ref="serviceMethod"/>
    </aop:config>

    

```

기본적으로 위의 내용이 들어가야 한다.



전체 내용은 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xmlns:aop="http://www.springframework.org/schema/aop" 
xmlns:c="http://www.springframework.org/schema/c" 
xmlns:tx="http://www.springframework.org/schema/tx" 
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
	<!-- Root Context: defines shared resources visible to all other web components -->
	
	
	<!-- 마이바티스 객체를 넣기. DI 선언.  -->
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
		<property name="url" value="jdbc:oracle:thin:@127.0.0.1:59161:xe"/>
		<property name="username" value="jsp"/>
		<property name="password" value="jsp"/>
	</bean>
	
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"/>
	</bean>
	
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="select*" read-only="true" />
			<tx:method name="insert*" rollback-for="Exception"/>
			<tx:method name="update*" rollback-for="Exception"/>
			<tx:method name="delete*" rollback-for="Exception"/>
		</tx:attributes>
	</tx:advice>
	
	<aop:config proxy-target-class="true">
		<aop:pointcut expression="execution(* com.kh.firstSpring..*Service.*(..))" 
			id="serviceMethod"/>
		<aop:advisor advice-ref="txAdvice" id="transactionAdvisor"
			pointcut-ref="serviceMethod"/>
	</aop:config>
	
	
	
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:mybatis/mybatis-config.xml"/>
		<property name="dataSource" ref="dataSource"/>
	</bean>
	
	<bean class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSession"/>
	</bean>
	
	
	
	
		
	<!-- FileUpload -->
	<bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="100000000" />
		<property name="maxInMemorySize" value="100000000" />
	</bean>
	
	
	
	
		
</beans>

```



다음과 같이 주석처리를 해야 에러가 나지 않는다. `obj = jp.proceed();` 의 결과를 반환하면서 문제가 발생하는 것으로 생각된다. insert의 결과는 정수이다. 제대로 입력이 안되면 결국 0이나 null이 반환되는데, 이 과정에서 문제가 발생한 것으로 생각된다.



ArroundLogAdvice.java

```java
package com.kh.firstSpring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundLogAdvice {
	
	// * : 모든 반환형 
	// com.kh.firstSpring..*Service : firstSpring 밑의 모든 서비스 
	// .*(..) : 그 서비스 아래의 모든 메소드(매개변수 상관하지 않는다.)
	@Pointcut("execution(* com.kh.firstSpring..*Service.*(..))")
	public void getAllPointCut(){}
	
//	@Around("getAllPointCut()")
//	public Object printLog(ProceedingJoinPoint jp){
//		
//		String name = jp.getSignature().getName();
//
//		StopWatch sw = new StopWatch();
//		sw.start();
//		Object obj = null;
//		
//		
//		try {
//			obj = jp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		sw.stop();
//
//		System.out.println(name + "() 메소드 실행, 소요 시간 : " 
//				+ sw.getTotalTimeMillis() + "(ms)");
//		
//		return obj;
//	}
}


```



