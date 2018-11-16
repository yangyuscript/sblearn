package com.yangyuscript.springbootdubboserver.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yangyuscript.springbootdubboapi.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String str) {
        return str;
    }
}
