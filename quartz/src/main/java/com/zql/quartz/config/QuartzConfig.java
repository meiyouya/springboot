package com.zql.quartz.config;

import org.quartz.Scheduler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lawliet.L
 */
@Component
public class QuartzConfig {

    @Resource
    private Scheduler scheduler;

    
}
