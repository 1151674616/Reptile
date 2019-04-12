package com.imooc.ad.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CommonResponse;

@RestControllerAdvice
public class GlobalExceptionAdvice {
	//不指定value值那么处理所有的异常 指定处理 AdException 异常
	@ExceptionHandler(value = AdException.class)
	public CommonResponse<String> handlerException(HttpServletRequest req,AdException ex){
	
		CommonResponse<String>  response = new CommonResponse<>(-1,"business error");
		response.setData(ex.getMessage());
		return response;		
	}
}
