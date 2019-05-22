package com.maocy.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maocy.exception.MyException;

/**
 * 异常处理
 * @Title: ExceptionHandler
 */
@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(MyException.class)
	public String exception() {
		return "error";
	}
}
