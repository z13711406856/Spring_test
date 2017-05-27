package com.boz.action;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
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
	public String login(@Valid User user,HttpServletRequest request){

		throw new RuntimeException("123");
	}
	@RequestMapping("/ModelAndView")
	public ModelAndView test(){
		return new ModelAndView("NewFile");
	}
}
