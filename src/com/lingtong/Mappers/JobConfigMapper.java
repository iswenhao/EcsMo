package com.lingtong.Mappers;

import java.util.List;
import java.util.Map;

import com.lingtong.po.JobConfig;

public interface JobConfigMapper {
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
