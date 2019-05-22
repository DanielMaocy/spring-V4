package com.maocy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maocy.Employee;

@Controller
public class HomeController {
	
	/**
	 * 首页
	 * @Title: home
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月17日 下午5:15:15
	 * @return
	 */
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	/**
	 * 注册页面
	 * @Title: pageRegister
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月21日 下午2:13:31
	 * @param model
	 * @return
	 */
	@RequestMapping("/page/register")
	public String pageRegister(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}
	
	/**
	 * 注册
	 * @Title: register
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月17日 下午5:15:05
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid Employee employee, Errors errors) {
		System.out.println("注册信息：" + employee.toString());
		return "register";
	}
}
