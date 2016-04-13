package com.lingtong.quartztools.dao.imp;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lingtong.quartztools.dao.QuartztoolsInterface;
import com.lingtong.test.SimpleExample;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartztoolsInterfaceImp implements QuartztoolsInterface {
	private final static int QUARTZ_HOURS_TYPE = 3;
	private final static int QUARTZ_SECONDS_TYPE = 1;
	private final static int QUARTZ_MINUTES_TYPE = 2;
	private SchedulerFactory schedulerFactory;
	private Scheduler scheduler;
	Logger log = LoggerFactory.getLogger(QuartztoolsInterfaceImp.class);
	public QuartztoolsInterfaceImp(){
		try {
			schedulerFactory = new StdSchedulerFactory();
			scheduler =schedulerFactory.getScheduler();
			 //判断是否有作业在启动，如果没有就启动
			if (scheduler.isShutdown()) {
				//System.out.println("scheduler.start()");
				log.debug("scheduler.start(),开始启动~~~~~~~~~~~");
				scheduler.start();
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加作业
	 * 
	 * @param jobName
	 *            名称
	 * @param group
	 *            组
	 * @param map
	 *            参数
	 * @param intervalTime
	 *            间隔时间
	 * @param count
	 *            执行次数
	 * @param type
	 *            间隔时间类型
	 * @param startDate
	 *            执行开始时间
	 * @param jobClassName
	 *            执行的Class名字
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean addJob(String jobName, String group,
			Map<String, Object> parameters, int intervalTime, int count,
			int type, Date startDate, String jobClassName) throws Exception {
		Trigger trigger = null;
		if (type == QuartztoolsInterfaceImp.QUARTZ_SECONDS_TYPE) {
			trigger = newTrigger()
					.startAt(startDate)
					.withIdentity(jobName, group)
					.withSchedule(
							simpleSchedule()
									.withIntervalInSeconds(intervalTime)
									.withRepeatCount(count)).build();
		} else if (type == QuartztoolsInterfaceImp.QUARTZ_MINUTES_TYPE) {
			trigger = newTrigger()
					.startAt(startDate)
					.withIdentity(jobName, group)
					.withSchedule(
							simpleSchedule()
									.withIntervalInMinutes(intervalTime)
									.withRepeatCount(count)).build();
		} else if (type == QuartztoolsInterfaceImp.QUARTZ_HOURS_TYPE) {
			trigger = newTrigger()
					.startAt(startDate)
					.withIdentity(jobName, group)
					.withSchedule(
							simpleSchedule().withIntervalInHours(intervalTime)
									.withRepeatCount(count)).build();
		}
		JobDetail job = JobBuilder
				.newJob((Class<? extends Job>) Class.forName(jobClassName))
				.withIdentity(jobName, group).build();
		JobDataMap map = job.getJobDataMap();
		for (Entry<String, Object> entry : parameters.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		schedulerFactory.getScheduler().scheduleJob(job, trigger);
		return true;
	}

	@Override
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,
			Date startTime, Date endTime) throws Exception {
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity(jobName, group)
				.withSchedule(CronScheduleBuilder.cronSchedule(time))
				.startAt(startTime).endAt(endTime).build();
		@SuppressWarnings("unchecked")
		JobDetail job = JobBuilder
				.newJob((Class<? extends Job>) Class.forName(jobClassName))
				.withIdentity(jobName, group).build();
		JobDataMap map = job.getJobDataMap();
		for (Entry<String, Object> entry : parameters.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		schedulerFactory.getScheduler().scheduleJob(job, cronTrigger);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,
			Date startTime) throws Exception {
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity(jobName, group)
				.withSchedule(CronScheduleBuilder.cronSchedule(time))
				.startAt(startTime).build();
		JobDetail job = JobBuilder
				.newJob((Class<? extends Job>) Class.forName(jobClassName))
				.withIdentity(jobName, group).build();
		JobDataMap map = job.getJobDataMap();
		for (Entry<String, Object> entry : parameters.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		schedulerFactory.getScheduler().scheduleJob(job, cronTrigger);		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Boolean addJob(String jobName, String jobGroupName, Map<String, Object> parameters,
			String triggerName, String triggerGroupName,
			String jobClassName, String runTime) throws SchedulerException,
			ParseException {
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity(jobName, jobGroupName)
				.withSchedule(CronScheduleBuilder.cronSchedule(runTime)) .startNow()
				.build();
		
		JobDetail job;
		try {
			System.out.println("Class.forName(jobClassName):"+Class.forName(jobClassName));
			job = JobBuilder.newJob((Class<? extends Job>) Class.forName(jobClassName))
					.withIdentity(jobName, jobGroupName).build();
			JobDataMap map = job.getJobDataMap();
			for (Entry<String, Object> entry : parameters.entrySet()) {
				map.put(entry.getKey(), entry.getValue());
			}
			schedulerFactory.getScheduler().scheduleJob(job, cronTrigger);
			schedulerFactory.getScheduler().start();
			//System.out.println(schedulerFactory.getScheduler().isShutdown());
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

		@Override
		public boolean deleteJob(String jobName, String group) throws Exception {
			return schedulerFactory.getScheduler().deleteJob(
					JobKey.jobKey(jobName, group));
		}

		@Override
		public boolean deleteJob(String jobName) throws Exception {
			return schedulerFactory.getScheduler()
					.deleteJob(JobKey.jobKey(jobName));

		}

		public Date upadteJobTime(String jobName, String group, String time)
				throws Exception {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, group);
			CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(
					jobName, group).withSchedule(
					CronScheduleBuilder.cronSchedule(time)).build();
			return scheduler.rescheduleJob(triggerKey, cronTrigger);
		}

		@Override
		public void pauseJob(String jobName, String group) throws Exception {

			schedulerFactory.getScheduler().pauseJob(JobKey.jobKey(jobName, group));
		}

		@Override
		public void pauseJob(String jobName) throws Exception {
			schedulerFactory.getScheduler().pauseJob(JobKey.jobKey(jobName));

		}

		@Override
		public void resumeJob(String jobName, String group) throws Exception {
			schedulerFactory.getScheduler()
					.resumeJob(JobKey.jobKey(jobName, group));
		}

		@Override
		public void resumeJob(String jobName) throws Exception {
			schedulerFactory.getScheduler().resumeJob(JobKey.jobKey(jobName));

		}

}
