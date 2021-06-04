package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateAcademyDao;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;

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
	public Result add(CandidateAcademy candidateAcademy) {
		this.candidateAcademyDao.save(candidateAcademy);
		
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result addAll(List<CandidateAcademy> candidateAcademies) {
		candidateAcademyDao.saveAll(candidateAcademies);
		return new SuccessResult("geldiler");
	}

	

}
