package com.boz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.boz.log4j2.ControllerLogger;

@Component
@Aspect
public class RequestMappingAspect {
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void arroundRequestMapping(ProceedingJoinPoint jp) throws Throwable{
		long begin=System.currentTimeMillis();
		jp.proceed(jp.getArgs());
		long end=System.currentTimeMillis();
		ControllerLogger.log.info(String.format("%s ÏûºÄ:%dms",jp.toString(),end-begin));
	}
	
}
