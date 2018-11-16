package com.yangyuscript.springbootdubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yangyuscript.springbootdubboapi.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Reference
    private DemoService demoService;

    @GetMapping("/hello")
    public String hello(){
        return demoService.hello("hello world");
    }
}
