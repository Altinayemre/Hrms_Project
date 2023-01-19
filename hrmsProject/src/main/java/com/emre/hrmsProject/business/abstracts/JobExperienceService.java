package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.JobExperience;

public interface JobExperienceService extends BaseEntityService<JobExperience>{

	DataResult<List<JobExperience>> sortByExperienceYear(int candidateId);
}
