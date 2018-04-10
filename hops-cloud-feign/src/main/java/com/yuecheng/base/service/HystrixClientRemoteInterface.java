package com.yuecheng.base.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="hops-service-A", fallback = HystrixClientRemoteInterfaceFallback.class)  
public interface HystrixClientRemoteInterface {  
    @GetMapping("/getTeamInfo")  
    public String getTeamInfo(@RequestParam("teamName") String teamName);  
}  
