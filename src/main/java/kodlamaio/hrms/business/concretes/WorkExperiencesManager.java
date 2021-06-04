package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperiencesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperiencesDao;
import kodlamaio.hrms.entities.concretes.WorkExperiences;
@Service
public class WorkExperiencesManager implements WorkExperiencesService{
	
	private WorkExperiencesDao workExperiencesDao;
	@Autowired
	public WorkExperiencesManager(WorkExperiencesDao workExperiencesDao) {
		super();
		this.workExperiencesDao = workExperiencesDao;
	}

	@Override
	public DataResult<List<WorkExperiences>> getAll() {
		
		return new SuccessDataResult<List<WorkExperiences>>(workExperiencesDao.findAll(),"Data listelendi.");
		
	}

	@Override
	public Result add(WorkExperiences workExperiences) {
		this.workExperiencesDao.save(workExperiences);
		return new SuccessResult("Eklendi");
	}
	
}
