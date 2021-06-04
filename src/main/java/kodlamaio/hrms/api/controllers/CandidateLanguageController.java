package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateAcademyDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidateLanguageController")
public class CandidateLanguageController {
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}

	@GetMapping("/getall")
	public DataResult<List<CandidateLanguage>> gettAll() {
		return this.candidateLanguageService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage) {
		return this.candidateLanguageService.add(candidateLanguage);

	}
	
	

}
