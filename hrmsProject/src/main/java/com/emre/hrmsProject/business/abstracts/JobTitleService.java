package com.emre.hrmsProject.business.abstracts;

import com.emre.hrmsProject.entities.concretes.JobTitle;

public interface JobTitleService extends BaseEntityService<JobTitle>{
	
	JobTitle findByTitle(String title);
	
}
