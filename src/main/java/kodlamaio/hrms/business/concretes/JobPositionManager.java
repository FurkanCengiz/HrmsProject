package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş ilan güncellendi");
	}

	@Override
	public Result delete(int id) {
		if(!getById(id).getData().isActive()) {
			this.jobPositionDao.deleteById(id);
			return new SuccessResult("İlan Kaldırıldı");
		}else {
			return new ErrorResult("İş ilanı aktif");
		}
	
	}
    
	@Override
	public DataResult<List<JobPosition>> getByisActiveTrue() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.getByisActiveTrue(),"Tüm aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveAndEmployer_companyName(String companyName) {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.getByisActiveTrueAndEmployer_companyName(companyName),"Tamamlandı");
	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveTrueOrderByCreatedDate() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.getByisActiveTrueOrderByCreatedDate(),"tamamlandı");
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
	
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getOne(id),"id");
	}

}
