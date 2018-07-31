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
	
	@Pointcut("execution(* com.kh.firstSpring..*Service.*(..))")
	public void getAllPointCut(){}
	
//	@Around("getAllPointCut()")
//	public Object printLog(ProceedingJoinPoint jp){
//		String name = jp.getSignature().getName();
//		
//		StopWatch sw = new StopWatch();
//		sw.start();
//		Object obj = null;
//		try {
//			obj = jp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		sw.stop();
//		
//		System.out.println(name + "() 메소드 실행, 소요 시간 : " 
//										+ sw.getTotalTimeMillis() + "(ms)초");
//		return obj;
//	}
}










