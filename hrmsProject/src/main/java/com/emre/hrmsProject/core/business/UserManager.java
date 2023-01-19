package com.emre.hrmsProject.core.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.core.dataAccess.UserDao;
import com.emre.hrmsProject.core.entities.User;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getById(int userId) {
		
		return new SuccessDataResult<User>(this.userDao.getById(userId));
	}

}
