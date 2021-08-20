package com.lyr.shirodemo.shiro;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.lyr.shirodemo.jwt.JwtToken;
import com.lyr.shirodemo.dao.PermissionDao;
import com.lyr.shirodemo.dao.RoleDao;
import com.lyr.shirodemo.dao.UserDao;
import com.lyr.shirodemo.entity.Role;
import com.lyr.shirodemo.entity.User;
import com.lyr.shirodemo.jwt.JwtUtil;
import com.lyr.shirodemo.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 自定义Realm (该类不需要加@Component)
 * <p>
 * Realm是用户的信息认证器和用户的权限认证器，我们需要自己来实现Realm来自定义的管理我们自己系统内部的权限规则。
 * <p>
 * Realm：域
 * 1、Shiro从Realm获取安全数据（如用户、角色、权限）
 * 2、也就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；
 * 3、也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权认证：给用户分配角色或者访问某些资源的权限
     * <p>
     * 什么时候调用：只有当需要检测用户权限的时候才会调用此方法，例如hasRole(),checkPermission之类的
     * 1、subject.hasRole();
     * 2、subject.checkPermission();
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        log.info("执行授权");

        if (null == principalCollection) {
            throw new AuthorizationException("Principals method argument cannot be null.");
        }

        // 拿到token
        String token = (String) principalCollection.getPrimaryPrincipal();

        long userId = (long)JwtUtil.parseTokenUid(token);
        User user = userDao.findUserById(userId);

        if (null == user) {
            return null;
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        List<Role> roleList = roleDao.findRolesByUserId(user.getId());

        Set<String> roleSet = new HashSet<>();
        List<Long> roleIds = new ArrayList<>();

        // 获取角色信息集合和角色id集合
        for (Role role : roleList) {
            roleSet.add(role.getRoleName());
            roleIds.add(role.getId());
        }

        // 放入角色信息
        authorizationInfo.setRoles(roleSet);

        // 放入权限信息
        LinkedHashSet<String> permissionsNameSet = permissionDao.findPermissionsByRoleId(roleIds);
        authorizationInfo.setStringPermissions(new HashSet<>(permissionsNameSet));

        log.info("授权信息"+authorizationInfo.getRoles()+" "+authorizationInfo.getStringPermissions());

        return authorizationInfo;
    }

    /**
     * 身份认证
     * <p>
     * 1、什么时候调用：登录的时候就会进行判断。具体看Controller层的login方法。
     * 2、this.getName():提供当前Realm的名字
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        log.info("执行身份认证");

        if(null==auth){
            log.info("AuthenticationToken为空，直接返回null");
            return null;
        }

        String token = (String) auth.getCredentials();
        long userId = (long)JwtUtil.parseTokenUid(token);

        User user = userDao.findUserById(userId);

        if (null == user) {
            log.info("身份认证失败");
            return null;
        } else {
            log.info("身份认证成功");
            return new SimpleAuthenticationInfo(token,token,"custom_realm");
        }
    }


}
