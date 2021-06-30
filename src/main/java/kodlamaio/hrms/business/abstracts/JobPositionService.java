package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;
import kodlamaio.hrms.entities.dtos.JobPositionFilter;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();

	Result add(JobPositionDto jobPositionDto);
	
	Result update(JobPosition jobPosition);

	Result delete(int id);
	
	Result setByisActivetoPassive(int id);
	
	Result setByisPassivetoActive(int id);
	
	//DataResult<List<JobPosition>> updateActive(int id,boolean isActive);
	
	DataResult<List<JobPosition>> getByisActiveTrue();
	
	DataResult<List<JobPosition>> getByisActiveFalse();

	DataResult<List<JobPosition>> getByisActiveAndEmployer_companyName(String companyName);

	DataResult<List<JobPosition>> getByisActiveTrueOrderByCreatedDate();
	

	DataResult<List<JobPosition>> getByisActiveTrueAndWorkTypeAndWayOfWorkingAndPageble(int workTypeId, int wayOfWorkingId,int pageNo,int pageSize);
	
	DataResult<List<JobPosition>> getByIsActiveAndPageNumberAndFilter(boolean isActive, int pageNo,int pageSize,JobPositionFilter jobPositionFilter);

	DataResult<List<JobPosition>> getByIsActiveAndPageNumber(boolean isActice, int pageNo,int pageSize);
	
	//DataResult<JobPosition> getByJobPositionId(int id);
	
	DataResult<JobPosition> getById(int id);
	
	//DataResult<List<JobPositionDto>> getJobPositionWithEmployerDetails();

}
