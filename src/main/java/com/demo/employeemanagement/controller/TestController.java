package com.demo.employeemanagement.controller;

import java.util.List;

import com.demo.employeemanagement.model.Employee;
import com.demo.employeemanagement.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

public class TestController {
    @Autowired
    EmployeeService employeeService;

    public List<Employee> getEmployee() {

        return employeeService.getEmployees();
    }

}
