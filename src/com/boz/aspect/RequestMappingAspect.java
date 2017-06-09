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
	public Object arroundRequestMapping(ProceedingJoinPoint jp) throws Throwable{
		long begin=System.currentTimeMillis();
		Object result=null;
		Object[] objects=jp.getArgs();//get request arguments
		result=doBindingResult(objects);
		if(result==null){
			result=jp.proceed(jp.getArgs());
		}
		long end=System.currentTimeMillis();
		ControllerLogger.log.info(String.format("%s 消耗:%dms",jp.toString(),end-begin));
		return result;
	}
	
	private Object doBindingResult(Object[] args){//遍历每个请求参数，找到BindingResult
		for(Object obj:args){
			if(obj instanceof BindingResult){
				BindingResult bindingResult=(BindingResult) obj;
				if(bindingResult.hasErrors()){
					return doValidError(bindingResult);
				}
			}
		}
		return null;
	}
	//将异常数据添加到Map中,以json格式返回
	/*{"type":"vaildError",
	  "content":[{"password":"密码不能为空"}]} 此[]内的列表可以存储多个错误提示*/
	private Object doValidError(BindingResult bindingResult){
		String typeValue="vaildError";
		String typeKey="type";
		String listKey="content";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put(typeKey, typeValue); 
		List<Map.Entry<String, String>> cList=new ArrayList<Map.Entry<String,String>>();
		map.put(listKey, cList);
		List<ObjectError> eList=bindingResult.getAllErrors();
		for(ObjectError objectError:eList){
			DefaultMessageSourceResolvable defaultMessageSourceResolvable=(DefaultMessageSourceResolvable)objectError.getArguments()[0];
			String eleName=defaultMessageSourceResolvable.getDefaultMessage();
			String msg=objectError.getDefaultMessage();
			cList.add(new AbstractMap.SimpleEntry<String,String>(eleName,msg));
		}
		return map;
	}

	
}
