package com.emre.hrmsProject.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.JobAdvertConfirmService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.JobAdvertConfirmDao;
import com.emre.hrmsProject.entities.concretes.JobAdvertConfirm;

@Service
public class JobAdvertConfirmManager implements JobAdvertConfirmService {

	private JobAdvertConfirmDao jobAdvertConfirmDao;
	
	public JobAdvertConfirmManager(JobAdvertConfirmDao jobAdvertConfirmDao) {
		super();
		this.jobAdvertConfirmDao = jobAdvertConfirmDao;
	}

	@Override
	public Result add(JobAdvertConfirm jobAdvertConfirm) {
		jobAdvertConfirm.setConfirmDate(LocalDate.now());
		this.jobAdvertConfirmDao.save(jobAdvertConfirm);
		return new SuccessResult();
	}

	@Override
	public Result update(JobAdvertConfirm jobAdvertConfirm) {
		this.jobAdvertConfirmDao.save(jobAdvertConfirm);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertConfirmDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvertConfirm> getById(int id) {
		
		return new SuccessDataResult<JobAdvertConfirm>(this.jobAdvertConfirmDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertConfirm>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertConfirm>>(this.jobAdvertConfirmDao.findAll());
	}

	@Override
	public DataResult<JobAdvertConfirm> getByJobAdvertId(int jobAdvertId) {
		
		return new SuccessDataResult<JobAdvertConfirm>(this.jobAdvertConfirmDao.getByJobAdvert_Id(jobAdvertId));
	}

}
