package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class SystemUserValidatemManager implements SystemUserValidateService {

	@Override
	public boolean isValidatedBySystemUser(Employer employer) {
	
		
		return true;
		
	}

}
