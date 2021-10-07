package com.demo.employeemanagement;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import com.demo.employeemanagement.model.Employee;
import com.demo.employeemanagement.repository.EmployeeRepository;
import com.demo.employeemanagement.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeemanagementApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeService employeeService;

	@Test
	public void testApi() {
		List<Employee> emp = employeeService.getEmployees();
		// assertEquals(expected, actual);
		assertFalse(emp.isEmpty());

	}

}
