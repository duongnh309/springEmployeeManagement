package com.demo.employeemanagement.repository;

import com.demo.employeemanagement.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "Select id from employees where email_id = ?1", nativeQuery = true)
    Long findByEmail(String email);
}
