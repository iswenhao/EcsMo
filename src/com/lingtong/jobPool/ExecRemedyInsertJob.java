package com.lingtong.jobPool;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecRemedyInsertJob implements Job {
	private static Logger logger = LoggerFactory.getLogger(ExecRemedyInsertJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// TODO Auto-generated method stub
		 SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    Date d = new Date();  
		    String returnstr = DateFormat.format(d);   
		    logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%ExecRemedyInsertJob,���չ���ִ��JOB��ҵ-û��ֹͣʱ��################"); 
		System.out.println("#############JOB �Ѿ�ִ��:"+returnstr);
	}

}
