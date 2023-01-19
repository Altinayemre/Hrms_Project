package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.SocialAccountService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.SocialAccountDao;
import com.emre.hrmsProject.entities.concretes.SocialAccount;

@Service
public class SocialAccountManager implements SocialAccountService{
	private SocialAccountDao socialAccountDao;
	
	@Autowired
	public SocialAccountManager(SocialAccountDao socialAccountDao) {
		super();
		this.socialAccountDao = socialAccountDao;
	}

	@Override
	public Result add(SocialAccount socialAccount) {
		this.socialAccountDao.save(socialAccount);
		return new SuccessResult("Hesap eklendi");
	}
	
	@Override
	public Result update(SocialAccount socialAccount) {
		this.socialAccountDao.save(socialAccount);
		return new SuccessResult("Hesap güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.socialAccountDao.deleteById(id);
		return new SuccessResult("Hesap silindi");
	}

	@Override
	public DataResult<List<SocialAccount>> findByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<SocialAccount>>(this.socialAccountDao.findByCandidateId(candidateId),"Hesaplar listelendi");
	}

	@Override
	public DataResult<SocialAccount> getById(int id) {
		
		return new SuccessDataResult<SocialAccount>(this.socialAccountDao.getById(id),"Hesap getirildi");
	}

	@Override
	public DataResult<List<SocialAccount>> getAll() {
		
		return new SuccessDataResult<List<SocialAccount>>(this.socialAccountDao.findAll(),"Hesaplar listelendi");
	}
	
	
}
