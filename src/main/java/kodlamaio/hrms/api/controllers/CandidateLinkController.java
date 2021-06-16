package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidatelink")
public class CandidateLinkController {
private CandidateLinkService candidateLinkService;
@Autowired
public CandidateLinkController(CandidateLinkService candidateLinkService) {
	super();
	this.candidateLinkService = candidateLinkService;
}

public ResponseEntity<?> add(@RequestBody CandidateLink candidateLink){
	return ResponseEntity.ok(this.candidateLinkService.add(candidateLink));
}

public ResponseEntity<?> getAll(){
	return ResponseEntity.ok(this.candidateLinkService.getAll());
}


	
	
}
