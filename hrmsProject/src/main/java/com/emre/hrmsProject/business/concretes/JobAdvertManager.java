package com.emre.hrmsProject.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.EmployeeService;
import com.emre.hrmsProject.business.abstracts.JobAdvertConfirmService;
import com.emre.hrmsProject.business.abstracts.JobAdvertService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.JobAdvertDao;
import com.emre.hrmsProject.entities.concretes.Employee;
import com.emre.hrmsProject.entities.concretes.Employer;
import com.emre.hrmsProject.entities.concretes.JobAdvert;
import com.emre.hrmsProject.entities.concretes.JobAdvertConfirm;
import com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto;


@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	private JobAdvertConfirmService jobAdvertConfirmService;
	private EmployeeService employeeService;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, JobAdvertConfirmService jobAdvertConfirmService,
			EmployeeService employeeService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.jobAdvertConfirmService = jobAdvertConfirmService;
		this.employeeService = employeeService;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvert.setReleaseDate(LocalDate.now());
		jobAdvert.setActive(false);
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı onay aşamasındadır");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("ilan güncellendi.");
	}
	
	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("ilan silindi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertList(boolean isActive) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");

		return new SuccessDataResult<List<JobAdvertDetailDto>>(
				this.jobAdvertDao.getAllActiveJobAdvertList(sort, isActive));
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByDate() {

		Sort sort = Sort.by(Sort.Direction.ASC, "releaseDate");

		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdvertDao.getAllActiveJobAdvertList(sort, true),
				"Tarihe göre aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByEmployer(Employer employerId) {

		return new SuccessDataResult<List<JobAdvertDetailDto>>(
				this.jobAdvertDao.getAllActiveJobAdvertListByEmployer(employerId.getId()),
				"Firmaya göre aktif iş ilanları listelendi");

	}

	@Override
	public Result setJobAdvert(int jobAdvertId, boolean isActive) {

		if (isActive) {
			this.jobAdvertDao.setJobAdvert(jobAdvertId, isActive);
			return new SuccessResult("İlan aktifleştirildi");
		} else {
			this.jobAdvertDao.setJobAdvert(jobAdvertId, isActive);
			return new SuccessResult("İlan pasifleştirildi");
		}
	}

	@Override
	public DataResult<JobAdvert> getById(int jobAdvertId) {

		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(jobAdvertId), "İş ilanı getirildi");
	}

	@Override
	public Result confirm(int jobAdvertId, int employeeId, boolean isConfirmed) {
		JobAdvert jobAdvert = getById(jobAdvertId).getData();
		Employee employee = this.employeeService.getById(employeeId).getData();

		if (!isConfirmed) {
			delete(jobAdvert.getId());
			return new ErrorResult("İş ilanı onaylanmadı");
		} else {
			jobAdvert.setActive(true);
			this.jobAdvertDao.save(jobAdvert);
			jobAdvertConfirmService.add(new JobAdvertConfirm(jobAdvert, employee, isConfirmed));
			return new SuccessResult("İş ilanı onaylandı");
		}

	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getAllOnesThatWaitingForPostingConfirmation() {
		List<JobAdvertDetailDto> result = new ArrayList<JobAdvertDetailDto>();
		List<JobAdvertDetailDto> passiveJobAdvert = getAllActiveJobAdvertList(false).getData();

		for (JobAdvertDetailDto jobAdvert : passiveJobAdvert) {
			if (this.jobAdvertConfirmService.getByJobAdvertId(jobAdvert.getId()).getData() == null) {
				result.add(jobAdvert);
			}
		}

		return new SuccessDataResult<List<JobAdvertDetailDto>>(result, "Onay bekleyen iş ilanları listelendi");
	}

}