package com.kranthi.JobApp2.aop;

import com.kranthi.JobApp2.service.JobService;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.kranthi.JobApp2.service.JobService.getJob(..))")
    public void LogBefore(JoinPoint jp){
        logger.info("The method called is " + jp.getSignature().getName());


    }
    @After("execution(* com.kranthi.JobApp2.service.JobService.getJob(..))")
    public void LogAfter(JoinPoint jp){
        logger.info("Method executed sucessfully " + jp.getSignature().getName());


    }
    @AfterReturning("execution(* com.kranthi.JobApp2.service.JobService.getJob(..))")
    public void LogAfterReturn(JoinPoint jp){
        logger.info("The method called after returning " + jp.getSignature().getName());


    }

    @AfterThrowing("execution(* com.kranthi.JobApp2.service.JobService.getJob(..))")
    public void LogAfterThrowing(JoinPoint jp){
        logger.info("The method called after crashing " + jp.getSignature().getName());


    }
}
