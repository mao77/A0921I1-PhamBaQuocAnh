package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBook {

//    Aspect -> Advice -> pointcut -> joinpoint
    @AfterReturning( "execution(public * com.codegym.service.BookService.*(..)))" )
    public void logBookService(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Class là: " + className + " Và medthod là: " + methodName);
    }

    @AfterThrowing( value = "execution(public * com.codegym.service.BookService.*(..)))"
            , throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Class là: " + className + " Và medthod là: " + methodName + " " + e.getMessage());
    }


}
