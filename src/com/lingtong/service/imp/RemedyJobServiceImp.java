package com.lingtong.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lingtong.Mappers.RemedyJobMapper;
import com.lingtong.po.RemedyJob;
import com.lingtong.service.RemedyJobService;
/**
 * 
* <p>Title:RemedyJobServiceImp </p>
* <p>ClassName: RemedyJobServiceImp</p>
* <p>Description: TODO</p>(������һ�仰��������������) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016��3��24��
 */
public class RemedyJobServiceImp implements RemedyJobService {
	@Autowired
	private  RemedyJobMapper remedyJobMapper;
	@Override
	public List<RemedyJob> getAllJobs() throws Exception {
		return remedyJobMapper.getAllJobs();
	}

	@Override
	public List<RemedyJob> getJobsByGroupJob(String group, String job)
			throws Exception {
		// TODO Auto-generated method stub
		return remedyJobMapper.getJobsByGroupJob(group, job);
	}

	@Override
	public List<RemedyJob> getJobsByJob(String job) throws Exception {
		// TODO Auto-generated method stub
		return remedyJobMapper.getJobsByJob(job);
	}

}
