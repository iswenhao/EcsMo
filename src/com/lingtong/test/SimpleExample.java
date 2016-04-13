package com.lingtong.test;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.support.CronTrigger;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
public class SimpleExample {
	 public void run() throws Exception {
		  Logger log = LoggerFactory.getLogger(SimpleExample.class);
		    log.info("------- Initializing ----------------------");
		    SchedulerFactory sf = new StdSchedulerFactory();
		    Scheduler sched = sf.getScheduler();

		    log.info("------- Initialization Complete -----------");
		    Date runTime = evenMinuteDate(new Date());

		    log.info("------- Scheduling Job  -------------------"+runTime);
		    
		    JobDetail job = newJob(HelloQuartzJob.class).withIdentity("job1", "group1").build();
		    
		    
		 //   Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		    
//	      使用cornTrigger规则  每天10点42分  
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")  
            .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))  
            .startNow().build();   
            
		    sched.scheduleJob(job, trigger);
		    log.info(job.getKey() + " will run at: " + runTime);
		    sched.start();

		    log.info("------- Started Scheduler -----------------");
		    log.info("------- Waiting 65 seconds... -------------");
		    try {
		      // wait 65 seconds to show job
		      Thread.sleep(65L * 1000L);
		      // executing...
		    } catch (Exception e) {
		      //
		    }
		    log.info("------- Shutting Down ---------------------");
		    sched.shutdown(true);
		    log.info("------- Shutdown Complete -----------------");
		    
	 }
	public static void main(String[] args) {
		  SimpleExample example = new SimpleExample();
		    try {
				example.run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
