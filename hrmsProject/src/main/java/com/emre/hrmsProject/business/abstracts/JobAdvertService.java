package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Employer;
import com.emre.hrmsProject.entities.concretes.JobAdvert;
import com.emre.hrmsProject.entities.dtos.JobAdvertDetailDto;

public interface JobAdvertService extends BaseEntityService<JobAdvert> {
	Result confirm(int jobAdvertId,int employeeId,boolean isConfirmed);
	Result setJobAdvert(int jobAdvertId,boolean isActive);

	DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertList(boolean isActive);
	DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByDate();
	DataResult<List<JobAdvertDetailDto>> getAllActiveJobAdvertListByEmployer(Employer employerId);
	DataResult<List<JobAdvertDetailDto>> getAllOnesThatWaitingForPostingConfirmation();
}
