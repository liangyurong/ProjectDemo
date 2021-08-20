package com.lyr.shirodemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyr.shirodemo.entity.User;
import com.lyr.shirodemo.service.LoginUserInfoService;
import com.lyr.shirodemo.jwt.JwtUtil;
import com.lyr.shirodemo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private LoginUserInfoService service;

    /**
     * 登录
     *
     * 获取username和password，进行身份认证。
     */
    @PostMapping("/login")
    public Result login(@RequestBody JSONObject json){

        Result result = new Result();

        String username = json.getString("username");
        String password = json.getString("password");

        User user = service.getLoginUserInfoByUsernameAndPassword(username, password);

        if(null==user){
            return result.putCode(1).putMsg("login fail").putData(null);
        }

        String loginToken = JwtUtil.createToken(user);

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("token",loginToken);

        return result.putCode(0).putMsg("login success").putData(map);

    }

    @GetMapping("/getUserInfoById")
    public Result getUserInfoById(@RequestParam("id")Long id){
        Result result = new Result();
        User userInfo = service.getLoginUserInfoById(id);
        if(null!=userInfo){
            return result.putCode(0).putMsg("获取user信息成功").putData(userInfo);
        }else {
            return result.putCode(1).putMsg("获取user信息失败").putData(null);
        }
    }

    /**
     * 要求角色是user,vip,admin才能访问
     * logical = Logical.OR满足其中一个即可。（不加上or的话默认需要满足全部角色）
     * 补充另外一个用法：logical = Logical.AND
     */
    @RequiresRoles(value={"admin","vip","user"},logical = Logical.OR)
    @GetMapping("/index")
    public String index(){
       return "访问index主页";
    }

    /**
     * 要求角色是admin才能访问
     */
    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin(){
        return "访问damin页面";
    }

    /**
     * 注解@RequiresPermissions里面写user:select，是因为在数据库中设置了权限的名称是这个。
     */
    @RequiresPermissions("user:select")
    @GetMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response){
        return "select";
    }

    @RequiresPermissions("user:add")
    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @RequiresPermissions("user:update")
    @GetMapping("/update")
    public String update(){
        return "update";
    }

    @RequiresPermissions("user:delete")
    @GetMapping("/delete")
    public String delete(){
       return "delete";
    }

    /**
     * 因为被全局异常类GlobalExceptionHandler捕获，并不会跳转到这里
     */
    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "未授权";
    }

}
