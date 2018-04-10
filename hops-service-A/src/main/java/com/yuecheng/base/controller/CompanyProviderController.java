package com.yuecheng.base.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyProviderController {  
    @Value("${server.port}")
    String port;
    @GetMapping("/getTeamInfo")
    public String getTeamInfo(@RequestParam("teamName") String teamName){  
        // 返回团队信息。  
        return "provider 查询" + teamName + "团队信息"+"来自prot是"+port+"的服务提供者";  
    }  
}  
