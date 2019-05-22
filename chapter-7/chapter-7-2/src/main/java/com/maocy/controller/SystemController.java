package com.maocy.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maocy.entity.Employee;
import com.maocy.exception.MyException;

@Controller
public class SystemController {

	@RequestMapping("/login")
	public String login(String name) {
		if (StringUtils.isBlank(name)) {
			throw new MyException();
		}
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(String name, String password, Model model) {
		model.addAttribute("name", name);
		return "redirect:/register-info/{name}?password=" + password;
	}
	
	@RequestMapping("/register-info/{name}")
	public String registerInfo(@PathVariable String name, String password, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "register";
	}
	
	@RequestMapping("/employee-query")
	public String queryEmployee(RedirectAttributes model) {
		Employee employee = new Employee();
		employee.setName("张三");
		employee.setAge(25);
		employee.setSex("男");
		employee.setEmail("322222222@qq.com");
		employee.setPhoneNumber("13286474151");
		model.addAttribute("id", UUID.randomUUID());
		model.addFlashAttribute(employee);
		return "redirect:/employee-show/{id}";
	}
	
	@RequestMapping("/employee-show/{id}")
	public String showEmployee(@PathVariable String id, Employee employee, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("employee", employee);
		return "employee";
	}
}
