package com.emre.hrmsProject.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.emre.hrmsProject.entities.concretes.JobAdvert;
import com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	
	@Query("Select new com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, jt.title, j.openPosition, j.releaseDate, j.deadline)"
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.jobTitle jt "
			+ "Where j.isActive=:isActive")
	List<JobAdvertDetailDto> getAllActiveJobAdvertList(Sort sort,boolean isActive);
	
	@Query("Select new com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, jt.title, j.openPosition, j.releaseDate, j.deadline)"
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.jobTitle jt "
			+ "Where j.isActive=true and e.id=:employerId")
	List<JobAdvertDetailDto> getAllActiveJobAdvertListByEmployer(int employerId);
	
	@Transactional
	@Modifying
	@Query("Update JobAdvert j Set j.isActive=:isActive Where j.id=:jobAdvertId")
	void setJobAdvert(int jobAdvertId, boolean isActive);
	
}
