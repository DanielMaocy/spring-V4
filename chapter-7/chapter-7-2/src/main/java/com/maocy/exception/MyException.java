package com.maocy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常
 * @Title: MyException
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="自定义异常")
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
