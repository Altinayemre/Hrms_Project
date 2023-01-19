package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.Language;

public interface LanguageService extends BaseEntityService<Language>{
	
	DataResult<List<Language>> findByCandidateId(int candidateId);

}

