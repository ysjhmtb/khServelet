## xml이 아닌 annotation으로 AOP 사용



servlet-context.xml >> aop 탭 >> beans에서 오른쪽 마우스 >> Insert \<aop:aspectj-autoproxy\> element   





그러면 

```xml
<aop:aspectj-autoproxy>
</aop:aspectj-autoproxy>
```

 

이와 같은 태그가 생긴다.   





이후 annotation 설정.

```java
package com.kh.firstSpring.common;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// * : 모든 반환형 
	// com.kh.firstSpring..*Service : firstSpring 밑의 모든 서비스 
	// .*(..) : 그 서비스 아래의 모든 메소드(매개변수 상관하지 않는다.)
	@Pointcut("execution(* com.kh.firstSpring..*Service.*(..))")
	public void getAllPointCut(){}
	
	@Before("getAllPointCut()")
	public void printLog(JoinPoint jp){
		
		Logger log = LoggerFactory.getLogger(LogAdvice.class);
		
		
		String name = jp.getSignature().getName();
		Object[] params = jp.getArgs();
		
		log.info(name + "() 메소드 실행, 파라미터 갯수 : " 
				+ params.length);
		
		for(Object param : params) {
			System.out.println("매개변수 : " + param.toString());
		}
		
	}
}


```



---

xml로 하고자 한다면

```xml
<!-- servlet-context.xml -->


<beans:bean id="log" class="com.kh.firstSpring.common.LogAdvice"/>

<!-- 
	* : 모든 반환형.
			
    com.kh.firstSpring.notice.model.service.NoticeService :
    이 경로 아래에 있는 것들 중

    com.kh.firstSpring..*Service.*(..) :
    firstSpring 아래의 모든 서비스에 적용.

    .*(..) :
    경로 아래의 모든 메소드(매개변수 타입은 구분하지 않겠다.)


-->
<aop:config>
    <aop:pointcut id="allPointCut" expression="execution(* com.kh.firstSpring..*Service.*(..))"/>
    
    <!-- 등록해둔 bean인 log를 언제 사용할지 설정. -->
    <aop:aspect ref="log">
        <aop:before method="printLog" pointcut-ref="allPointCut"/>
    </aop:aspect> 

</aop:config>
	
	
			
			
			
			
		 	
```

