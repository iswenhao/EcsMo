package com.lingtong.po;

import java.util.Date;

public class JobConfig {
	private static int jobid ;//jobID
	private static String jobname;//Job名字
	private static String triggerName; //触发器名 
	private static String groupname;//组名字
	private static String description;//描述
	private static Date createtime;//创建时间
	private static Date modifytime;//修改时间
	private static String status;//状态
	private static Date starttime;//开始时间
	private static String schedule;//执行的规则
	private static String jobclassname;//CLASS名字
	private static Date stoptime;//停止的时间
	private static int execnum;//执行的次数
	private static int intervaltime;//执行间隔时间
	private static int timetype ;//间隔时间类型
	private static String operationtype;//操作类型
	public static int getJobid() {
		return jobid;
	}
	
	public static int getTimetype() {
		return timetype;
	}

	public static void setTimetype(int timetype) {
		JobConfig.timetype = timetype;
	}

	public static String getTriggerName() {
		return triggerName;
	}

	public static void setTriggerName(String triggerName) {
		JobConfig.triggerName = triggerName;
	}

	public static void setJobid(int jobid) {
		JobConfig.jobid = jobid;
	}
	public static String getJobname() {
		return jobname;
	}
	public static void setJobname(String jobname) {
		JobConfig.jobname = jobname;
	}
	public static String getGroupname() {
		return groupname;
	}
	public static void setGroupname(String groupname) {
		JobConfig.groupname = groupname;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		JobConfig.description = description;
	}
	public static Date getCreatetime() {
		return createtime;
	}
	public static void setCreatetime(Date createtime) {
		JobConfig.createtime = createtime;
	}
	public static Date getModifytime() {
		return modifytime;
	}
	public static void setModifytime(Date modifytime) {
		JobConfig.modifytime = modifytime;
	}
	public static String getStatus() {
		return status;
	}
	public static void setStatus(String status) {
		JobConfig.status = status;
	}
	public static Date getStarttime() {
		return starttime;
	}
	public static void setStarttime(Date starttime) {
		JobConfig.starttime = starttime;
	}
	public static String getSchedule() {
		return schedule;
	}
	public static void setSchedule(String schedule) {
		JobConfig.schedule = schedule;
	}
	public static String getJobclassname() {
		return jobclassname;
	}
	public static void setJobclassname(String jobclassname) {
		JobConfig.jobclassname = jobclassname;
	}
	public static Date getStoptime() {
		return stoptime;
	}
	public static void setStoptime(Date stoptime) {
		JobConfig.stoptime = stoptime;
	}
	public static int getExecnum() {
		return execnum;
	}
	public static void setExecnum(int execnum) {
		JobConfig.execnum = execnum;
	}
	public static int getIntervaltime() {
		return intervaltime;
	}
	public static void setIntervaltime(int intervaltime) {
		JobConfig.intervaltime = intervaltime;
	}
	public static String getOperationtype() {
		return operationtype;
	}
	public static void setOperationtype(String operationtype) {
		JobConfig.operationtype = operationtype;
	}
	
	
	
	
	
	
	
}
