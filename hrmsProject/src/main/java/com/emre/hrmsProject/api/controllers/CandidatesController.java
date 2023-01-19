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

import com.emre.hrmsProject.business.abstracts.CandidateService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Candidate;
import com.emre.hrmsProject.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Candidate candidate)  {
		return this.candidateService.update(candidate);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int candidateId)  {
		return this.candidateService.delete(candidateId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(@RequestParam int candidateId){
		return this.candidateService.getById(candidateId);
	}
	
	@GetMapping("/cvByCandidateId")
	public DataResult<List<CvDto>> cvByCandidateId(@RequestParam int candidateId){
		return this.candidateService.cvByCandidateId(candidateId);
	}
	
	@GetMapping("/getAllCvDto")
	public DataResult<List<CvDto>> getAllCvDto() {
		return this.candidateService.getAllCvDto();
	}
}
