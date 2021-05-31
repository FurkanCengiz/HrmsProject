package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.SystemUserValidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.mernis.EmailValidateService;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailValidateService emailValidateService;
	private SystemUserValidateService systemUserValidateService;
	

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailValidateService emailValidateService,SystemUserValidateService systemUserValidateService) {
		super();
		this.employerDao = employerDao;
		this.emailValidateService =emailValidateService;
		this.systemUserValidateService= systemUserValidateService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Data listelendi");

	}

	@Override
	public Result add(Employer employer) {
		if (employer.getEmail() == null || employer.getCompanyName() == null || employer.getPassword() == null
				|| employer.getWebSite() == null) {
			return new ErrorResult("boş alan bırakılamaz");
		} 
		if (employer.getPassword().length() < 6) {
			return new ErrorResult("şifre en az 6 karakter olmalıdır ");
		} 
		if(!employer.getEmail().contains("@") || !employer.getWebSite().contains("www.")) {
			return new ErrorResult("e posta adresi domain ile eşleşmiyor.");
		}
		else {
			if(!emailValidateService.isEmailCheckRegex(employer.getEmail())) {
				return new ErrorResult("Geçersiz email");
			}else {
				
				if(!systemUserValidateService.isValidatedBySystemUser(employer)) {
					return new ErrorResult("Hesabiniz henüz doğrulanmamıştır");
				}
				else {
					employerDao.save(employer);
					return new SuccessResult("Şirket Eklendi");
				}
			}
			
		}

	}

}
