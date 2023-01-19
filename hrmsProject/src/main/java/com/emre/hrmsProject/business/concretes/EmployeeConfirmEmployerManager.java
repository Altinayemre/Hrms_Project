package com.emre.hrmsProject.business.concretes;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.EmployeeConfirmEmployerService;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.entities.concretes.Employer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService{

	@Override
	public Result confirmEmployer(Employer employer) {
		
		if(!employer.getCompanyName().isEmpty()){
			return new SuccessResult();
		}
			return new ErrorResult();
		
	}

}
