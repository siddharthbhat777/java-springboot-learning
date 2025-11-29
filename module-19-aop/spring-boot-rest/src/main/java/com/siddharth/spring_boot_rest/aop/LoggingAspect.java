package com.siddharth.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
        LOGGER.info("Method called" + jp.getSignature().getName());
    }
}
