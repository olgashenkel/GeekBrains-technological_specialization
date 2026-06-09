package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        logger.info("Method called: {}", joinPoint.getSignature().getName());
        logger.info("Arguments: {}", joinPoint.getArgs().length);
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.service.*.*(..))", returning = "result")
    public void logAfterMethodCall(JoinPoint joinPoint, Object result) {
        logger.info("Method finished: {}", joinPoint.getSignature().getName());
        logger.info("Return value: {}", result);
    }
}
