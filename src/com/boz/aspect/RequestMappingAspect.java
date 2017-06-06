package com.boz.aspect;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.boz.log4j2.ControllerLogger;

@Component
@Aspect
public class RequestMappingAspect {
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void arroundRequestMapping(ProceedingJoinPoint jp) throws Throwable{
		long begin=System.currentTimeMillis();
		Object[] objects=jp.getArgs();//get request arguments
		for(Object obj:objects){
			if(obj instanceof BindingResult){
				BindingResult bindingResult=(BindingResult) obj;
				if(bindingResult.hasErrors()){
					doValidError(bindingResult);
				}
				return;
			}
		}
		jp.proceed(jp.getArgs());
		long end=System.currentTimeMillis();
		ControllerLogger.log.info(String.format("%s ÏûºÄ:%dms",jp.toString(),end-begin));
	}
	
	private void doValidError(BindingResult bindingResult){
		String typeName="vaildError";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("type", typeName); 
		List<ObjectError> eList=bindingResult.getAllErrors();
		for(ObjectError objectError:eList){
			DefaultMessageSourceResolvable defaultMessageSourceResolvable=(DefaultMessageSourceResolvable)objectError.getArguments()[0];
			String eleName=defaultMessageSourceResolvable.getDefaultMessage();
			String msg=objectError.getDefaultMessage();
		}
	}
	private void putError(Map map,String eleName,String msg){
		String key="content";
		List<Map.Entry<String, String>> list=(List<Map.Entry<String, String>>)map.get(key);
		if(list==null){
			list=new ArrayList<Map.Entry<String, String>>();
			map.put(key, list);
		}
		list.add(new AbstractMap.SimpleEntry<String,String>(eleName,msg));
		
	}
	
}
