package com.lingtong.quartztools.dao;

import java.util.Date;
import java.util.Map;

import org.quartz.Job;
import org.quartz.SchedulerException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface QuartztoolsInterface {

	 /**
	    * ���һ����ʱ���� 
	    * @param jobName ������ 
	    * @param jobGroupName �������� 
	    * @param parameters   ����
	    * @param triggerName  �������� 
	    * @param triggerGroupName ���������� 
	    * @param jobClassName     JOB���� 
	    * @param time    ʱ�����ã��ο�quartz˵���ĵ� 
	    * @return  �ɹ�����ʧ��
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	public Boolean addJob(String jobName,String jobGroupName, Map<String, Object> parameters,String triggerName,String triggerGroupName,String jobClassName,String time)throws SchedulerException, ParseException;

	/**
	 * �����ҵ �������ʱ��ִ��һ�Σ�һ��ִ�ж��ٴ�
	 * @param jobName ����
	 * @param group	  ��
	 * @param map   ����
	 * @param intervalTime ���ʱ��
	 * @param count ִ�д���
	 * @param type ���ʱ������
	 * @param startDate ִ�п�ʼʱ��
	 * @param jobClassName ִ�е�Class����
	 * @return
	 * @throws Exception
	 */
	public Boolean addJob(String jobName, String group,
			Map<String, Object> parameters, int intervalTime, int count,
			int type, Date startDate,String jobClassName) throws Exception;
	
	/**
	 *  �����ҵ ���ݹ���ִ�У���Ҫ���忪ʼʱ��ͽ�����ʱ��
	 * @param jobName JOB��
	 * @param group    ����
	 * @param parameters ������
	 * @param time   ִ��ʱ�����
	 * @param jobClassName ֱ�ӵ�calss
	 * @param startTime ִ�п�ʼʱ��
	 * @param endTime  ִ�н���ʱ��
	 * @throws Exception
	 */
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,Date startTime,Date endTime) throws Exception;
	/**
	 *  �����ҵ ���ݹ���ִ�У���Ҫ���忪ʼʱ���û�н�����ʱ��
	 * @param jobName JOB��
	 * @param group    ����
	 * @param parameters ������
	 * @param time   ִ��ʱ�����
	 * @param jobClassName ֱ�ӵ�calss
	 * @param startTime ִ�п�ʼʱ��
	 * @throws Exception
	 */
	public void addJob(String jobName, String group,
			Map<String, Object> parameters, String time, String jobClassName,Date startTime) throws Exception;
	/**
	 * ɾ����ҵ
	 * @param jobName ����
	 * @param group	  ��
	 * @throws Exception 
	 */
	public boolean deleteJob(String jobName,String group) throws Exception;
	
	/**
	 * ɾ����ҵ
	 * @param jobName ����
	 * @throws Exception 
	 */
	public boolean deleteJob(String jobName) throws Exception;
	/**
	 * �޸���ҵ
	 * @param jobName ����
	 * @param group ��
	 * @param time	ִ�й���
	 * @return
	 * @throws Exception
	 */
	public Date upadteJobTime(String jobName, String group,String time) throws Exception;
	
	/**
	 * ��ͣ��ҵ
	 * @param jobName ����
	 * @param group	  ��
	 * @throws Exception 
	 */
	public void pauseJob(String jobName,String group) throws Exception;
	
	/**
	 * ��ͣ��ҵ
	 * @param jobName ����
	 * @throws Exception 
	 */
	public void pauseJob(String jobName) throws Exception;
	
	
	/**
	 * ������ҵ
	 * @param jobName ����
	 * @param group	  ��
	 * @throws Exception 
	 */
	public void resumeJob(String jobName,String group) throws Exception;
	
	/**
	 * ������ҵ
	 * @param jobName ����
	 * @throws Exception 
	 */
	public void resumeJob(String jobName) throws Exception;


	
}
