package com.emre.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emre.hrmsProject.entities.concretes.Employer;


@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findByEmail(String mail);
}
