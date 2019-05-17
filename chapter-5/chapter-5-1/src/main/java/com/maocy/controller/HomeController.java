package com.maocy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maocy.entity.Employee;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home-page", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/home-page-1", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("value", "hello World....");
		return "home";
	}
	
	@RequestMapping(value="/home-page-query-param", method=RequestMethod.GET)
	public String home(Model model, @RequestParam(name="name", defaultValue="spring mvc", required=true) String name) {
		model.addAttribute("value", name);
		return "home";
	}
	
	@RequestMapping(value="/home-page/{name}/{age}", method=RequestMethod.GET)
	public String home(Model model, @PathVariable("name") String name, @PathVariable("age") Integer age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "home";
	}
	
	@RequestMapping(value="/home-page-form", method=RequestMethod.GET)
	public String home(Model model, @Valid Employee employee) {
		model.addAttribute("employee", employee);
		return "home";
	}
}
