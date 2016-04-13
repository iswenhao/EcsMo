package com.lingtong.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.quartz.SchedulerException;

import com.lingtong.quartztools.dao.QuartztoolsInterface;
import com.lingtong.quartztools.dao.imp.QuartztoolsInterfaceImp;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class TestSelect {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String jobName="testJob";
		String group="testgroup";
		Map parameters=new HashMap();
		String time="0/1 * * * * ?";
		String jobClassName="com.lingtong.jobPool.TestJob";
		//String jobClassName="com.lingtong.test.TestJob";
		String startTime="";
		QuartztoolsInterface qi=new QuartztoolsInterfaceImp();
		parameters.put("test", "test");
		try {
			qi.addJob(jobName, group, parameters, jobName, group, jobClassName, time);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

}
