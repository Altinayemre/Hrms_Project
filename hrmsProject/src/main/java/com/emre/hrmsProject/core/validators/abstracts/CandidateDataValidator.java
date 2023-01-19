package com.emre.hrmsProject.core.validators.abstracts;

import com.emre.hrmsProject.core.utilities.results.Result;

public interface CandidateDataValidator {
	Result birthYear(int year);
	Result identityNumber(String identity);
	Result email(String mail);
		
	
}
