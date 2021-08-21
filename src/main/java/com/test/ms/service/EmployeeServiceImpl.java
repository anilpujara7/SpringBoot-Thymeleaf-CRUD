package com.test.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ms.model.Employee;
import com.test.ms.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmp(Employee emp) {
		employeeRepository.save(emp);

	}

	@Override
	public Employee getEmpById(long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id ::" + id);
		}

		return employee;
	}

	@Override
	public void deleteEmp(long id) {
		employeeRepository.deleteById(id);

	}

}
