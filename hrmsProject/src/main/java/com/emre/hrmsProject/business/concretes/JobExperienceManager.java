package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.JobExperienceService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.JobExperienceDao;
import com.emre.hrmsProject.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}
	
	@Override
	public Result update(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrübesi silindi");
	}

	@Override
	public DataResult<List<JobExperience>> sortByExperienceYear(int candidateId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "startingDate");
		
		List<JobExperience> experiences =this.jobExperienceDao.findByCandidateId(sort, candidateId);
		
		for(JobExperience experience:experiences) {
			if(experience.isContinue()){
				return new SuccessDataResult<List<JobExperience>>(experiences,"Çalışmaya devam ediyor");
			}
		}
		return new SuccessDataResult<List<JobExperience>>(experiences,"İş deneyimleri");
	}

	
	@Override
	public DataResult<JobExperience> getById(int id) {
		
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.getById(id),"İş tecrübesi getirildi");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"İş tecrübeleri listelendi");
	}

}
