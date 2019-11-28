package com.zql.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask1 {

    private int count = 0;

    @Scheduled(cron = "*/2 * * * * ?")  // 2秒运行一次
    private void process() {
        System.out.println("scheduler task running " + (count++));
    }
}
