package com.emre.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.KnownProgrammingLanguage;

public interface KnownProgramminLanguageDao extends JpaRepository<KnownProgrammingLanguage, Integer>{

	List<KnownProgrammingLanguage> findByCandidateId(int candidateId);
}
