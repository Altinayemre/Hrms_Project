package com.emre.hrmsProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emre.hrmsProject.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByIdentityNumber(String identityNumber);
	Candidate findByEmail(String email);
}
