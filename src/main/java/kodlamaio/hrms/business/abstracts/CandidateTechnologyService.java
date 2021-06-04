package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyService {

	DataResult<List<CandidateTechnology>> getAll();
	
	Result add(CandidateTechnology candidateTechnology);
}
