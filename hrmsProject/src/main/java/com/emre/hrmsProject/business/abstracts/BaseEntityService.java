package com.emre.hrmsProject.business.abstracts;

import java.util.List;

import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;

public interface BaseEntityService<T>{
	Result add(T entity);
	Result update(T entity);
	Result delete(int id);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();
}
