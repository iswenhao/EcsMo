
package com.lingtong.po;

import java.util.Date;
/**
 * 
* <p>Title:RemedyJob </p>
* <p>ClassName: RemedyJob</p>
* <p>Description: TODO</p>(������һ�仰��������������) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016��3��22��
 */
public class RemedyJob{
	
	private static int id;//
	private static String formName;//����
	private static String tableName;//��Ӧ�ı���
	private static String operation;//����
	private static String field;//�ֶ�ӳ���ϵ
	private static String jobName;//job����
	private static String triggerName; //�������� 
	private static String groupName;//������
	private static String description;//����
	private static Date createTime;//����ʱ��
	private static Date modifyTime;//�޸�ʱ��
	private static int status;//״̬ 0 ���� 1 ɾ��
	
	public static String getTriggerName() {
		return triggerName;
	}
	public static void setTriggerName(String triggerName) {
		RemedyJob.triggerName = triggerName;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		RemedyJob.id = id;
	}
	public static String getFormName() {
		return formName;
	}
	public static void setFormName(String formName) {
		RemedyJob.formName = formName;
	}
	public static String getTableName() {
		return tableName;
	}
	public static void setTableName(String tableName) {
		RemedyJob.tableName = tableName;
	}
	public static String getOperation() {
		return operation;
	}
	public static void setOperation(String operation) {
		RemedyJob.operation = operation;
	}
	public static String getField() {
		return field;
	}
	public static void setField(String field) {
		RemedyJob.field = field;
	}
	public static String getJobName() {
		return jobName;
	}
	public static void setJobName(String jobName) {
		RemedyJob.jobName = jobName;
	}
	
	public static String getGroupName() {
		return groupName;
	}
	public static void setGroupName(String groupName) {
		RemedyJob.groupName = groupName;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		RemedyJob.description = description;
	}
	public static Date getCreateTime() {
		return createTime;
	}
	public static void setCreateTime(Date createTime) {
		RemedyJob.createTime = createTime;
	}
	public static Date getModifyTime() {
		return modifyTime;
	}

	public static void setModifyTime(Date modifyTime) {
		RemedyJob.modifyTime = modifyTime;
	}
	public static int getStatus() {
		return status;
	}
	public static void setStatus(int status) {
		RemedyJob.status = status;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", formName="
				+ formName+ ", status=" +status + "]";
	}
	
	
	

	
}