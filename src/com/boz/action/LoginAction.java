package com.boz.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam(name="account",required=false) String account,@RequestParam(name="password",required=false)String password){
		throw new RuntimeException("123");
	}
	@RequestMapping("/ModelAndView")
	public ModelAndView test(){
		return new ModelAndView("NewFile");
	}
}
