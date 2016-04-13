package com.lingtong.test;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloQuartzJob implements Job {
	   private static Logger _log = LoggerFactory.getLogger(HelloQuartzJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.info("Hello, Quartz! - executing its JOB at "+ 
		            new Date() + " by " + context.getTrigger().getCalendarName());
	}

}
