package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.SchoolService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.SchoolDao;
import com.emre.hrmsProject.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgisi eklendi");
	}
	
	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("Okul bilgisi silindi");
	}

	@Override
	public DataResult<List<School>> sortByGraduationYear(int candidateId) {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "dateOfGraduation");
		
		List<School> schools = this.schoolDao.findByCandidateId(sort, candidateId);
		
		for(School school:schools) {
			if(school.isGraduate()==false) {
				return new SuccessDataResult<List<School>>(schools,"Eğitime devam ediyor.");
			}
		} 
		
		return new SuccessDataResult<List<School>>(schools,"Mezuniyet bilgileri listelendi");	
	}

	@Override
	public DataResult<School> getById(int id) {
		
		return new SuccessDataResult<School>(this.schoolDao.getById(id),"Okul bilgisi getirildi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okul bilgileri listelendi");
	}

}
