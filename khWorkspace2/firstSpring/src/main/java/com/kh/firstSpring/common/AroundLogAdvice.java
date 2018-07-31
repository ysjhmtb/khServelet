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
	
	@Around("getAllPointCut()")
	public Object printLog(ProceedingJoinPoint jp){
		
		String name = jp.getSignature().getName();

		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = null;
		
		
		try {
			obj = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sw.stop();

		System.out.println(name + "() 메소드 실행, 소요 시간 : " 
				+ sw.getTotalTimeMillis() + "(ms)");
		
		return obj;
	}
}

