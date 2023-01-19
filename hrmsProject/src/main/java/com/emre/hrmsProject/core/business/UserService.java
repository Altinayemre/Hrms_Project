package com.emre.hrmsProject.core.business;

import com.emre.hrmsProject.core.entities.User;
import com.emre.hrmsProject.core.utilities.results.DataResult;

public interface UserService {
	DataResult<User> getById(int userId);
}
