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

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("api/employers")
@CrossOrigin
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService=employerService;}
	
	@GetMapping("/getall")
	public  ResponseEntity<?> getAll(){
		return  ResponseEntity.ok(employerService.getAll());
	}
	
	@PostMapping("/add")
	public  ResponseEntity<?> add(@RequestBody Employer employer) {
	 return  ResponseEntity.ok(employerService.add(employer));
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<Employer> getByEmployerId(int id){
		return this.employerService.getByEmployerId(id);
	}
	
	

	}
