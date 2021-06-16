package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

@RestController
@RequestMapping("api/jobs")
@CrossOrigin
public class jobController {

	private JobService jobService;

	@Autowired
	public jobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getall")
	public  ResponseEntity<?> getAll() {
		return  ResponseEntity.ok(this.jobService.getAll());
	}

	@PostMapping("/add")
	public  ResponseEntity<?> add(@RequestBody Job job) {
		return  ResponseEntity.ok(this.jobService.add(job));
	}

}
