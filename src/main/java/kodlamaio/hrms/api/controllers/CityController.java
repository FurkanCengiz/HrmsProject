package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public  ResponseEntity<?>  getAll(){
		return  ResponseEntity.ok(this.cityService.getAll());
	}
	
}
