package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.JobTitleService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.JobTitleDao;
import com.emre.hrmsProject.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {

		if (this.jobTitleDao.findByTitle(jobTitle.getTitle()) != null) {
			return new ErrorResult("Var olan bir iş pozisyonunu tekrar ekleyemezsiniz.");
		} else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult("İş pozisyonu eklendi.");
		}

	}
	
	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobTitleDao.deleteById(id);
		return new SuccessResult("İş pozisyonu silindi");
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "İş pozisyonları listelendi.");
	}
	
	@Override
	public DataResult<JobTitle> getById(int id) {
		
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getById(id),"İş pozisyonu getirildi");
	}

	@Override
	public JobTitle findByTitle(String title) {

		return this.jobTitleDao.findByTitle(title);

	}

}
