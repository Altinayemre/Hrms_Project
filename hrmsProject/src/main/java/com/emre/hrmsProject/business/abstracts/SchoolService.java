package com.emre.hrmsProject.business.abstracts;

import java.util.List;


import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.School;

public interface SchoolService extends BaseEntityService<School>{

	DataResult<List<School>> sortByGraduationYear(int CandidateId);
}
