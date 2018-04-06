package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController2 {
//    @RequestMapping(value = {"/hello3","/hello4"},method = RequestMethod.GET)
    @GetMapping(value = "hello3")
    public String say3(){
        return "index";
    }
}
