package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateTechnologyDao;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;

@Service
public class CandidateTechnologyManager implements CandidateTechnologyService {
private CandidateTechnologyDao candidateTechnologyDao;
@Autowired
public CandidateTechnologyManager(CandidateTechnologyDao candidateTechnologyDao) {
	super();
	this.candidateTechnologyDao = candidateTechnologyDao;
}
@Override
public DataResult<List<CandidateTechnology>> getAll() {
	
	return new SuccessDataResult<List<CandidateTechnology>>(candidateTechnologyDao.findAll(),"Data Listelendi");
}
@Override
public Result add(CandidateTechnology candidateTechnology) {
	this.candidateTechnologyDao.save(candidateTechnology);
	return new SuccessResult("Eklendi");
}
@Override
public Result addAll(List<CandidateTechnology> candidateTechnologies) {
	this.candidateTechnologyDao.saveAll(candidateTechnologies);
	return new SuccessResult("Eklendi");
}
@Override
public DataResult<List<CandidateTechnology>> getAllByCandidateId(int candidateId) {
	// TODO Auto-generated method stub
	return new SuccessDataResult<List<CandidateTechnology>>(this.candidateTechnologyDao.getAllByCandidateId(candidateId));
	
}
}