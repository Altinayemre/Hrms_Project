package com.emre.hrmsProject.business.abstracts;


import com.emre.hrmsProject.core.utilities.results.Result;

public interface VerificationCodeCandidateService {
	Result sendEmailCandidate();
	Result mailVerificationCandidate();
}
