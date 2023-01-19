package com.emre.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emre.hrmsProject.business.abstracts.EmployeeService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Employee;

@RestController
@RequestMapping("/api/emplooyes")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int employeeId){
		return this.employeeService.delete(employeeId);
	}
	
	@GetMapping("/getById")
	public DataResult<Employee> getById(@RequestParam int employeeId){
		return this.employeeService.getById(employeeId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
}
