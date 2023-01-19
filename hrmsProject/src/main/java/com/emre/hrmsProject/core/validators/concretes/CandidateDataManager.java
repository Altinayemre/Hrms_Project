package com.emre.hrmsProject.core.validators.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.core.validators.abstracts.CandidateDataValidator;

@Service
public class CandidateDataManager implements CandidateDataValidator{

	@Override
	public Result birthYear(int year) {
		if(year>1921 && year <=2021) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}
		
	}

	@Override
	public Result identityNumber(String identity) {
		String regex="^\\d{11}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(identity);
		if(matcher.matches()) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}	
		
	}

	@Override
	public Result email(String mail) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}
	}

}
