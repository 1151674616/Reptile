package com.imooc.ad.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		// TODO 计算响应时间
		
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Long startTime = (Long) context.get("startTime");
		String url = request.getRequestURI();
		long duration = System.currentTimeMillis() - startTime;
		log.info("url: "+url+" ,duration: "+duration/100+"ms");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.POST_TYPE;
	}

}
