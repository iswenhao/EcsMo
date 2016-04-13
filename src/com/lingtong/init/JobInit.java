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
 * (每次项目启动的时候把JOB全部加载进来)
 * <p>
 * Company:lingtong
 * </p>
 * 
 * @author wenhao wenhao@lingtong.cc
 * @date 2016年4月5日
 */

public class JobInit  implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger logger = LoggerFactory.getLogger(JobInit.class);
	@Autowired
	private JobConfigService jobConfigService;
	@Autowired
	private QuartztoolsInterface quartztoolsInterface;
	private static String jobname;// Job名字
	private static String triggerName; // 触发器名
	private static String groupname;// 组名字
	private static String operationtype;// 操作类型
	private static String jobclassname;// CLASS名字
	private static Map<String, Object> parameters;// 参数
	private static Date starttime;// 开始时间

	@SuppressWarnings("static-access")
	public void init() {
		
		parameters = new HashMap<String, Object>();
		logger.info("##########开始实例化JOB############");
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

				// 按照规则执行，没有停止时间
				if (jobConfig.getSchedule() != null
						|| jobConfig.getSchedule() != "") {
					if (jobConfig.getStoptime() != null) {
						logger.info("##########加载-按照规则执行JOB作业-有停止时间############"+jobConfig.getSchedule()+jobname+groupname);
						quartztoolsInterface.addJob(jobname, groupname,
								parameters, jobConfig.getSchedule(),
								jobclassname, starttime,
								jobConfig.getStoptime());
					}
					logger.info("##########加载-按照规则执行JOB作业-没有停止时间############"+jobConfig.getSchedule()+jobname+groupname);
					quartztoolsInterface.addJob(jobname, groupname, parameters,
							jobConfig.getSchedule(), jobclassname, starttime);
				} else {// 按照间隔时间执行
					logger.info("##########加载-按照执行次数间隔时间执行JOB作业-没有停止时间############"+jobname+groupname);
					quartztoolsInterface.addJob(jobname, groupname, parameters,
							jobConfig.getIntervaltime(),
							jobConfig.getExecnum(), jobConfig.getTimetype(),
							starttime, jobclassname);
				}*/
			}
			}else{
				logger.error("######JOBConfig表没有数据！######");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() == null) {  //防止重复执行。
			 //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            init();
        }
	}
}
