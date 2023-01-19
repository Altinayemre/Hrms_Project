package com.emre.hrmsProject.business.abstracts;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.entities.concretes.JobAdvertConfirm;

public interface JobAdvertConfirmService extends BaseEntityService<JobAdvertConfirm> {
	DataResult<JobAdvertConfirm> getByJobAdvertId(int jobAdvertId);
}
