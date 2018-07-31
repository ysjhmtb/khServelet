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

