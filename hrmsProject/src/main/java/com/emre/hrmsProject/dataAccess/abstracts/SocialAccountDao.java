package com.emre.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.SocialAccount;

public interface SocialAccountDao extends JpaRepository<SocialAccount, Integer>{
	List<SocialAccount> findByCandidateId(int candidateId);
}
