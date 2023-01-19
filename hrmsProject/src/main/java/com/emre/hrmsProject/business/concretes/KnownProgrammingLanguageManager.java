package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.KnownProgrammingLanguageService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.KnownProgramminLanguageDao;
import com.emre.hrmsProject.entities.concretes.KnownProgrammingLanguage;


@Service
public class KnownProgrammingLanguageManager implements KnownProgrammingLanguageService{

	private KnownProgramminLanguageDao knownProgramminLanguageDao;
	
	@Autowired
	public KnownProgrammingLanguageManager(KnownProgramminLanguageDao knownProgramminLanguageDao) {
		super();
		this.knownProgramminLanguageDao = knownProgramminLanguageDao;
	}

	@Override
	public Result add(KnownProgrammingLanguage knownProgrammingLanguage) {
		this.knownProgramminLanguageDao.save(knownProgrammingLanguage);
		return new SuccessResult("Programlama dili eklendi");
	}
	
	@Override
	public Result update(KnownProgrammingLanguage knownProgrammingLanguage) {
		this.knownProgramminLanguageDao.save(knownProgrammingLanguage);
		return new SuccessResult("Programlama dili güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.knownProgramminLanguageDao.deleteById(id);
		return new SuccessResult("Programlama dili silindi");
	}


	@Override
	public DataResult<List<KnownProgrammingLanguage>> findByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<KnownProgrammingLanguage>>(this.knownProgramminLanguageDao.findByCandidateId(candidateId),"Programlama dilleri listelendi");
	}

	@Override
	public DataResult<KnownProgrammingLanguage> getById(int id) {
		
		return new SuccessDataResult<KnownProgrammingLanguage>(this.knownProgramminLanguageDao.getById(id),"Programlama dili getirildi");
	}

	@Override
	public DataResult<List<KnownProgrammingLanguage>> getAll() {
		
		return new SuccessDataResult<List<KnownProgrammingLanguage>>(this.knownProgramminLanguageDao.findAll(),"Programlama dilleri listelendi");
	}
}
