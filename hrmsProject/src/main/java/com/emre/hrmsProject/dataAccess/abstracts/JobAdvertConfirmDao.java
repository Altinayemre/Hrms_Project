package com.emre.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emre.hrmsProject.entities.concretes.JobAdvertConfirm;

@Repository
public interface JobAdvertConfirmDao extends JpaRepository<JobAdvertConfirm, Integer>{
	JobAdvertConfirm getByJobAdvert_Id(int jobAdvertId);
}
