package com.zql.mybatisplus.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.incrementer.IKeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement    // 事务管理
@MapperScan("com.zql.mybatisplus.mapper*")  // 扫描mapper
public class MybatisPlusConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * Sequence主键
     * @return
     */
//    @Bean
//    public GlobalConfiguration globalConfiguration() {
//        GlobalConfiguration configuration = new GlobalConfiguration();
//        configuration.setKeyGenerator((IKeyGenerator) new OracleKeyGenerator());
//        return configuration;
//    }
}
