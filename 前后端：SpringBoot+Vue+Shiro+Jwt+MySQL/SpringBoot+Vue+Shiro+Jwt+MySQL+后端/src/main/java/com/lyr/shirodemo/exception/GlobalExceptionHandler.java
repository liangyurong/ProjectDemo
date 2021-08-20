package com.lyr.shirodemo.exception;

import com.lyr.shirodemo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 405
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.info("405!"+e.toString());
        Result result = new Result();
        return result.putCode(1).putMsg("405!"+e.toString()).putData(null);
    }

    /**
     * 访问权限不足
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Result UnauthorizedExceptionHandler(UnauthorizedException e) {
        log.info("权限不足,拒绝访问！");
        Result result = new Result();
        return result.putCode(1).putMsg("权限不足,拒绝访问！").putData(null);
    }

    /**
     * 最大的一个异常类
     */
    @ExceptionHandler(Exception.class) //处理访问方法时权限不足问题
    public Result exceptionHandler(Exception e) {
        log.info("出现异常："+e.toString());
        Result result = new Result();
        return result.putCode(1).putMsg("出现异常："+e.toString()).putData(null);
    }
}
