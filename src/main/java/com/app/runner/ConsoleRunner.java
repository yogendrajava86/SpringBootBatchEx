package com.app.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class ConsoleRunner implements CommandLineRunner {
	
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(":: BATCH EXECUTION ::");
		JobParameters jobParameters=new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
		launcher.run(job, jobParameters);
		
	}

}
