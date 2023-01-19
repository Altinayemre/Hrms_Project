package com.emre.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.EmployeeConfirmEmployerService;
import com.emre.hrmsProject.business.abstracts.EmployerService;
import com.emre.hrmsProject.business.abstracts.VerificationCodeEmployerService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.core.validators.abstracts.EmployerDataValidator;
import com.emre.hrmsProject.dataAccess.abstracts.EmployerDao;
import com.emre.hrmsProject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerDataValidator dataValidator;
	private EmployeeConfirmEmployerService employerConfirm;
	private VerificationCodeEmployerService verificationCodeEmployer;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerDataValidator dataValidator,
			EmployeeConfirmEmployerService employerConfirm, VerificationCodeEmployerService verificationCodeEmployer) {
		super();
		this.employerDao = employerDao;
		this.dataValidator = dataValidator;
		this.employerConfirm = employerConfirm;
		this.verificationCodeEmployer = verificationCodeEmployer;
	}

	@Override
	public Result add(Employer employer) {

		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmail().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getPassword().isEmpty()
				|| employer.getRepeatPassword().isEmpty()) {

			return new ErrorResult("Lütfen tüm alanları doldurunuz.");

		} else if (!this.dataValidator.emailValidator(employer.getEmail()).isSucces()) {
			return new ErrorResult("Lütfen geçerli bir mail adresi giriniz.");

		} else if (!this.dataValidator.phoneValidator(employer.getPhoneNumber()).isSucces()) {
			return new ErrorResult("Lütfen telefon numarasını kontrol ediniz.");

		} else if (!employer.getPassword().equals(employer.getRepeatPassword())) {
			return new ErrorResult("Şifreler uyumlu değil. Lütfen tekrar deneyiniz.");

		} else if (this.employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("Daha önce bu mail adresi kullanılmıştır.");

		} if (this.employerConfirm.confirmEmployer(employer).isSucces()
				&& this.verificationCodeEmployer.mailVerificationEmployer(employer.getEmail()).isSucces()) {
			
			this.employerDao.save(employer);
			return new SuccessResult("Kullanıcı sisteme başarılı bir şekilde eklendi.");
			
		} else if (!this.verificationCodeEmployer.mailVerificationEmployer(employer.getEmail()).isSucces()) {
			return new ErrorResult("Mail doğrulaması başarısız.");
			
		} else if(!this.employerConfirm.confirmEmployer(employer).isSucces()){
			return new ErrorResult("Personel tarafından onaylanmadı.");
		}
		
		return null;
	}
	
	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İş veren güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("İş veren silindi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
	}
	
	@Override
	public DataResult<Employer> getById(int employerId) {
		
		return new SuccessDataResult<Employer>(this.employerDao.getById(employerId),"İş veren getirildi");
	}

}
