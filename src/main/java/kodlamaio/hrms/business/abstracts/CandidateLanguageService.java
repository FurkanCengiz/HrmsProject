package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	DataResult<List<CandidateLanguage>> getAll();

	Result add(CandidateLanguage candidateLanguage);

	DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);

	Result addAll(List<CandidateLanguage> candidateLanguages);

}
