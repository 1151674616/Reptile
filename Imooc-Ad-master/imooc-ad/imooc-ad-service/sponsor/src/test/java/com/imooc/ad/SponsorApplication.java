package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //调用其他的微服务  这里只为了监控
@EnableCircuitBreaker //断路器
@EnableEurekaClient //能调用其他的微服务
@SpringBootApplication
public class SponsorApplication {
	public static void main(String[] args) {
		SpringApplication.run(SponsorApplication.class, args);
	}
}
