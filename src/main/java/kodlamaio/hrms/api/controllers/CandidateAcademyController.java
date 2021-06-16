package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateAcademyService;
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
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidateAcademyService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateAcademy candidateAcademy) {

		return ResponseEntity.ok(this.candidateAcademyService.add(candidateAcademy));
	}

	@PostMapping("/getallbycandidateorderbyfinishedyear")
	public ResponseEntity<?> getAllByCandidateIdOrderByFinishedYear(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.candidateAcademyService.getAllByCandidateIdOrderByFinishedYear(candidateId));

	}

}