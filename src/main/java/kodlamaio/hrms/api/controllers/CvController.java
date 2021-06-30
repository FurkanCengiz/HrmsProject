package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvController {
		private CvService cvService;
		@Autowired
		public CvController(CvService cvService) {
			super();
			this.cvService = cvService;
		}
		@PostMapping("/add")
		public ResponseEntity<?> add(@RequestBody @Valid CvDto cvDto,int candidateId){
			return ResponseEntity.ok(cvService.add(cvDto, candidateId));
		}
		@PutMapping("/updateCv")
		public ResponseEntity<?> update(@RequestBody @Valid CvDto cvDto,int candidateId){
			return ResponseEntity.ok(cvService.update(cvDto, candidateId));
		}
		
		
}
