package com.zql.quartz.config;

import com.zql.quartz.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lawliet.L
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(HelloJob.class).withIdentity("c").storeDurably().build();
    }

    @Bean
    public Trigger trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("helloJob")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
