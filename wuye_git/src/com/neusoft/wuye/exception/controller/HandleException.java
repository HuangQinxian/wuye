package com.neusoft.wuye.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.common.ResultMessage;

@RestController
@ControllerAdvice
public class HandleException {
	
	@ExceptionHandler(Exception.class)
	public ResultMessage handle(Exception ex) {
		return new ResultMessage("N", "操作失败"+ex.getMessage());
	}
}
