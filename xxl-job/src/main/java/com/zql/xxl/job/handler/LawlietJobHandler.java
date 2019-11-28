package com.zql.xxl.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;

/**
 * @author lawliet.L
 */
@JobHandler(value = "lawliet")
@Component
public class LawlietJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("Lawliet is running");
        System.out.println("111111");
        return SUCCESS;
    }
}
