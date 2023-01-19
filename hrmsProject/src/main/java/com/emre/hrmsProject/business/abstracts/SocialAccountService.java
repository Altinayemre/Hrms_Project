package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.SocialAccount;

public interface SocialAccountService extends BaseEntityService<SocialAccount>{

	DataResult<List<SocialAccount>> findByCandidateId(int candidateId);
}
