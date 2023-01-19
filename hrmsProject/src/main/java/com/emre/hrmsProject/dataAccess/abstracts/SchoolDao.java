package com.emre.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	List<School> findByCandidateId(Sort sort,int candidateId);
}
