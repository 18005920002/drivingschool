package com.labs.framework.ac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.labs.framework.ac.service.LoginService;
import com.labs.framework.ac.vo.UserForm;

@RestController
@RequestMapping("sec")
public class HomeController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping("/loginform")
	public ModelAndView loginForm(UserForm userForm){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.html");
		return mav;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(UserForm userForm){
		System.out.println("POST");
		ModelAndView mav = new ModelAndView();
		String principal = userForm.getUsername();
		String credential = userForm.getPassword();
		
		if(service.login(principal, credential)){
			mav.setViewName("success.html");
		}else{
			mav.setViewName("login.html");
		}
		return mav;
	}
}
