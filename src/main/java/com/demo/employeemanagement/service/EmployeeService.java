package com.demo.employeemanagement.service;

import java.util.List;

import com.demo.employeemanagement.exception.ResourceNotFoundException;
import com.demo.employeemanagement.model.Employee;
import com.demo.employeemanagement.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        Long findByEmail = employeeRepository.findByEmail(employee.getEmailId());
        if (findByEmail != null) {
            throw new IllegalStateException("This email already used");
        }
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id " + id));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id " + id));
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setEmailId(employee.getEmailId());
        return employeeRepository.save(e);
    }

    public void deleteEmployee(Long id) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id " + id));
        employeeRepository.delete(e);
    }
}
