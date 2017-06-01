package com.boz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;

import com.boz.HandlerExceptionResolver.ValidationMessageException;

@Component
@Aspect
public class ValidationAspect {
	@Around("@args(javax.validation.Valid)")
	public void aroundValid(ProceedingJoinPoint jp) throws Throwable{
		jp.proceed(jp.getArgs());
		/*Object[] objects=jp.getArgs();
		BindingResult bindingResult=null;
		for(Object obj:objects){
			if(obj instanceof BindingResult){
				bindingResult=(BindingResult)obj;
				break;
			}
		}
		Assert.notNull(bindingResult);
		if(bindingResult.hasErrors()){
			throw new ValidationMessageException(makeMsg(bindingResult));
		}else {
			jp.proceed(jp.getArgs());
		}*/
	}
	public String makeMsg(BindingResult bindingResult){
		return null;
	}
}