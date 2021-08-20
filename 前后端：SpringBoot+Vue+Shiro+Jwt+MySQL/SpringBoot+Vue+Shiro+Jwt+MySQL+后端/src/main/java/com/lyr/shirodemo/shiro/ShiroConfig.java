package com.lyr.shirodemo.shiro;

import com.lyr.shirodemo.jwt.JwtFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 1、拦截器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager manager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        // 给拦截器设置安全管理器
        filterFactoryBean.setSecurityManager(manager);

        // 添加自己的过滤器并且取名为jwtFilter
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwtFilter", new JwtFilter());
        filterFactoryBean.setFilters(filters);

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 所有请求通过我们自己的JWT Filter
        filterChainDefinitionMap.put("/**", "jwtFilter");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return filterFactoryBean;
    }

    /**
     * 2、创建安全管理器
     *
     * 不能使用SecurityManager,在web环境需要使用 DefaultWebSecurityManager
     * 权限管理，这个类组合了登录，登出，权限，session的处理，是个比较重要的类。
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm")Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 设置自定义的realm
        securityManager.setRealm(realm);

        // 关闭shiro自带的session 详情查看：http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    /**
     * 3、创建自定义Realm
     */
    @Bean("realm")
    public Realm realm() {
        return new CustomRealm();
    }

    /**
     * 开启shiro注解
     *
     * 为什么要用强制使用cglib？
     *   1.因为很多时候我们并不会特意为某个bean去写一个接口，再去实现，这种情况下如果用默认的jdk动态代理，则一旦有多个aop代理，比如既有shiro注解代理，又有事务切片或注解代理，这种时候去注入这个bean便会报错
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     *  注解@RequiresPermissions，是DefaultAdvisorAutoProxyCreator这个bean设置之后才会生效的，所以在这个地方设置true。
     *
     *  说明：在shiro结合springboot，jwt之后，如果没有该方法，则请求的时候会报错404
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }




}
