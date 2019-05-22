package com.maocy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maocy.exception.MyException;

@Controller
public class HomeController {

	/**
	 * 首页
	 * @Title: home
	 * @param value
	 * @return
	 */
	@RequestMapping("/home")
	public String home(String value) {
		if ("exception".equals(value)) {
			throw new MyException();
		}
		
		return "home";
	}
	
	/**
	 * 异常处理方法
	 * @Title: error
	 * @return
	 */
	@ExceptionHandler(MyException.class)
	public String error() {
		return "error";
	}
}
