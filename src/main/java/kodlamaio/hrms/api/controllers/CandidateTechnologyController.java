package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;

@RestController
@RequestMapping("api/candidateTechnology")
public class CandidateTechnologyController {
	private CandidateTechnologyService candidateTechnologyService;

	@Autowired
	public CandidateTechnologyController(CandidateTechnologyService candidateTechnologyService) {
		super();
		this.candidateTechnologyService = candidateTechnologyService;
	}

	@GetMapping("/getall")
	public DataResult<List<CandidateTechnology>> getAll() {
		return this.candidateTechnologyService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateTechnology candidateTechnology) {
		return this.candidateTechnologyService.add(candidateTechnology);
	}
}
