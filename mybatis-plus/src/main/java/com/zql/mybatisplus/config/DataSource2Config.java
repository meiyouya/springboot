//package com.zql.mybatisplus.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.zql.mybatisplus.mapper.db2", sqlSessionTemplateRef = "db2SqlSessionTemplate")
//public class DataSource2Config {
//
//    @Bean(name = "db2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSource db2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2SqlSessionFactory")
//    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/**/*.xml"));
//        return factoryBean.getObject();
//    }
//}
