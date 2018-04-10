package com.yuecheng.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuecheng.base.service.HystrixClientRemoteInterface;

@RestController
public class HiController {

    @Autowired  
    private HystrixClientRemoteInterface hystrixClientRemoteInterface; 
     
    @GetMapping("/getTeamInfo")
    public String getTeamInfo(@RequestParam("teamName") String teamName){  
        return hystrixClientRemoteInterface.getTeamInfo(teamName);  
    }  
}