package com.lingtong.Mappers;

import java.util.List;
import java.util.Map;

import com.lingtong.po.JobConfig;

public interface JobConfigMapper {
	/**
	 * 
	 * @Description: TODO(��ȡ���п��Ե�JOB) 
	 * @param @return
	 * @param @throws Exception   �趨�ļ� 
	 * @return List<JobConfig>  ����JOB���� 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016��4��5��
	 */
		public List<Map> selectAllJobs()throws Exception;
}
