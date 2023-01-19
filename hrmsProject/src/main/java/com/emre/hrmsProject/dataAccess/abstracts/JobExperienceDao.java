package com.emre.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.JobExperience;


public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	List<JobExperience> findByCandidateId(Sort sort,int candidateId);
}
