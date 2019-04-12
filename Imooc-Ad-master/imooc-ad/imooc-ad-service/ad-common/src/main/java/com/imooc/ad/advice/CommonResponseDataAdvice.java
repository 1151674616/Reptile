package com.imooc.ad.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//拦截所有请求
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object>{
  /*在写入响应前 可以做一些操作
   * 
  */
	@Override
	public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType arg2,
			Class<? extends HttpMessageConverter<?>> arg3, 
					ServerHttpRequest arg4, 
					ServerHttpResponse arg5) {
		// TODO Auto-generated method stub
		return null;
	}
	/*判断这个响应是否拦截，
	 * 第一个参数 MethodParameter 根据方法去判断，
	 * 或者第二个参数根据类去判断
	 * */
	@Override
	public boolean supports(MethodParameter arg0,
			Class<? extends HttpMessageConverter<?>> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
