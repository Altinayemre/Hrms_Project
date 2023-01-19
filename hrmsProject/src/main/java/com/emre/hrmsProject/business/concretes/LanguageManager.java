package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.LanguageService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.LanguageDao;
import com.emre.hrmsProject.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil bilgisi eklendi");
	}
	
	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("Yabancı dil bilgisi silindi");
	}

	@Override
	public DataResult<List<Language>> findByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findByCandidateId(candidateId),"Dil bilgileri listelendi");
	}

	@Override
	public DataResult<Language> getById(int id) {
		
		return new SuccessDataResult<Language>(this.languageDao.getById(id),"Yabancı dil bilgisi getirildi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Yabancı dil bilgileri listelendi");
	}

}
