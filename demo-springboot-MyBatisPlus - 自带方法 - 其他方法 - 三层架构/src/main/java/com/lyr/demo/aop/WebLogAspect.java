package com.lyr.demo.aop;

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

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.lyr.demo.controller..*.*(..))")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容

        //logger.info("WebLogAspect.doBefore()");
        logger.info("///////////// API start："+joinPoint.getSignature().getName()+"/////////////");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        //请求的url
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("请求类型 : " + request.getMethod());
        logger.info("请求IP : " + request.getRemoteAddr());
        // 包名：joinPoint.getSignature().getDeclaringTypeName()+接口名字：joinPoint.getSignature().getName()
        //logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("参数 : ");
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            //System.out.println(paraName + ": " + request.getParameter(paraName));
            logger.info(paraName + ": " + request.getParameter(paraName));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        // 处理完请求，返回内容
        //logger.info("WebLogAspect.doAfterReturning()");
        logger.info("返回参数 : " + ret);
        logger.info("//////// API end："+joinPoint.getSignature().getName()+"/////////");
        logger.info("                                                                  ");
    }
}
