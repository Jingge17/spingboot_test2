package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= (Logger) LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.HelloController.say(..))")
    public void log(){
    }

    @Before("log()")
    public void log1(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("meth={}",request.getMethod());
        logger.info("class={}",joinPoint.getSignature().getDeclaringTypeName());
    }
    @After("log()")
    public void log2(){
        logger.info("2222222222");
        System.out.print("2222222222");
    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void log3(Object object){
        logger.info("response={}",object);
    }
}
