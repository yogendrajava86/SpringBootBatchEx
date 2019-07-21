package com.app.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before Job Execution Listener");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After Job Execution Listener ");
	}

}
