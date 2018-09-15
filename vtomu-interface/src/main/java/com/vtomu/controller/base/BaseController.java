package com.vtomu.controller.base;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import com.vtomu.util.VtomuException;

@ControllerAdvice
public class BaseController extends AbstractJsonpResponseBodyAdvice{
	
	private static final Logger logger=LoggerFactory.getLogger(BaseController.class);
	//错误的返回值
	public static final int ERROR_CODE=1;
	//正常的返回值
	public static final int NORMAL_CODE=0;
	
	public Object object;
	
	public BaseController() {
		super("callback","jsonp");
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> handleException(VtomuException ex){
		Map<String, Object> result = new HashMap<String, Object>();
		logger.error(ex.getLocalizedMessage());
		result.put("message", ex.getMessage());
		result.put("error_code", ERROR_CODE);
		return result;
	}
	
	
}
