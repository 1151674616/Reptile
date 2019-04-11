package com.imooc.ad.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		// TODO 记录请求时间
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.set("startTime", System.currentTimeMillis());
		
		return null;
	}
/*
 * 是否执行，true 执行 ;false 不执行
 * */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	/*
	 * 定义过滤器执行顺序 数组越小 顺序越高 越早执行
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 *定义过滤器类型 
	 * */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

}
