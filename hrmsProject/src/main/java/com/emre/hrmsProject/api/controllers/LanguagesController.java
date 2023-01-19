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

import com.emre.hrmsProject.business.abstracts.LanguageService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Language;

@RestController
@RequestMapping(value = "/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	@PostMapping(value="/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@PutMapping(value="/update")
	public Result update(@RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	@DeleteMapping(value="/delete")
	public Result delete(@RequestParam int languageId) {
		return this.languageService.delete(languageId);
	}
	
	@GetMapping(value="/getById")
	public DataResult<Language> getById(@RequestParam int LanguageId){
		return this.languageService.getById(LanguageId);
	} 
	
	@GetMapping(value="/getAll")
	public DataResult<List<Language>> getAll() {
		return this.languageService.getAll();
	}
	
	@GetMapping(value="/findByCandidateId")
	public DataResult<List<Language>> findByCandidateId(@RequestParam int candidateId){
		return this.languageService.findByCandidateId(candidateId);
	}
}
