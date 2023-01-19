package com.emre.hrmsProject.core.adapters.verifications;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.VerificationCodeCandidateService;
import com.emre.hrmsProject.business.abstracts.VerificationCodeEmployerService;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;

@Service
public class MailServiceAdapter implements VerificationCodeCandidateService,VerificationCodeEmployerService {

	@Override
	public Result sendEmailCandidate() {

		return new SuccessResult();

	}
	
	@Override
	public Result mailVerificationCandidate() {
		
		if(sendEmailCandidate().isSucces()){
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}
		

	}

	@Override
	public Result sendEmailEmployer(String mail) {
		
		return new SuccessResult();
	}

	@Override
	public Result mailVerificationEmployer(String verification) {
		
		if(sendEmailEmployer(verification).isSucces()) {
			return new SuccessResult();
		}else {
			return new ErrorResult();
		}
		
	}

}
