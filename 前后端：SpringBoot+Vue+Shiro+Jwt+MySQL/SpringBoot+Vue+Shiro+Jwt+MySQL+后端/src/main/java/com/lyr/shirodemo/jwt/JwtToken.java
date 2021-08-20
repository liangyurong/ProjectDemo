package com.lyr.shirodemo.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JWTToken 差不多就是 Shiro 用户名密码的载体。
 * 因为我们是前后端分离，服务器无需保存用户状态，所以不需要 RememberMe 这类功能，我们简单的实现下 AuthenticationToken 接口即可。
 * 因为 token 自己已经包含了用户名等信息，所以这里我就只是弄了一个字段token。
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
