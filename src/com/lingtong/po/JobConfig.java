package com.lingtong.po;

import java.util.Date;

public class JobConfig {
	private static int jobid ;//jobID
	private static String jobname;//Job����
	private static String triggerName; //�������� 
	private static String groupname;//������
	private static String description;//����
	private static Date createtime;//����ʱ��
	private static Date modifytime;//�޸�ʱ��
	private static String status;//״̬
	private static Date starttime;//��ʼʱ��
	private static String schedule;//ִ�еĹ���
	private static String jobclassname;//CLASS����
	private static Date stoptime;//ֹͣ��ʱ��
	private static int execnum;//ִ�еĴ���
	private static int intervaltime;//ִ�м��ʱ��
	private static int timetype ;//���ʱ������
	private static String operationtype;//��������
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
