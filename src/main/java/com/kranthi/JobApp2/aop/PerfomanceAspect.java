package com.kranthi.JobApp2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfomanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerfomanceAspect.class);

    @Around("execution(* com.kranthi.JobApp2.service.JobService.getJob(..)) && args(postId)")
    public Object valueHandling(ProceedingJoinPoint jp, String postId) throws Throwable {
        if(Integer.parseInt(postId)<0){
            System.out.println("value is negitive ");
            postId = String.valueOf(-1 * (Integer.parseInt(postId)));
        }

        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }

    @Around("execution(* com.kranthi.JobApp2.service.JobService.getJob(..)) ")
    public Object perfomance(ProceedingJoinPoint jp ) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();

        logger.info("The time taken is  : "  + (end-start) + "millies");
        return obj;
    }

}
