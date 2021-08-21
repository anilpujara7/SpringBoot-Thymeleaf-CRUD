package com.test.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ms.model.Employee;
import com.test.ms.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

// display employee list
	@GetMapping("/")
	public String getAllEmp(Model model) {
		model.addAttribute("list", employeeService.getAllEmp());

		return "index";

	}

	@GetMapping("/empForm")
	public String empForm(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "empForm";

	}

	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp) {
		employeeService.saveEmp(emp);
		return "redirect:/";

	}

	@GetMapping("/empFormUpdate/{id}")
	public String updateForm(@PathVariable long id, Model model) {

		Employee empById = employeeService.getEmpById(id);

		model.addAttribute("employee", empById);
		return "empFormUpdate";

	}

	@GetMapping("/deleteEmp/{id}")
	public String name(@PathVariable long id) {

		employeeService.deleteEmp(id);
		return "redirect:/";

	}

}
