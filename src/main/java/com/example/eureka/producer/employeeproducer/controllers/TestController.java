package com.example.eureka.producer.employeeproducer.controllers;

import com.example.eureka.producer.employeeproducer.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {
		System.out.println("==== Inside firstPage ==== ");
		Employee employee = new Employee();
		employee.setName("emp1");
		employee.setDesignation("manager");
		employee.setEmpId("1");
		employee.setSalary(3000D);
		if (employee.getName().equalsIgnoreCase("emp1")) {
			throw new RuntimeException("Invalid Request");
		}
		return employee;
	}

	public Employee getDataFallBack() {
		System.out.println("==== Inside Fallback ==== ");
		Employee employee = new Employee();
		employee.setName("fallback-emp1");
		employee.setDesignation("fallback-manager");
		employee.setEmpId("fallback-1");
		employee.setSalary(3000D);
		return employee;
	}
}
