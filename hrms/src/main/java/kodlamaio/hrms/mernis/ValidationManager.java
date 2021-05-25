package kodlamaio.hrms.mernis;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class ValidationManager implements ValidationService {

	@Override
	public boolean validate(Candidate candidate) {
		
		if(candidate.getFirstName() == "furkan" && candidate.getLastName()=="cengiz") {
			
			return true;
			
		}else {
			
		return false;
		
		}
		
	}
	

}
