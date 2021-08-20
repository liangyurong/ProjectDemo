
## 项目说明

本项目用了两个功能来实现日志功能。

1. 使用自定义注解实现日志功能。

2. springboot自带的日志功能。

[自定义注解的学习链接](https://www.liaoxuefeng.com/wiki/1252599548343744/1265102803921888)

## 一、自定义注解

### 1.自定义注解是什么？本质上是什么？

### 2.为什么要用它？

原因1：对于springboot自带的注解，是以所有controller类中的方法为切面的，也就是规定死了。当我们不想某个接口打印出入参日志，就办不到。

原因2：当有多个模块，每个模块都有对应的controller，springboot自带的日志功能怎么实现切面？

### 3.使用的方法是什么？

使用了自定义注解。我这里自定义的注解是@CustomLog。

当接口需要打印日志，就在接口上加上自定义注解@CustomLog。下面是示例。

```java
@Controller
public class TestOther {
    @CustomLog("使用自定义注解")
    @ResponseBody
    @GetMapping("/getB")
    public String getB(){
        return "BBBBBBBBBBB";
    }
}
```

### 4.使用场景是什么？

自定义注解+拦截器

自定义注解+AOP



### 5.自定义注解什么时候会不生效？

## 二、注意点

1. 对自定义注解使用环绕通知，需要使用ProceedingJoinPoint。否则会获取不到返回的结果，也就是说，即使你的controller加上@ResponseBody，也会拿不到返回的结果。

```java
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info("\n");
        logger.info("你使用了自定义的@CustomLog注解");
        Object result = point.proceed();
        return result;
    }
```
## 三、收获

1. 尽量将代码结构区分清楚。比如一开始我是将两个方法的实现放在同一个类。后面发现太麻烦，就分为了两个类。

一个类只做一件事情。
