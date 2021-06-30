package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;
import kodlamaio.hrms.entities.dtos.JobPositionFilter;

@RestController
@RequestMapping("/api/japPositionController")
@CrossOrigin
public class jobPositionController {
	private JobPositionService jobPositionService;

	@Autowired
	public jobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPositionDto jobPositionDto) {
		return this.jobPositionService.add(jobPositionDto);
	}
	
	/*@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}*/

	@PostMapping("/update")
	public Result update(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.update(jobPosition);
	}

	@PostMapping("/delete")
	public Result delete(int id) {
		return this.jobPositionService.delete(id);
	}
	@GetMapping("/getById")
	public DataResult<JobPosition> getById(int id){
	return this.jobPositionService.getById(id);	
	}
	/*@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam  int id){
		return ResponseEntity.ok(this.jobPositionService.getById(id));
	}*/
	
	@GetMapping("/getByIsActiveTrue")
	public  ResponseEntity<?> getByisActiveTrue() {
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveTrue());
	}
	@GetMapping("/getByAllIsActiveFalse")
	public ResponseEntity<?> getByisActiveFalse() {
		return ResponseEntity.ok(this.jobPositionService.getByisActiveFalse());
	}
	
	@PutMapping("/setByisPassivetoActive")
	public ResponseEntity<?> setByisPassivetoActive(@RequestParam int id){
		return ResponseEntity.ok(this.jobPositionService.setByisPassivetoActive(id));
	}
	
	@PostMapping("/setActivetoPassive")
	public ResponseEntity<?> setByisActivetoPassive(@RequestParam int id){
		return ResponseEntity.ok(this.jobPositionService.setByisActivetoPassive(id));
	}
	
	@GetMapping("/getAllByIsActiveAndCompanyName")
	public  ResponseEntity<?> getByisActiveAndCompanyName(String companyName) {
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveAndEmployer_companyName(companyName));
	}
	@GetMapping("/getAllByisActiveAndBycreatedDate")
	public  ResponseEntity<?> getByisActiveOrderByCreatedDate(){
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveTrueOrderByCreatedDate());
	}

	@GetMapping("/getallbyactivatedandworkingplacetypeandworkingtimetypewithpageable")
	public ResponseEntity<?> getByisActiveTrueAndWorkTypeAndWayOfWorkingAndPageble(
		@RequestParam(name = "workTypeId")	int workTypeId,
		@RequestParam(name = "wayOfWorkingId")	int wayOfWorkingId,
		@RequestParam(name = "pageNo") int pageNo, @RequestParam(name = "pageSize") int pageSize)
   {
		
				
		return ResponseEntity.ok(this.jobPositionService.getByisActiveTrueAndWorkTypeAndWayOfWorkingAndPageble(workTypeId, wayOfWorkingId, pageNo, pageSize));
	}
	
	@PostMapping("getByActiveAndFilter")
	@ResponseBody
	public ResponseEntity<?> getByIsActiveAndPageNumberAndFilter(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobPositionFilter jobPositionFilter){
		
		return ResponseEntity.ok(this.jobPositionService.getByIsActiveAndPageNumber(true, pageNo, pageSize));
	}
	
	@GetMapping("getByActiveAndPageable")
	public ResponseEntity<?> getByIsActiveAndPageNumber(@RequestParam int pageNo,@RequestParam int pageSize){
		return ResponseEntity.ok(this.jobPositionService.getByIsActiveAndPageNumber(true, pageNo, pageSize));
	}
	/* 
	

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

	 * 
	 * 
	 * 
	 * @GetMapping("/getJobPositionWithEmployerDetails")
	public ResponseEntity<?> getJobPositionWithEmployerDetails(){
		return ResponseEntity.ok(this.jobPositionService.getJobPositionWithEmployerDetails());
	}*/
	
	
	
}
