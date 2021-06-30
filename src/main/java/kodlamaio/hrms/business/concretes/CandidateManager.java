package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.WorkExperiencesService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.mernis.EmailValidateService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailValidateService emailValidateService;
	private MernisService mernisService;
	private WorkExperiencesService workExperiencesService;
	private LanguageService languageService;
	private CandidateTechnologyService candidateTechnologyService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateAcademyService candidateAcademyService;
	private CandidateImageService candidateImageService;
	private CandidateLinkService candidateLinkService;
	


	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailValidateService emailValidateService,
			MernisService mernisService, WorkExperiencesService workExperiencesService, LanguageService languageService,
			CandidateTechnologyService candidateTechnologyService, CandidateLanguageService candidateLanguageService,CandidateAcademyService candidateAcademyService,CandidateLinkService candidateLinkService,CandidateImageService candidateImageService) {
		super();
		this.candidateDao = candidateDao;
		this.emailValidateService = emailValidateService;
		this.mernisService = mernisService;
		this.workExperiencesService = workExperiencesService;
		this.languageService = languageService;
		this.candidateTechnologyService = candidateTechnologyService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateAcademyService=candidateAcademyService;
		this.candidateLinkService = candidateLinkService;
		this.candidateImageService =candidateImageService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if (candidate.getEmail() == null || candidate.getNationalityId() ==null) {
				return new ErrorResult("Email ve Tc no boş bırakılamaz");
		}
		if(!this.mernisService.userCheck(candidate.getNationalityId(),candidate.getFirstName(),candidate.getLastName(),candidate.getBirtDate().toString())) {
			return new ErrorResult("Mernis doğrulaması geçersiz.");
		}
		if(candidate.getPassword() == null) {
			return new ErrorResult("Şifre boş bırakılamaz");
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

	
	@Override
	public DataResult<Candidate> getById(int id) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}
	@Override
	public DataResult<CvDto> getCvByCandidateId(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.getById(candidateId).getData());
		cvDto.setWorkExperiences(this.workExperiencesService.getByCandidateIdOrderByStartedYear(candidateId).getData());
		cvDto.setCandidateTechnologies(this.candidateTechnologyService.getAllByCandidateId(candidateId).getData());
		cvDto.setCandidateLanguages(this.candidateLanguageService.getAllByCandidateId(candidateId).getData());
		cvDto.setCandidateAcademies(this.candidateAcademyService.getAllByCandidateIdOrderByFinishedYear(candidateId).getData());
		cvDto.setCandidateImages(this.candidateImageService.getAllByCandidateId(candidateId).getData());
		cvDto.setCandidateLinks(this.candidateLinkService.getAllByCandidateId(candidateId).getData());
		
		return new SuccessDataResult<>(cvDto);
	}

}
