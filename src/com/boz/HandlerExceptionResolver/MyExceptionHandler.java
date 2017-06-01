package com.boz.HandlerExceptionResolver;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		try{
			BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			bWriter.write("123123123");
			bWriter.close();
		}catch(Throwable e){
			
		}
		return new ModelAndView();
	}

}
