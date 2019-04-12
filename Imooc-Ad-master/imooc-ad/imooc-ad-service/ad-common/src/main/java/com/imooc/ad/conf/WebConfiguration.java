package com.imooc.ad.conf;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
	
	// 这个类 自定义消息转换器
	//   参数1 表示多个http的转换器
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		//清空converters消息转换器
		converters.clear();
		//将java对象转换成json对象
		converters.add(new MappingJackson2HttpMessageConverter());
		
	}

	
}
