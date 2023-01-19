package com.emre.hrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.CandidateCheckService;
import com.emre.hrmsProject.business.abstracts.CandidateService;
import com.emre.hrmsProject.business.abstracts.VerificationCodeCandidateService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.ErrorResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.core.validators.abstracts.CandidateDataValidator;
import com.emre.hrmsProject.dataAccess.abstracts.CandidateDao;
import com.emre.hrmsProject.entities.concretes.Candidate;
import com.emre.hrmsProject.entities.dtos.CvDto;
import com.emre.hrmsProject.entities.dtos.converter.Converter;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService checkCandidate;
	private VerificationCodeCandidateService verificationCodeCandidate;
	private CandidateDataValidator dataValidator;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService checkCandidate,
			VerificationCodeCandidateService verificationCodeCandidate, CandidateDataValidator dataValidator) {
		this.candidateDao = candidateDao;
		this.checkCandidate = checkCandidate;
		this.verificationCodeCandidate = verificationCodeCandidate;
		this.dataValidator = dataValidator;

	}

	@Override
	public Result add(Candidate candidate) {

		try {

			if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
					|| candidate.getEmail().isEmpty() || candidate.getIdentityNumber().isEmpty()
					|| candidate.getPassword().isEmpty() || candidate.getRepeatPassword().isEmpty()) {

				return new ErrorResult("Lütfen tüm alanları doldurunuz.");

			} else if (!this.dataValidator.birthYear(candidate.getBirthYear()).isSucces()) {

				return new ErrorResult("Geçerli bir doğum yılı giriniz.");

			} else if (!this.dataValidator.identityNumber(candidate.getIdentityNumber()).isSucces()) {
				return new ErrorResult("Lütfen geçerli bir T.C. numarası giriniz.");

			} else if (!this.dataValidator.email(candidate.getEmail()).isSucces()) {
				return new ErrorResult("Lütfen geçerli bir mail adresi giriniz.");
			}

			else if (this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
				return new ErrorResult("T.C. numarası kullanımdadır. Lütfen kontrol ediniz.");

			} else if (this.candidateDao.findByEmail(candidate.getEmail()) != null) {
				return new ErrorResult("E-mail adresi kullanımdadır. Lütfen kontrol ediniz.");

			} else if (!candidate.getPassword().equals(candidate.getRepeatPassword())) {
				return new ErrorResult("Şifreler uyumlu değil. Yeniden deneyiniz");

			}
			
			if (this.checkCandidate.checkCandidate(candidate)
					&& this.verificationCodeCandidate.mailVerificationCandidate().isSucces()) {

				this.candidateDao.save(candidate);
				return new SuccessResult("Kullanıcı başarılı bir şekilde eklendi.");

			} else if (!this.checkCandidate.checkCandidate(candidate)) {
				return new ErrorResult("Mernis doğrulaması başarısız.");

			} else if (!this.verificationCodeCandidate.mailVerificationCandidate().isSucces()) {
				return new ErrorResult("Mail doğrulaması başarısız.");
			}

		} catch (NumberFormatException e) {
			e.getMessage();
		}

		return null;

	}
	
	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("İş arayan silindi");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi");
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {

		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId), "İş arayan getirildi");
	}
	
	@Override
	public DataResult<List<CvDto>> cvByCandidateId(int id) {
		Converter converter = new Converter();
		return new SuccessDataResult<List<CvDto>>(
				this.candidateDao.findById(id).stream().map(converter::convertToCv).collect(Collectors.toList()),
				"Cv getirildi");
	}

	@Override
	public DataResult<List<CvDto>> getAllCvDto() {
		Converter converter = new Converter();
		return new SuccessDataResult<List<CvDto>>(
				this.candidateDao.findAll().stream().map(converter::convertToCv).collect(Collectors.toList()),
				"Cv getirildi");
	}

}
