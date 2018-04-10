package com.yuecheng.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.yuecheng.base" })
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class FeignServiceApplication {

    public static void main(String[] args) {
    	SpringApplication.run(FeignServiceApplication.class, args);
    }
}
