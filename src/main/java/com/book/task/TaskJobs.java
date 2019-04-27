package com.book.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 一点点
 * @Date: 2018/10/8 22:34
 * @Version 1.0
 */
public class TaskJobs implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }



   /* @Autowired
    private DemoService service;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        service.server("1");
    }*/
}
