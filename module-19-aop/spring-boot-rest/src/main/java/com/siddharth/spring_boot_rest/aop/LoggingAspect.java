package com.siddharth.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // point_cut = execution(return_type class_name_with_package.method_name(arguments))
    // Advise(point_cut)
    @Before("execution(* com.siddharth.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.siddharth.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    // like finally
    @After("execution(* com.siddharth.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.siddharth.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    // like catch
    @AfterThrowing("execution(* com.siddharth.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.siddharth.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues " + jp.getSignature().getName());
    }

    // if success
    @AfterReturning("execution(* com.siddharth.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.siddharth.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
    }
}
