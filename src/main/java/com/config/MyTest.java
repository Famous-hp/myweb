package com.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/*
 * 定时任务Job
 */

public class MyTest implements Job {
    private ServletContext application;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
