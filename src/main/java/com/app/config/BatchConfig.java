package com.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.listener.MyJobListener;
import com.app.processor.Processor;
import com.app.reader.Reader;
import com.app.writer.Writer;

@Configuration
public class BatchConfig {
	
	//3. Job Creation
	@Autowired
	private JobBuilderFactory jf;
	@Bean
	public Job j1() {
		return jf.get("j1")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(s1())
				.build()
				;
	}
	
	@Bean
	public MyJobListener listener() {
		return new MyJobListener();
	}
	
	
	//2. Step Creation
	@Autowired
	private StepBuilderFactory sf;
	@Bean
	public Step s1() {
		return sf.get("s1")
				.<String,String>chunk(1)
				.reader(reader())
				.processor(process())
				.writer(write())
				.build();
	}
	
	
	
	//1. Item Reader,Processor and Writer creation
	@Bean
	public Reader reader() {
		return new Reader();
	}
	
	@Bean
	public Processor process() {
		return new Processor();
	}
	
	@Bean
	public Writer write() {
		return new Writer();
	}
}
