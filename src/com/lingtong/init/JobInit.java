package com.lingtong.init;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.lingtong.po.JobConfig;
import com.lingtong.po.RemedyJob;
import com.lingtong.quartztools.dao.QuartztoolsInterface;
import com.lingtong.quartztools.dao.imp.QuartztoolsInterfaceImp;
import com.lingtong.service.JobConfigService;
import com.lingtong.service.RemedyJobService;
import com.lingtong.service.imp.JobConfigServiceImp;

/**
 * 
 * <p>
 * Title:JobInit
 * </p>
 * <p>
 * ClassName: JobInit
 * </p>
 * <p>
 * Description: 
 * </p>
 * (ÿ����Ŀ������ʱ���JOBȫ�����ؽ���)
 * <p>
 * Company:lingtong
 * </p>
 * 
 * @author wenhao wenhao@lingtong.cc
 * @date 2016��4��5��
 */

public class JobInit  implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger logger = LoggerFactory.getLogger(JobInit.class);
	@Autowired
	private JobConfigService jobConfigService;
	@Autowired
	private QuartztoolsInterface quartztoolsInterface;
	private static String jobname;// Job����
	private static String triggerName; // ��������
	private static String groupname;// ������
	private static String operationtype;// ��������
	private static String jobclassname;// CLASS����
	private static Map<String, Object> parameters;// ����
	private static Date starttime;// ��ʼʱ��

	@SuppressWarnings("static-access")
	public void init() {
		
		parameters = new HashMap<String, Object>();
		logger.info("##########��ʼʵ����JOB############");
		try {
			List<Map> ListJobConfig = jobConfigService.selectAllJobs();
			JobConfig jc=(JobConfig) ListJobConfig.get(0);
			JobConfig jc1=(JobConfig) ListJobConfig.get(0);
			logger.info("ListJobConfig:"+ListJobConfig.get(0)+jc.getJobname()+jc1.getJobname());
			if (ListJobConfig!=null) {
			for (Map jobConfig : ListJobConfig) {
				jobname=	(String) jobConfig.get("jobname");
				triggerName=	(String) jobConfig.get("triggerName");
				groupname=	(String) jobConfig.get("groupname");
				logger.info("$$$$$$$$$$$$$$jobname"+jobname+"triggerName"+triggerName+groupname);
				/*jobname = jobConfig.getJobname();
				triggerName = jobConfig.getTriggerName();
				groupname = jobConfig.getGroupname();
				operationtype = jobConfig.getOperationtype();
				jobclassname = jobConfig.getJobclassname();
				starttime = jobConfig.getStarttime();
				parameters.put("jobname", jobname);
				parameters.put("triggername", triggerName);
				parameters.put("groupname", groupname);
				parameters.put("operationtype", operationtype);
				parameters.put("jobclassname", jobclassname);

				// ���չ���ִ�У�û��ֹͣʱ��
				if (jobConfig.getSchedule() != null
						|| jobConfig.getSchedule() != "") {
					if (jobConfig.getStoptime() != null) {
						logger.info("##########����-���չ���ִ��JOB��ҵ-��ֹͣʱ��############"+jobConfig.getSchedule()+jobname+groupname);
						quartztoolsInterface.addJob(jobname, groupname,
								parameters, jobConfig.getSchedule(),
								jobclassname, starttime,
								jobConfig.getStoptime());
					}
					logger.info("##########����-���չ���ִ��JOB��ҵ-û��ֹͣʱ��############"+jobConfig.getSchedule()+jobname+groupname);
					quartztoolsInterface.addJob(jobname, groupname, parameters,
							jobConfig.getSchedule(), jobclassname, starttime);
				} else {// ���ռ��ʱ��ִ��
					logger.info("##########����-����ִ�д������ʱ��ִ��JOB��ҵ-û��ֹͣʱ��############"+jobname+groupname);
					quartztoolsInterface.addJob(jobname, groupname, parameters,
							jobConfig.getIntervaltime(),
							jobConfig.getExecnum(), jobConfig.getTimetype(),
							starttime, jobclassname);
				}*/
			}
			}else{
				logger.error("######JOBConfig��û�����ݣ�######");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() == null) {  //��ֹ�ظ�ִ�С�
			 //��Ҫִ�е��߼����룬��spring������ʼ����ɺ�ͻ�ִ�и÷�����
            init();
        }
	}
}
