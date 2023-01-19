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

import com.emre.hrmsProject.business.abstracts.JobExperienceService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.JobExperience;

@RestController
@RequestMapping(value="/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@PutMapping(value="/update")
	public Result update(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.update(jobExperience);
	}
	
	@DeleteMapping(value="/delete")
	public Result delete(@RequestParam int jobExperienceId) {
		return this.jobExperienceService.delete(jobExperienceId);
	}
	
	@GetMapping(value="sortByExperienceYearDESC")
	public DataResult<List<JobExperience>> sortByExperienceYearDESC(@RequestParam int candidateId){
		return this.jobExperienceService.sortByExperienceYear(candidateId);
	}
	
	@GetMapping(value="/getById")
	public DataResult<JobExperience> getById(@RequestParam int jobExperienceId){
		return this.jobExperienceService.getById(jobExperienceId);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
}
