package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.CoverLetterService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.CoverLetterDao;
import com.emre.hrmsProject.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı güncellendi");
	}
	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Ön yazı silindi");
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(id),"Ön yazı getirildi");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(),"Ön yazılar listelendi");
	}

}
