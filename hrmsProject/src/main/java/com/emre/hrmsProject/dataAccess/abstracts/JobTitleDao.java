package com.emre.hrmsProject.dataAccess.abstracts;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emre.hrmsProject.entities.concretes.JobTitle;

@Repository
public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	JobTitle findByTitle(String prefix);
	
}
