package com.example.employeeappraisal.repository;

import com.example.employeeappraisal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Additional query methods can be defined here if needed
}
