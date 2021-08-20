package com.lyr.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author lyr
 */
@Target(ElementType.METHOD) //定义该注解作用于方法上
@Retention(RetentionPolicy.RUNTIME) //定义为运行时使用该注解
@Documented //注解是否会包含在JavaDoc中
public @interface CustomLog {
    String value() default "";
}
