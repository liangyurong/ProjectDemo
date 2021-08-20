package com.lyr.shirodemo.jwt;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截鉴权
 *
 * 所有的请求都会先经过 Filter，所以我们继承官方的 BasicHttpAuthenticationFilter ，并且重写鉴权的方法。
 *
 * 代码的执行流程 preHandle -> isAccessAllowed -> isLoginAttempt -> executeLogin 。
 */
@Component("jwtFilter")
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 请求头授权标示
     */
    private final static String AUTHORIZATION = "Authorization";

    /**
     * 1、对跨域提供支持 (在使用shiro和vue的过程中，会发出option请求，会被拦截，因此要进行放行)
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // 标识允许哪个域到请求，直接修改成请求头的域
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        // 标识允许的请求方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        // 响应首部 Access-Control-Allow-Headers 用于 preflight request （预检请求）中，列出了将会在正式请求的 Access-Control-Expose-Headers 字段中出现的首部信息。修改为请求首部
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        //给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }


    /**
     * 2、isAccessAllowed
     *
     * 一般在isAccessAllowed中执行认证逻辑
     *
     * 这里我们详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     *
     * isAccessAllowed返回true之后的操作是什么？
     *
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("测试请求是否被允许");
        if (isLoginAttempt(request, response)) {
            // 进入if语句，说明请求头有token
            try {
                executeLogin(request, response);
                log.info("请求被允许");
            } catch (Exception e) {
                log.info("isAccessAllowed方法中出现异常，异常信息是-》"+e.toString());
                unauthorized(response);
                return false;
            }
        }
        return true;
    }

    /**
     * 3、判断用户是否想要登入。
     *
     * 检测header里面是否包含Authorization字段即可。没有token就返回false不去验证身份信息，而是直接去登陆
     *
     * token为空，返回false.
     *
     * 返回false之后，执行的操作是什么？
     *
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(AUTHORIZATION);
        return token != null;
    }

    /**
     * 进行登录认证处理
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        log.info("进行登录认证处理。认证成功返回true，否则抛出异常");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 从请求头中获取token
        String token = httpServletRequest.getHeader(AUTHORIZATION);

        // 判断token是否合法
        boolean verify = JwtUtil.isVerify(token);
        if(!verify){
            throw new Exception("token不合法，不允许登录");
        }

        // 判断token是否过期
        if(JwtUtil.tokenIsExpired(token)){
            throw new Exception("token已过期，请重新登录");
        }

        // 构建token
        JwtToken jwtToken = new JwtToken(token);

        // 提交给realm进行登入，如果错误他会抛出异常并被捕获(此时会去到CustomRealm类的doGetAuthenticationInfo()方法)
        getSubject(request, response).login(jwtToken);

        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 重写该方法避免循环调用doGetAuthenticationInfo方法
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        this.sendChallenge(request, response);
        return false;
    }


    /**
     * 认证失败 跳转到 /unauthorized
     */
    private void unauthorized(ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/unauthorized");
        } catch (IOException e) {
            log.error("认证失败，跳转到 /unauthorized"+e.getMessage());
        }
    }



}
