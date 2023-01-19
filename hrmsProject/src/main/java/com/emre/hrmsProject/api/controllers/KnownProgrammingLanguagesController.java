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

import com.emre.hrmsProject.business.abstracts.KnownProgrammingLanguageService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.KnownProgrammingLanguage;

@RestController
@RequestMapping(value = "/api/knownprogramminglanguages")
@CrossOrigin
public class KnownProgrammingLanguagesController {
	
	private KnownProgrammingLanguageService knownProgrammingLanguageService;

	@Autowired
	public KnownProgrammingLanguagesController(KnownProgrammingLanguageService knownProgrammingLanguageService) {
		super();
		this.knownProgrammingLanguageService = knownProgrammingLanguageService;
	}

	@PostMapping(value="/add")
	public Result add(@RequestBody KnownProgrammingLanguage knownProgrammingLanguage) {
		return this.knownProgrammingLanguageService.add(knownProgrammingLanguage);
	}
	
	@PutMapping(value="/update")
	public Result update(@RequestBody KnownProgrammingLanguage knownProgrammingLanguage) {
		return this.knownProgrammingLanguageService.update(knownProgrammingLanguage);
	}
	
	@DeleteMapping(value="/delete")
	public Result delete(int knownProgrammingLanguageId) {
		return this.knownProgrammingLanguageService.delete(knownProgrammingLanguageId);
	}
	
	@GetMapping(value="/getById")
	public DataResult<KnownProgrammingLanguage> getById(int knownProgrammingLanguageId){
		return this.knownProgrammingLanguageService.getById(knownProgrammingLanguageId);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<KnownProgrammingLanguage>> getAll() {
		return this.knownProgrammingLanguageService.getAll();
	}
	
	@GetMapping(value="/findByCandidateId")
	public DataResult<List<KnownProgrammingLanguage>> findByCandidateId(@RequestParam int candidateId){
		return this.knownProgrammingLanguageService.findByCandidateId(candidateId);
	}
}
