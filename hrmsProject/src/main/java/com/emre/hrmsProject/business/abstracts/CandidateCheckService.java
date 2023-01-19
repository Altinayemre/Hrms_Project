package com.emre.hrmsProject.business.abstracts;

import com.emre.hrmsProject.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean checkCandidate(Candidate candidate);
}
