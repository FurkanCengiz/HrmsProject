package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperiences;

public interface WorkExperiencesService {
 DataResult<List<WorkExperiences>> getAll();
 Result add(WorkExperiences workExperiences);
 
}
