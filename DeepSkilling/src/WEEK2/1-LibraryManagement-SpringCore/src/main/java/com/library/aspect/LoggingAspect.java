package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * LoggingAspect - cross-cutting logging concern.
 *
 * Exercise 3: @Around advice logs the execution time of service methods.
 * Exercise 8: @Before and @After advice log before/after method execution.
 *
 * The aspect is registered and AspectJ auto-proxying is enabled in
 * applicationContext.xml (and applicationContext-annotation.xml).
 */
@Aspect
public class LoggingAspect {

    /** Exercise 8: log before any method in the service package executes. */
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore() {
        System.out.println("[AOP][BEFORE] A service method is about to execute.");
    }

    /** Exercise 8: log after any service method finishes. */
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter() {
        System.out.println("[AOP][AFTER] A service method finished executing.");
    }

    /** Exercise 3: measure and log method execution time. */
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("[AOP][TIME] " + joinPoint.getSignature()
                + " executed in " + elapsed + " ms");
        return result;
    }
}
