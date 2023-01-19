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

import com.emre.hrmsProject.business.abstracts.JobTitleService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobTitlesController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobTitle>>  getAll(){
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobTitle> getById(@RequestParam int jobTitleId){
		return this.jobTitleService.getById(jobTitleId);
	}
	
	@GetMapping("/findByTitle")
	public JobTitle findByTitle(@RequestParam String title){
		return this.jobTitleService.findByTitle(title);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.update(jobTitle);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobTitleId) {
		return this.jobTitleService.delete(jobTitleId);
	} 

}
