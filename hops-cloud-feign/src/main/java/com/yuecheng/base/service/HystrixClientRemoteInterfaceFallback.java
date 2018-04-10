package com.yuecheng.base.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HystrixClientRemoteInterfaceFallback implements HystrixClientRemoteInterface {  
    @Override  
    public String getTeamInfo(@RequestParam("teamName") String teamName) {  
        return "获取" + teamName + "失败。";  
    }  
}
