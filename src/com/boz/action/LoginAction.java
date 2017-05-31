package com.boz.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boz.obj.User;

@Controller

public class LoginAction {
	@RequestMapping("/login")
	@ResponseBody
	public String login(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			List<ObjectError> l=bindingResult.getAllErrors();
			for(ObjectError objectError:l){
				FieldError fieldError=(FieldError) objectError;
				Object s=fieldError.getRejectedValue();
				Object[] objects=objectError.getArguments();
				DefaultMessageSourceResolvable defaultMessageSourceResolvable=(DefaultMessageSourceResolvable)objects[0];
				defaultMessageSourceResolvable.getDefaultMessage();
				String[] codes=objectError.getCodes();
				String message=objectError.getDefaultMessage();
				String objectName=objectError.getObjectName();
				String toString=objectError.toString();
			}
		}
		throw new RuntimeException("123");
	}
	@RequestMapping("/ModelAndView")
	public ModelAndView test(){
		return new ModelAndView("NewFile");
	}
}
