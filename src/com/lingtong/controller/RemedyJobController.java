package com.lingtong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lingtong.po.RemedyJob;
import com.lingtong.service.RemedyJobService;

/**
 * 
* <p>Title:RemedyJobController </p>
* <p>ClassName: RemedyJobController</p>
* <p>Description: TODO</p>(������һ�仰��������������) 
* <p>Company:lingtong </p> 
* @author wenhao wenhao@lingtong.cc
* @date 2016��3��24��
 */
@Controller
@RequestMapping("/JobController")
public class RemedyJobController {
	
@Autowired
private  RemedyJobService remedyJobService;
	/**
	 * 
	 * @Description: TODO(�������е�JOB����) 
	 * @param @return
	 * @param @throws Exception   �趨�ļ� 
	 * @return ModelAndView  �������� 
	 * @throws
	 * @author wenhao wenhao@lingtong.cc
	 * @date 2016��3��24��
	 */
@RequestMapping("/getAllJobs")
public ModelAndView getAllJobs() throws Exception{
	List<RemedyJob> remedyJobList=remedyJobService.getAllJobs();
	for (RemedyJob remedyJob:remedyJobList) {
		System.out.println("@@@@@@@@@@@@@@@@:"+remedyJob.getJobName()+"#####"+remedyJob.getFormName()+remedyJob.getGroupName());
	}
	ModelAndView modelAndView =new ModelAndView();
	modelAndView.addObject("remedyJobList",remedyJobList);
	modelAndView.setViewName("ShowJob");
	return modelAndView;
}
@RequestMapping("/getJobsByJob")
public ModelAndView getJobsByJob() throws Exception{
	String jobname="modifytable";
	List<RemedyJob> remedyJobList=remedyJobService.getJobsByJob( jobname);
	ModelAndView modelAndView =new ModelAndView();
	modelAndView.addObject("remedyJobList",remedyJobList);
	modelAndView.setViewName("ShowJob");
	return modelAndView;
}

}
