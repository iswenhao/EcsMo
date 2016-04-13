package com.lingtong.service;

import java.util.List;
import java.util.Map;

import com.lingtong.po.JobConfig;
/**
 * 
* <p>Title:JobConfigInterface </p>
* <p>ClassName: JobConfigInterface</p>
* <p>Description: TODO</p>(这里用一句话描述这个类的作用) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016年4月5日
 */
public interface JobConfigService {
/**
 * 
 * @Description: TODO(获取所有可以的JOB) 
 * @param @return
 * @param @throws Exception   设定文件 
 * @return List<JobConfig>  返回JOB集合 
 * @throws
 * @author wenhao wenhao@lingtong.cc
 * @date 2016年4月5日
 */
	public List<Map> selectAllJobs()throws Exception;
	
}
