package com.lingtong.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lingtong.Mappers.JobConfigMapper;
import com.lingtong.po.JobConfig;
import com.lingtong.service.JobConfigService;
/**
* <p>Title:JobConfigServiceImp </p>
* <p>ClassName: JobConfigServiceImp</p>
* <p>Description: TODO</p>(������һ�仰��������������) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016��4��5��
 */
public class JobConfigServiceImp implements JobConfigService {
	@Autowired
	private JobConfigMapper jobConfigMapper;
	@Override
	public List<Map> selectAllJobs() throws Exception {
		// TODO Auto-generated method stub
		return jobConfigMapper.selectAllJobs();
	}

}
