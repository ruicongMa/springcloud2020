package com.markzoe.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Mark
 * @date 2021/9/7 14:09
 */
@Aspect
@Component
public class LogAspject {

    @Pointcut("execution(* com.markzoe.service..*.*(..))")
    public void myPoint() {
    }

    @Before("myPoint()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法开始执行，参数是：" + Arrays.asList(args));
    }

}
