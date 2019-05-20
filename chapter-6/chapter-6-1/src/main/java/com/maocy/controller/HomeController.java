package com.maocy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maocy.Employee;

@Controller
public class HomeController {
	
	/**
	 * 跳转到页面
	 * @Title: toPage
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月17日 下午5:09:50
	 * @param pageName
	 * @return
	 */
	@RequestMapping("/page/{pageNames}")
	public String toPage(@PathVariable String pageName) {
		return pageName;
	}

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
	public String register(Employee employee) {
		
		return "register";
	}
}
