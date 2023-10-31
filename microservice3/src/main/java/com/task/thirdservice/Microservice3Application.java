package com.task.thirdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice3Application.class, args);
	}

}
