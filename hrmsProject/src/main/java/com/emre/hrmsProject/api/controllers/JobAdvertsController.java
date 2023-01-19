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

import com.emre.hrmsProject.business.abstracts.JobAdvertService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Employer;
import com.emre.hrmsProject.entities.concretes.JobAdvert;
import com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto;


@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.update(jobAdvert);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobAdvertId) {
		return this.jobAdvertService.delete(jobAdvertId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PutMapping("/confirm")
	public Result confirm(@RequestParam int jobAdvertId,@RequestParam int employeeId,@RequestParam boolean isConfirmed) {
		return this.jobAdvertService.confirm(jobAdvertId, employeeId, isConfirmed);
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam int jobAdvertId){
		return this.jobAdvertService.getById(jobAdvertId);
	}
	
	@GetMapping("/getAllActiveJobAdvertList")
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertList(@RequestParam boolean isActive){
		return this.jobAdvertService.getAllActiveJobAdvertList(isActive);
	}
	
	@GetMapping("/getAllActiveJobAdvertListByDateASC")
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByDate(){
		return this.jobAdvertService.getAllActiveJobAdvertListByDate();
	}
	
	@GetMapping("/getAllActiveJobAdvertListByEmployer")
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByEmployer(@RequestParam Employer employerId){
		return this.jobAdvertService.getAllActiveJobAdvertListByEmployer(employerId);
	}
	
	@GetMapping("/getAllOnesThatWaitingForPostingConfirmation")
	public DataResult<List<JobAdvertDetailDto>> getAllOnesThatWaitingForPostingConfirmation(){
		return this.jobAdvertService.getAllOnesThatWaitingForPostingConfirmation();
	}
	
	@PostMapping("/setJobAdvert")
	public Result setJobAdvert(@RequestParam int jobAdvertId,@RequestParam boolean isActive) {
		return this.jobAdvertService.setJobAdvert(jobAdvertId,isActive);
	}
}
