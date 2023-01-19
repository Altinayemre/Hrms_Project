package com.emre.hrmsProject.business.abstracts;

import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Employer;

public interface EmployeeConfirmEmployerService {
	Result confirmEmployer(Employer employer);
}
