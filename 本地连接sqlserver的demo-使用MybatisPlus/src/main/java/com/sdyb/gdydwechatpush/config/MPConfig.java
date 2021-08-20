package com.sdyb.gdydwechatpush.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {

    /**
     * 配置分页插件。配置完之后，就可以直接使用。在TestPagination.java中进行测试。
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁插件。配置了这个Bean，就会自动启动乐观锁机制。（但现在还是不知道具体的使用场景）
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

}
