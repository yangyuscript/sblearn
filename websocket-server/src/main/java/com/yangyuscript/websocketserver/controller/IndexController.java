package com.yangyuscript.websocketserver.controller;

import com.yangyuscript.websocketserver.utils.MessageEventHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping(value="index")
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("/index");
        mv.addObject("title","yangyuscript");
        //MessageEventHandler.sendBuyLogEvent();
        return mv;
    }
}
