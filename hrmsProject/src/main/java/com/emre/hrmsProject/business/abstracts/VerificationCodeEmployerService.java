package com.emre.hrmsProject.business.abstracts;

import com.emre.hrmsProject.core.utilities.results.Result;

public interface VerificationCodeEmployerService {
	Result sendEmailEmployer(String mail);
	Result mailVerificationEmployer(String verification);
}
