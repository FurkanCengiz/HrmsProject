package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;

@RestController
@RequestMapping("/api/candidateAcademyController")
public class CandidateAcademyController {
	
	private CandidateAcademyService candidateAcademyService;
	@Autowired
	public CandidateAcademyController(CandidateAcademyService candidateAcademyService) {
		super();
		this.candidateAcademyService = candidateAcademyService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateAcademy>> getAll(){
		return this.candidateAcademyService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateAcademy candidateAcademy) {
		return this.candidateAcademyService.add(candidateAcademy);
	}
	
	/*@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateAcademyService.getAll());
	}*/
	
}
