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

import kodlamaio.hrms.business.abstracts.WorkExperiencesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperiences;

@RestController
@RequestMapping("api/workExperiences")
@CrossOrigin
public class WorkExperiencesController {
	private WorkExperiencesService workExperiencesService;

	@Autowired
	public WorkExperiencesController(WorkExperiencesService workExperiencesService) {
		super();
		this.workExperiencesService = workExperiencesService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.workExperiencesService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkExperiences workExperiences) {
		return ResponseEntity.ok(this.workExperiencesService.add(workExperiences));
	}
	
	@GetMapping("/getByCandidateIdOrderByStartedYear")
	public ResponseEntity<?> getByCandidateIdOrderByStartedYear(@RequestParam int candidateId)
	{
		return ResponseEntity.ok(this.workExperiencesService.getByCandidateIdOrderByStartedYear(candidateId));
	}
}
