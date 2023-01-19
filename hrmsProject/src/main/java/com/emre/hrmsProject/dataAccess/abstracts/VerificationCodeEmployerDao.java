package com.emre.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.VerificationCodeEmployer;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer>{

}
