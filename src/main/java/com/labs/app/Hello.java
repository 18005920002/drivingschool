package com.labs.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.labs.app.beans.Person;

@Controller
@RequestMapping("/hello")
public class Hello {
	
	@ResponseBody
	@RequestMapping("/say")
	public String sayHello(){
		return "Hello,Spring Boot!";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List getList(){
		List list = new ArrayList();
		list.add("xxx");
		list.add("bbb");
		return list;
	}
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		Person p0 = new Person("xxxxxxxxxxxxx",12);
		List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        //m.addAttribute("singlePerson",p0);
        //m.addAttribute("people",people);
        mav.addObject("singlePerson", p0);
        mav.addObject("people", people);
		mav.setViewName("index");
        return mav;
	}
	
	
	
	
}
