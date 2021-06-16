package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkTypeService;
import kodlamaio.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linktype")
@CrossOrigin
public class LinkTypeController {
private LinkTypeService linkTypeService;

public ResponseEntity<?> add(@RequestBody LinkType linkType){
	return ResponseEntity.ok(this.linkTypeService.add(linkType));
}
@GetMapping("/getall")
public ResponseEntity<?> getAll(){
   return ResponseEntity.ok(this.linkTypeService.getAll());
}

}
