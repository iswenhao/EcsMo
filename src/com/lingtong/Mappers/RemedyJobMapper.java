package com.lingtong.Mappers;
import java.util.List;

import com.lingtong.po.RemedyJob;
public interface RemedyJobMapper {
/**
 * 
 * @Description: TODO(ȡ���е�������Ϣ�б�) 
 * @param @return
 * @param @throws Exception   �趨�ļ� 
 * @return List<RemedyJob>  �������� 
 * @throws
 * @author wenhao wenhao@lingtong.cc
 * @date 2016��3��22��
 */
	public List<RemedyJob>  getAllJobs () throws Exception;
	/**
	 * 
	 * @Description: TODO(���ݴ����飬JOB��ȡ���ò�����Ϣ) 
	 * @param @param group
	 * @param @param job
	 * @param @return
	 * @param @throws Exception   �趨�ļ� 
	 * @return List<RemedyJob>  �������� 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016��3��22��
	 */
	public List<RemedyJob>  getJobsByGroupJob (String group,String job) throws Exception;
	/**
	 * 
	 * @Description: TODO(����JOB��ȡ���ò�����Ϣ) 
	 * @param @param group
	 * @param @param job
	 * @param @return
	 * @param @throws Exception   �趨�ļ� 
	 * @return List<RemedyJob>  �������� 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016��3��22��
	 */
	public List<RemedyJob>  getJobsByJob (String job) throws Exception;
	
	
	
}
