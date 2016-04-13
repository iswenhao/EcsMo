package com.lingtong.jobPool;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob01 implements Job {
	private static Logger logger = LoggerFactory.getLogger(TestJob01.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		 SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    Date d = new Date();  
		    String returnstr = DateFormat.format(d);   
		   // Class<? extends JobDetail> jobName = context.getJobDetail().getClass();
		    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		
		    String strData = dataMap.getString("jobname");
		    logger.debug("***************TestJob01,按照执行次数间隔时间执行JOB作业-没有停止时间################"+strData); 
		System.out.println("#############JOB 已经执行:"+returnstr+strData);
	}

}
