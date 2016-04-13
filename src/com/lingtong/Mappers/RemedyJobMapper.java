package com.lingtong.Mappers;
import java.util.List;

import com.lingtong.po.RemedyJob;
public interface RemedyJobMapper {
/**
 * 
 * @Description: TODO(取所有的配置信息列表) 
 * @param @return
 * @param @throws Exception   设定文件 
 * @return List<RemedyJob>  返回类型 
 * @throws
 * @author wenhao wenhao@lingtong.cc
 * @date 2016年3月22日
 */
	public List<RemedyJob>  getAllJobs () throws Exception;
	/**
	 * 
	 * @Description: TODO(根据处理组，JOB名取配置操作信息) 
	 * @param @param group
	 * @param @param job
	 * @param @return
	 * @param @throws Exception   设定文件 
	 * @return List<RemedyJob>  返回类型 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016年3月22日
	 */
	public List<RemedyJob>  getJobsByGroupJob (String group,String job) throws Exception;
	/**
	 * 
	 * @Description: TODO(根据JOB名取配置操作信息) 
	 * @param @param group
	 * @param @param job
	 * @param @return
	 * @param @throws Exception   设定文件 
	 * @return List<RemedyJob>  返回类型 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016年3月22日
	 */
	public List<RemedyJob>  getJobsByJob (String job) throws Exception;
	
	
	
}
