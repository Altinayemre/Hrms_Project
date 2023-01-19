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

import com.emre.hrmsProject.business.abstracts.SocialAccountService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.SocialAccount;

@RestController
@RequestMapping(value="/api/social-accounts")
@CrossOrigin
public class SocialAccountsController {

	private SocialAccountService socialAccountService;
	
	@Autowired
	public SocialAccountsController(SocialAccountService socialAccountService) {
		super();
		this.socialAccountService = socialAccountService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody SocialAccount socialAccount) {
		return this.socialAccountService.add(socialAccount);
	}
	
	@PutMapping(value="/update")
	public Result update(@RequestBody SocialAccount socialAccount) {
		return this.socialAccountService.update(socialAccount);
	}
	
	@DeleteMapping(value="/delete")
	public Result delete(@RequestParam int socialAccountId) {
		return this.socialAccountService.delete(socialAccountId);
	}
	
	
	@GetMapping(value="/getById")
	public DataResult<SocialAccount> getById(@RequestParam int socialAccountId){
		return this.socialAccountService.getById(socialAccountId);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<SocialAccount>> getAll(){
		return this.socialAccountService.getAll();
	}
	
	@GetMapping(value="/findByCandidateId")
	public DataResult<List<SocialAccount>> findByCandidateId(@RequestParam int candidateId) {
		return this.socialAccountService.findByCandidateId(candidateId);
	}
}
