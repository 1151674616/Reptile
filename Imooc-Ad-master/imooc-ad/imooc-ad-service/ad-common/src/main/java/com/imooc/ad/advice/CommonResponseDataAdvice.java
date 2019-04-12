package com.imooc.ad.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
//拦截所有请求
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object>{
  /*在写入响应前 可以做一些操作
   * 
  */
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType arg2,
			Class<? extends HttpMessageConverter<?>> arg3, 
					ServerHttpRequest arg4, 
					ServerHttpResponse arg5) {
		// TODO Auto-generated method stub
		CommonResponse<Object> response = new CommonResponse<>(0,"");
		//如果返回对象是空
		if(null == arg0){
			return response;
		//如果返回对象是CommonResponse
		}else if( arg0 instanceof CommonResponse){
			response = (CommonResponse<Object>) arg0;
		}else {
			response .setData(arg0);
		}		
		return response;
	}
	/*判断这个响应是否拦截，
	 * 第一个参数 MethodParameter 根据方法去判断，
	 * 或者第二个参数根据类去判断
	 * */
	@Override
	public boolean supports(MethodParameter arg0,
			Class<? extends HttpMessageConverter<?>> arg1) {
		// TODO Auto-generated method stub
		//通过MethodParameter拿到这个类的声明，如果被IgnoreResponseAdvice注解表示 则返回false
		if(arg0.getDeclaringClass().isAnnotationPresent(
				IgnoreResponseAdvice.class)){
			return false;
		}
		//拿到方法的注解
		if(arg0.getMethod().isAnnotationPresent(
				IgnoreResponseAdvice.class)){
			return false;
		}
		return true;
	}

}
