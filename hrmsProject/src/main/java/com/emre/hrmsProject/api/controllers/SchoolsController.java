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

import com.emre.hrmsProject.business.abstracts.SchoolService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.School;

@RestController
@RequestMapping(value="/api/schools")
@CrossOrigin
public class SchoolsController {
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@PutMapping(value="/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}
	
	@DeleteMapping(value="/delete")
	public Result delete(@RequestParam int schoolId) {
		return this.schoolService.delete(schoolId);
	}
	
	@GetMapping(value="/getById")
	public DataResult<School> getById(@RequestParam int schoolId){
		return this.schoolService.getById(schoolId);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
	}
	
	@GetMapping(value="/sortByGraduationYearDESC")
	public DataResult<List<School>> sortByGraduationYear(@RequestParam int candidateId){
		return this.schoolService.sortByGraduationYear(candidateId);
	}
}
