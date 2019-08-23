package com.example.d1;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 统一日志处理
 */
@Aspect
@Slf4j
@Component
public class GlobalLogHandler {

    @Around(value = "execution(* com.example.d1.*Controller..*(..))")
    public Object logHandle(ProceedingJoinPoint point) throws Throwable {
        String name = point.getSignature().getName();
        String kind = point.getKind();
        log.info("执行了{}方法，kind是{}",name,kind);
        Object result = point.proceed(point.getArgs());
        return  result;
    }

    @AfterReturning(value = "@annotation(com.example.d1.Log)", returning = "result")
    public void logHandle2(JoinPoint point, Object result) {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        String value = method.getAnnotation(Log.class).value();
        String strtime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        log.info("我在{}{}",strtime,value);
    }
}
