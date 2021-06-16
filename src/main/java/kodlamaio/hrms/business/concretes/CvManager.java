package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.WorkExperiencesService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;
import kodlamaio.hrms.entities.dtos.CvDto;
@Service
public class CvManager implements CvService{
	
	
	
	private CandidateTechnologyService candidateTechnologyService;
	private CandidateLanguageService candidateLanguageService;
	private WorkExperiencesService workExperiencesService;
	private CandidateService candidateService;
	private CandidateAcademyService candidateAcademyService;
	private CandidateImageService candidateImageService;
	private CandidateLinkService candidateLinkService;
	
	
	@Autowired
	public CvManager(CandidateService candidateService, 
			CandidateTechnologyService candidateTechnologyService, CandidateLanguageService candidateLanguageService,
			WorkExperiencesService workExperiencesService,CandidateAcademyService candidateAcademyService,CandidateImageService candidateImageService,CandidateLinkService candidateLinkService) {
		super();
		this.candidateService = candidateService;
		this.candidateTechnologyService = candidateTechnologyService;
		this.candidateLanguageService = candidateLanguageService;
		this.workExperiencesService = workExperiencesService;
		this.candidateAcademyService= candidateAcademyService;
		this.candidateImageService = candidateImageService;
		this.candidateLinkService = candidateLinkService;
	}



	@Override
	public Result add(CvDto cvDto, int candidateId) {
	Candidate candidate = candidateService.getById(candidateId).getData();
	cvDto.setCandidate(candidate);
	cvDto.getWorkExperiences().forEach(workExperiences -> workExperiences.setCandidate(candidate));
	workExperiencesService.addAll(cvDto.getWorkExperiences());
	cvDto.getCandidateTechnologies().forEach(candidateTechnology -> candidateTechnology.setCandidate(candidate));
	candidateTechnologyService.addAll(cvDto.getCandidateTechnologies());
	cvDto.getCandidateLanguages().forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
	candidateLanguageService.addAll(cvDto.getCandidateLanguages());
	cvDto.getCandidateAcademies().forEach(CandidateAcademy -> CandidateAcademy.setCandidate(candidate));
	candidateAcademyService.addAll(cvDto.getCandidateAcademies());
	cvDto.getCandidateImages().forEach(candidateImage -> candidateImage.setCandidate(candidate));
	candidateImageService.addAll(cvDto.getCandidateImages());
	cvDto.getCandidateLinks().forEach(candidateLink-> candidateLink.setCandidate(candidate));
	candidateLinkService.addAll(cvDto.getCandidateLinks());
	
	return new SuccessResult("Cv eklendi");
		
	}

}
