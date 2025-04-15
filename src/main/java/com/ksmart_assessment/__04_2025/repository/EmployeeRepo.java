package com.ksmart_assessment.__04_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksmart_assessment.__04_2025.model.Employee;

@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
}
