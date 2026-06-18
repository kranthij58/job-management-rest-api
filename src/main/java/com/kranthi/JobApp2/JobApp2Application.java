package com.kranthi.JobApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JobApp2Application {

	public static void main(String[] args) {

		SpringApplication.run(JobApp2Application.class, args);
	}


}
