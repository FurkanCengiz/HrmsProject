package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateAcademyDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CandidateAcademyManager implements CandidateAcademyService{
 
	private CandidateAcademyDao candidateAcademyDao;
 
 	@Autowired
	public CandidateAcademyManager(CandidateAcademyDao candidateAcademyDao) {
	super();
	this.candidateAcademyDao = candidateAcademyDao;
 }

	@Override
	public DataResult<List<CandidateAcademy>> getAll() {
	
		return new SuccessDataResult<List<CandidateAcademy>>(candidateAcademyDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(CandidateAcademy  candidateAcademy) {
		//CandidateAcademy candidateAcademy = candidateAcademyDtoToCandidateAcademyConverter(candidateAcademyDto);
		//candidateAcademyDao.save(candidateAcademy);
		this.candidateAcademyDao.save(candidateAcademy);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result addAll(List<CandidateAcademy> candidateAcademies) {
		candidateAcademyDao.saveAll(candidateAcademies);
		return new SuccessResult("geldiler");
	}

	@Override
	public DataResult<List<CandidateAcademy>> getAllByCandidateIdOrderByFinishedYear(int candidateId) {
		
		return new SuccessDataResult<List<CandidateAcademy>>(this.candidateAcademyDao.getAllByCandidateIdOrderByFinishedYear(candidateId),"listelendi");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//private CandidateAcademy candidateAcademyDtoToCandidateAcademyConverter(CandidateAcademyDto candidateAcademyDto) {
		
		//int candidateId=1;
		//Candidate candidate=new Candidate(candidateId);
		//return new CandidateAcademy(candidate,candidateAcademyDto.getSchoolName(),candidateAcademyDto.getDepartmentName(),candidateAcademyDto.getStartedYear(),candidateAcademyDto.getFinishedYear());
	//}

	/*private CandidateAcademy cvDtoToWorkAcademyConcerter(CvDto cvDto) {
		int candidateId = 1;
		Candidate candidate = new Candidate();
		return new CandidateAcademy(candidate, cvDto.getCandidateAcademies());
	}*/

}
