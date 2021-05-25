package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.ValidationService;
@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ValidationService validationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, ValidationService validationService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {

		if (validationService.validate(candidate) == false) {
			return new ErrorResult("Eklenemedi");
		} else {
			candidateDao.save(candidate);
			return new SuccessResult("Eklendi");
		}

	}

}
