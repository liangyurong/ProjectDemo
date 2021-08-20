package com.lyr.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * SpringBoot自带日志功能
 */
@Aspect
@Component
public class WebAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.lyr.demo.controller..*.*(..))")
    public void webLog(){
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        logger.info("\n");
        logger.info("===================    API start："+joinPoint.getSignature().getName()+"    ===================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录下请求内容
        logger.info("请求的URL : " + request.getRequestURL().toString());
        logger.info("请求的类型 : " + request.getMethod());
        logger.info("请求的IP : " + request.getRemoteAddr());

        //参数
        logger.info("请求的参数列表 : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            logger.info("参数 :  "+paraName + "=" + request.getParameter(paraName));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        // 处理完请求，返回内容
        logger.info("返回参数 : " + ret);
        logger.info("===================    API end："+joinPoint.getSignature().getName()+"    ===================");
    }
}
