package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/japPositionController")
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
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}

	@PostMapping("/update")
	public Result update(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.update(jobPosition);
	}

	@PostMapping("/delete")
	public Result delete(int id) {
		return this.jobPositionService.delete(id);
	}

	@GetMapping("/getByAllIsActive")
	public DataResult<List<JobPosition>> getByisActiveTrue() {
		return this.jobPositionService.getByisActiveTrue();
	}
	@GetMapping("/getAllByIsActiveAndCompanyName")
	public DataResult<List<JobPosition>> getByisActiveAndCompanyName(String companyName) {
		return this.jobPositionService.getByisActiveAndEmployer_companyName(companyName);
	}
	@GetMapping("/getAllByisActiveAndBycreatedDate")
	public DataResult<List<JobPosition>> getByisActiveOrderByCreatedDate(){
		return this.jobPositionService.getByisActiveTrueOrderByCreatedDate();
	}

}
