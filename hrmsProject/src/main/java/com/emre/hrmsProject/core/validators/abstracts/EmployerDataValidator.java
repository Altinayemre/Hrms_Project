package com.emre.hrmsProject.core.validators.abstracts;

import com.emre.hrmsProject.core.utilities.results.Result;

public interface EmployerDataValidator {
	Result emailValidator(String mail);
	Result phoneValidator(String phone);
}
