package com.yuecheng.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = { "com.yuecheng.base" })
@EnableEurekaClient
@RestController
public class ServiceAApplication {
	
	//作为eureka的client测试
    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
	
	//作为config的client测试
  @Value("${database.version}")
  String source;
  @GetMapping("/config")
  public String config(@RequestParam String name) {
      return "hi "+name+",i am from version:" +source;
  }
	
    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }
}
