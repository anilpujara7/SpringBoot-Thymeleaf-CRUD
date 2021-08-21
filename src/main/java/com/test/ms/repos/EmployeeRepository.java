package com.test.ms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ms.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
