package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;

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
	
	@GetMapping("/getByAllIsActive")
	public  ResponseEntity<?> getByisActiveTrue() {
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveTrue());
	}
	@GetMapping("/getAllByIsActiveAndCompanyName")
	public  ResponseEntity<?> getByisActiveAndCompanyName(String companyName) {
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveAndEmployer_companyName(companyName));
	}
	@GetMapping("/getAllByisActiveAndBycreatedDate")
	public  ResponseEntity<?> getByisActiveOrderByCreatedDate(){
		return  ResponseEntity.ok(this.jobPositionService.getByisActiveTrueOrderByCreatedDate());
	}
	/*@GetMapping("/getJobPositionWithEmployerDetails")
	public ResponseEntity<?> getJobPositionWithEmployerDetails(){
		return ResponseEntity.ok(this.jobPositionService.getJobPositionWithEmployerDetails());
	}*/

}
