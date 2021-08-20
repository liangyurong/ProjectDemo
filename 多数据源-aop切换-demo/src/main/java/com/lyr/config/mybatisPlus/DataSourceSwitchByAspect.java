package com.lyr.config.mybatisPlus;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP实现的数据源切换
 * @Order设置的足够小是为了让他先执行
 */
@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceSwitchByAspect {

    @Pointcut("execution(* com.lyr.dao.db1..*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.lyr.dao.db2..*.*(..))")
    private void db2Aspect() {
    }

    @Pointcut("execution(* com.lyr.dao.db3..*.*(..))")
    private void db3Aspect() {
    }

    @Before("db1Aspect()")
    public void db1() {
        log.info("切换到数据库db1...");
        DbContextHolder.setDbType(DBTypeEnum.db1);

    }

    @Before("db2Aspect()")
    public void db2() {
        log.info("切换到数据库db2...");
        DbContextHolder.setDbType(DBTypeEnum.db2);
    }

    @Before("db3Aspect()")
    public void db3() {
        log.info("切换到数据库db3...");
        DbContextHolder.setDbType(DBTypeEnum.db3);
    }

}

