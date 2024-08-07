package com.madhu.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.temp.dao.EmployeRepositary;
import com.madhu.temp.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeController {

	@Autowired
	private EmployeRepositary employeerepositary;

	@GetMapping("/employe")
	public List<Employee> findAll() {
		return employeerepositary.findAll();
	}

	@GetMapping("/employe/{id}")
	public Employee findById(@PathVariable int Id) {
		Employee emp = employeerepositary.findById(Id);
		return emp;
	}

	@PostMapping("/employe")
	public Employee save(@RequestBody Employee emp) {
		employeerepositary.save1(emp);
		return emp;
	}

	@PutMapping("/employe")
	public Employee update(@RequestBody Employee emp) {
		employeerepositary.update(emp);
		return emp;
	}

	@DeleteMapping("/employe/{id}")
	public int deleteById(@PathVariable int Id) {
		int emp = employeerepositary.deleteByid(Id);
		return emp;
	}

}
