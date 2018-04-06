package com.imooc.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
@ExceptionHandler
@ResponseBody
    public String Handle(Exception e){
        return "err";
    }
}
