package com.emre.hrmsProject.core.validators.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.core.validators.abstracts.EmployerDataValidator;

@Service
public class EmployerDataManager implements EmployerDataValidator {

	@Override
	public Result emailValidator(String mail) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}

	}

	@Override
	public Result phoneValidator(String phone) {
		String regex = "^(\\d{3}[- .]?){2}\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches()) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}

	}

}
