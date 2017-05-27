package com.boz.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.boz.log4j2.MyLogger;
import com.boz.obj.User;

@Component
@Aspect
public class TestAspect {
	@Before("execution(* com.boz.action.LoginAction.login(..))")
	public void before(JoinPoint jp){
		MyLogger.log.info(jp.toLongString());
		Object[] args=jp.getArgs();
		/*if(args[0] instanceof User){
			User u=(User)args[0];
			u.setPassword("kdjfsdf");
		}*/
		
	}
}
