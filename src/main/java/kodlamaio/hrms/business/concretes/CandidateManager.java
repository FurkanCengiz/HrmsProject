package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.EmailValidateService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailValidateService emailValidateService;
	private MernisService mernisService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailValidateService emailValidateService,
			MernisService mernisService) {
		super();
		this.candidateDao = candidateDao;
		this.emailValidateService = emailValidateService;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if (candidate.getEmail() == null && candidate.getNationalityId() ==null) {
				return new ErrorResult("Email ve Tc no boş bırakılamaz");
		}
		if(!this.mernisService.userCheck(candidate.getNationalityId(),candidate.getFirstName(),candidate.getLastName(),candidate.getBirtDate().toString())) {
			return new ErrorResult("Mernis doğrulaması geçersiz.");
		}
		if(candidate.getPassword() == null) {
			return new ErrorResult("Şifre boş bırakılamaz.");
		}
		else {

		if (!emailValidateService.isEmailCheckRegex(candidate.getEmail())) {
			return new ErrorResult("Geçerisiz email giriniz");
		} 
		if(!emailValidateService.isEmailCheck(candidate.getEmail())) {
			return new ErrorResult("Doğrulama başarısız.");
		}
		else {
				this.candidateDao.save(candidate);
				return new SuccessResult("Kullanıcı eklendi");
			}
		
		}
	}

}
