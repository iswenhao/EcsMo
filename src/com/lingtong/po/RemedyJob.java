
package com.lingtong.po;

import java.util.Date;
/**
 * 
* <p>Title:RemedyJob </p>
* <p>ClassName: RemedyJob</p>
* <p>Description: TODO</p>(这里用一句话描述这个类的作用) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016年3月22日
 */
public class RemedyJob{
	
	private static int id;//
	private static String formName;//表单名
	private static String tableName;//对应的表名
	private static String operation;//操作
	private static String field;//字段映射关系
	private static String jobName;//job名称
	private static String triggerName; //触发器名 
	private static String groupName;//组名称
	private static String description;//描述
	private static Date createTime;//创建时间
	private static Date modifyTime;//修改时间
	private static int status;//状态 0 启用 1 删除
	
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