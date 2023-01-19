package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.Candidate;
import com.emre.hrmsProject.entities.dtos.CvDto;


public interface CandidateService extends BaseEntityService<Candidate>{

	DataResult<List<CvDto>> getAllCvDto();
	DataResult<List<CvDto>> cvByCandidateId(int id);
}
