package com.boz.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Object login(@Valid User user,BindingResult bindingResult){
		Map<String,String> map=new HashMap<String, String>();
		map.put("sdf", "sdfsdf");
		map.put("account", user.getAccount());
		return map;
	}
	@RequestMapping("/ModelAndView")
	public ModelAndView test(){
		return new ModelAndView("NewFile");
	}
}
