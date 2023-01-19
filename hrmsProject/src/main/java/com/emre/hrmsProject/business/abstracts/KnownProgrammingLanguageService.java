package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.KnownProgrammingLanguage;

public interface KnownProgrammingLanguageService extends BaseEntityService<KnownProgrammingLanguage>{

	DataResult<List<KnownProgrammingLanguage>> findByCandidateId(int candidateId);
}
