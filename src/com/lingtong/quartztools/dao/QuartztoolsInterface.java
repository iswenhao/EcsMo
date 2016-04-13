package com.lingtong.quartztools.dao;

import java.util.Date;
import java.util.Map;

import org.quartz.Job;
import org.quartz.SchedulerException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface QuartztoolsInterface {

	 /**
	    * 添加一个定时任务 
	    * @param jobName 任务名 
	    * @param jobGroupName 任务组名 
	    * @param parameters   参数
	    * @param triggerName  触发器名 
	    * @param triggerGroupName 触发器组名 
	    * @param jobClassName     JOB任务 
	    * @param time    时间设置，参考quartz说明文档 
	    * @return  成功或者失败
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	public Boolean addJob(String jobName,String jobGroupName, Map<String, Object> parameters,String triggerName,String triggerGroupName,String jobClassName,String time)throws SchedulerException, ParseException;

	/**
	 * 添加作业 间隔多少时间执行一次，一共执行多少次
	 * @param jobName 名称
	 * @param group	  组
	 * @param map   参数
	 * @param intervalTime 间隔时间
	 * @param count 执行次数
	 * @param type 间隔时间类型
	 * @param startDate 执行开始时间
	 * @param jobClassName 执行的Class名字
	 * @return
	 * @throws Exception
	 */
	public Boolean addJob(String jobName, String group,
			Map<String, Object> parameters, int intervalTime, int count,
			int type, Date startDate,String jobClassName) throws Exception;
	
	/**
	 *  添加作业 根据规则执行，需要定义开始时间和结束的时间
	 * @param jobName JOB名
	 * @param group    组名
	 * @param parameters 传参数
	 * @param time   执行时间规则
	 * @param jobClassName 直接的calss
	 * @param startTime 执行开始时间
	 * @param endTime  执行结束时间
	 * @throws Exception
	 */
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,Date startTime,Date endTime) throws Exception;
	/**
	 *  添加作业 根据规则执行，需要定义开始时间和没有结束的时间
	 * @param jobName JOB名
	 * @param group    组名
	 * @param parameters 传参数
	 * @param time   执行时间规则
	 * @param jobClassName 直接的calss
	 * @param startTime 执行开始时间
	 * @throws Exception
	 */
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,Date startTime) throws Exception;
	/**
	 * 删除作业
	 * @param jobName 名称
	 * @param group	  组
	 * @throws Exception 
	 */
	public boolean deleteJob(String jobName,String group) throws Exception;
	
	/**
	 * 删除作业
	 * @param jobName 名称
	 * @throws Exception 
	 */
	public boolean deleteJob(String jobName) throws Exception;
	/**
	 * 修改作业
	 * @param jobName 名称
	 * @param group 组
	 * @param time	执行规则
	 * @return
	 * @throws Exception
	 */
	public Date upadteJobTime(String jobName, String group,String time) throws Exception;
	
	/**
	 * 暂停作业
	 * @param jobName 名称
	 * @param group	  组
	 * @throws Exception 
	 */
	public void pauseJob(String jobName,String group) throws Exception;
	
	/**
	 * 暂停作业
	 * @param jobName 名称
	 * @throws Exception 
	 */
	public void pauseJob(String jobName) throws Exception;
	
	
	/**
	 * 开启作业
	 * @param jobName 名称
	 * @param group	  组
	 * @throws Exception 
	 */
	public void resumeJob(String jobName,String group) throws Exception;
	
	/**
	 * 开启作业
	 * @param jobName 名称
	 * @throws Exception 
	 */
	public void resumeJob(String jobName) throws Exception;


	
}
