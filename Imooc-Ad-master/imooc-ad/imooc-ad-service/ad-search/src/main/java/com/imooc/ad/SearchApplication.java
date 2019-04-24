package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients //使用feign访问其他的微服务
@EnableEurekaClient //开启发现为服务  就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient
@EnableHystrix  //断路器
@EnableCircuitBreaker//@EnableCircuitBreake可以开启Hystrix
@EnableDiscoveryClient //开启发现为服务 如果是其他的注册中心，那么推荐使用
@EnableHystrixDashboard //仪表盘 ：Hystrix Dashboard，它主要用来实时监控Hystrix的各项指标信息
@SpringBootApplication //Spring 主程序启动类
public class SearchApplication {

    public static void main(String[] args) {
    	try {
    		SpringApplication.run(SearchApplication.class, args);
		} catch (Exception e) {
			System.out.println("错误日志："+e);
		}
    	
    	
    }
}
