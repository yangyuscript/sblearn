package com.yangyuscript.springbootdubboserver;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringbootDubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServerApplication.class, args);
    }
}
