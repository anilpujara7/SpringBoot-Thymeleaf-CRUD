package com.test.ms.service;

import java.util.List;

import com.test.ms.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmp();

	void saveEmp(Employee emp);

	Employee getEmpById(long id);
	
	void deleteEmp(long id);

}
