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
import org.springframework.web.bind.annotation.RestController;

import com.emre.hrmsProject.business.abstracts.CoverLetterService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.CoverLetter;

@RestController
@RequestMapping(value="/api/coverletters")
@CrossOrigin
public class CoverLettersController {

	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}
	
	@DeleteMapping("/delete")
	public Result delete(int coverLetterId) {
		return this.coverLetterService.delete(coverLetterId);
	}
	
	@GetMapping("/getById")
	public DataResult<CoverLetter> getById(int coverLetterId){
		return this.coverLetterService.getById(coverLetterId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
}
