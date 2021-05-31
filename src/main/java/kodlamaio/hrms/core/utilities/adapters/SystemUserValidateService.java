package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.entities.concretes.Employer;

public interface SystemUserValidateService {
	boolean isValidatedBySystemUser(Employer employer);
}
