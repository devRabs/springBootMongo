package com.example.home.MongoDB.Spring.Boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution (* com.example.home.MongoDB.Spring.Boot.service.*.*(..))")
    public void aroundAdviceForAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        logger.info("Before advise method execution :" + proceedingJoinPoint.getSignature().getName());
        proceedingJoinPoint.proceed();
        logger.info("After advise method execution : " + proceedingJoinPoint.getSignature().getName());
    }
}
