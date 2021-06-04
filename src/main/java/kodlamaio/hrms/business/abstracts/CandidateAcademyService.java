package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;

public interface CandidateAcademyService {

	
	DataResult<List<CandidateAcademy>> getAll();
	
	Result add(CandidateAcademy candidateAcademy);
	
	Result addAll(List<CandidateAcademy> candidateAcademies);
}
