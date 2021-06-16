package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
@Service
public class CandidateLanguageManager implements CandidateLanguageService{
	
	private CandidateLanguageDao candidateLanguageDao;
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao =candidateLanguageDao;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		
		return new SuccessDataResult<List<CandidateLanguage>>(candidateLanguageDao.findAll());
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Eklendi");
	}



	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguages) {
		candidateLanguageDao.saveAll(candidateLanguages);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getAllByCandidateId(candidateId),"eklendi");
		
	}

}
