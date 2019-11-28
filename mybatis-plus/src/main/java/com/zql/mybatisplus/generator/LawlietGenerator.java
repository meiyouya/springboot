package com.zql.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class LawlietGenerator {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/mybatis-plus/src/main/java");  // 这里输出到本模块路径，也可定义到其它任意路径
        globalConfig.setAuthor("lawliet");
        globalConfig.setOpen(false);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://39.108.92.8:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("521xwl54zql@MYSQL");
        generator.setDataSource(dataSourceConfig);

        // 模板引擎,默认是Velocity，这里改用Freemarker
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);    // 表名生成策略，这里使用下划线自动转换为驼峰
        strategyConfig.setInclude("user","task");  // 设置要生成的表，默认是该数据库下所有的表
//        strategyConfig.setExclude("")     // 设置需要排除的表
        generator.setStrategy(strategyConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.zql.mybatisplus");     // 一般情况下只设置这一个参数即可
        generator.setPackageInfo(packageConfig);

        // 执行生成
        generator.execute();

    }
}
