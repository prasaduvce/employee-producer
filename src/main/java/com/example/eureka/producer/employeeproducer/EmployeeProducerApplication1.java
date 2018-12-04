package com.example.eureka.producer.employeeproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducerApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducerApplication1.class, args);
	}
}
