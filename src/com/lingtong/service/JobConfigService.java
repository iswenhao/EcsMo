package com.lingtong.service;

import java.util.List;
import java.util.Map;

import com.lingtong.po.JobConfig;
/**
 * 
* <p>Title:JobConfigInterface </p>
* <p>ClassName: JobConfigInterface</p>
* <p>Description: TODO</p>(������һ�仰��������������) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016��4��5��
 */
public interface JobConfigService {
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
