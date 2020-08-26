package com.jpademo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpademo3.service.DepartmentService;
import com.jpademo3.service.EmployeeService;

@SpringBootApplication
public class JpaDemo3Application {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(JpaDemo3Application.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		DepartmentService departmentService = context.getBean(DepartmentService.class);

		employeeService.getEmp(101L);
		employeeService.getEmp(101L);
		employeeService.getEmp(103L);

		departmentService.getDept(11);
		departmentService.getDept(12);
		departmentService.getDept(12);

	}

}
