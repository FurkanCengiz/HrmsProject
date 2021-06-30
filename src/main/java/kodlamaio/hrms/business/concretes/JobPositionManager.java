package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.modelmapper.ModelMapper;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;
import kodlamaio.hrms.entities.dtos.JobPositionFilter;

@Service
public class JobPositionManager implements JobPositionService {
	private JobPositionDao jobPositionDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private WayOfWorkingDao wayOfWorkingDao;
	private JobDao jobDao;
	private WorkTypeDao workTypeDao;


	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, EmployerDao employerDao, CityDao cityDao,
			WayOfWorkingDao wayOfWorkingDao, JobDao jobDao, WorkTypeDao workTypeDao) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.wayOfWorkingDao = wayOfWorkingDao;
		this.jobDao = jobDao;
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "Data listelendi");
	}

	/*
	 * @Override public Result add(JobPositionDto jobPositionDto) {
	 * 
	 * }
	 */

	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş ilan güncellendi");
	}

	@Override
	public Result delete(int id) {
		if (!getById(id).getData().isActive()) {
			this.jobPositionDao.deleteById(id);
			return new SuccessResult("İlan Kaldırıldı");
		} else {
			return new ErrorResult("İş ilanı aktif");
		}

	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveTrue() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByisActiveTrue(),
				"Tüm aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveAndEmployer_companyName(String companyName) {

		return new SuccessDataResult<List<JobPosition>>(
				this.jobPositionDao.getByisActiveTrueAndEmployer_companyName(companyName), "Tamamlandı");
	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveTrueOrderByCreatedDate() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByisActiveTrueOrderByCreatedDate(),
				"tamamlandı");
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		JobPosition jobPosition = jobPositionDao.findById(id).stream().findFirst().get();
		return new SuccessDataResult<JobPosition>(jobPosition, "id");
	}

	/*
	 * @Override public DataResult<List<JobPositionDto>>
	 * getJobPositionWithEmployerDetails() {
	 * 
	 * return new SuccessDataResult<List<JobPositionDto>>(this.jobPositionDao.
	 * getJobPositionWithEmployerDetails()); }
	 */

	@Override
	public Result add(JobPositionDto jobPositionDto) {
		JobPosition jobPosition = new JobPosition();
		jobPosition.setEmployer(this.employerDao.getOne(jobPositionDto.getEmployerId()));
		jobPosition.setCity(this.cityDao.getOne(jobPositionDto.getCityId()));
		jobPosition.setDescription(jobPositionDto.getDescription());
		jobPosition.setDeadline(jobPositionDto.getDeadline());
		jobPosition.setJob(this.jobDao.getOne(jobPositionDto.getJobId()));
		jobPosition.setMaxSalary(jobPositionDto.getMaxSalary());
		jobPosition.setMinSalary(jobPositionDto.getMinSalary());
		jobPosition.setQuota(jobPositionDto.getQuota());
		jobPosition.setWayOfWorking(this.wayOfWorkingDao.getOne(jobPositionDto.getWayOfWorkingId()));
		jobPosition.setWorkType(this.workTypeDao.getOne(jobPositionDto.getWayOfWorkingId()));
		jobPosition.setCreatedDate(LocalDateTime.now());
		jobPosition.setActive(true);
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("eklendi");

	}

	@Override
	public Result setByisActivetoPassive(int id) {
		JobPosition jobPosition = getById(id).getData();
		if (jobPosition.isActive()) {
			jobPosition.setActive(false);
			update(jobPosition);
			return new SuccessResult("ilan pasif duruma geçti");
		} else
			return new ErrorResult("zaten aktif bir ilan");
	}

	@Override
	public Result setByisPassivetoActive(int id) {
		JobPosition jobPosition = getById(id).getData();
		if (jobPosition.isActive() == false) {
			jobPosition.setActive(true);
			update(jobPosition);
			return new SuccessResult("aktif oldu");
		} else
			return new ErrorResult("zaten aktif");
	}

	@Override
	public DataResult<List<JobPosition>> getByisActiveFalse() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByisActiveFalse(), "geldi");
	}

	

	@Override
	public DataResult<List<JobPosition>> getByisActiveTrueAndWorkTypeAndWayOfWorkingAndPageble(int workTypeId,
			int wayOfWorkingId, int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByisActiveTrueAndWorkType_IdAndWayOfWorking_Id(workTypeId, wayOfWorkingId, pageable));
	}

	@Override
	public DataResult<List<JobPosition>> getByIsActiveAndPageNumberAndFilter(boolean isActive, int pageNo,
			int pageSize,JobPositionFilter jobPositionFilter) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.getByFilter(isActive, jobPositionFilter, pageable));
	}

	@Override
	public DataResult<List<JobPosition>> getByIsActiveAndPageNumber(boolean isActice, int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(isActice, pageable));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * @Override public DataResult<List<JobPositionDto>>
	 * getByisActiveAndPageNumberAndFilter(int pageNo, int pageSize, int cityId, int
	 * jobId, int workTypeId, int wayOfWorkingId) { Pageable pageable =
	 * PageRequest.of(pageNo-1, pageSize);
	 * 
	 * return new
	 * SuccessDataResult<List<JobPositionDto>>(this.jobPositionDao.getByFilter(
	 * pageable, cityId, jobId, wayOfWorkingId, workTypeId).getContent()); }
	 */

	/*
	 * @Override public DataResult<List<JobPosition>>
	 * getByisActiveAndPageNumberAndFilter(int pageNo, int pageSize,
	 * JobPositionFilter jobPositionFilter) { Pageable pageable =
	 * PageRequest.of(pageNo-1, pageSize); return new
	 * SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByFilter(
	 * jobPositionFilter, pageable).getContent(),
	 * this.jobPositionDao.getByFilter(jobPositionFilter,
	 * pageable).getNumberOfElements()+"listelendi"); }
	 */

	/*
	 * @Override public DataResult<List<JobPosition>> getByisActiveTrue() {
	 * 
	 * return new SuccessDataResult<List<JobPosition>>
	 * (this.jobPositionDao.getByisActiveTrue(),"Tüm aktif ilanlar listelendi"); }
	 */

	/*
	 * @Override public DataResult<JobPosition> getByJobPositionId(int id) {
	 * JobPosition
	 * jobPosition=jobPositionDao.findById(id).stream().findFirst().get(); return
	 * new SuccessDataResult<JobPosition>(jobPosition,"Listlendi"); }
	 */

}
