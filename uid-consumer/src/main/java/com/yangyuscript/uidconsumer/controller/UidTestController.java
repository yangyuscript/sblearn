package com.yangyuscript.uidconsumer.controller;

import com.yangyuscript.uidconsumer.service.UidGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UidTestController {

    @Autowired
    private UidGeneratorService uidGeneratorService;

    @GetMapping("/getUid")
    public String getUid(){
        return String.valueOf(uidGeneratorService.getUid());
    }
}
