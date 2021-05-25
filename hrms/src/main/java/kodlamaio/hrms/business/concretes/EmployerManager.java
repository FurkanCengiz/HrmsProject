package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Data listelendi");

	}

	@Override
	public Result add(Employer employer) {
		if(employer.getEmail() == null || employer.getCompanyName()== null || employer.getPassword()==null || employer.getWebSite() == null ) {
			return new ErrorResult("boş alan bırakılamaz");
		}else if(employer.getPassword().length()<6) {
			return new ErrorResult("şifre en az 6 karakter olmalıdır ");
		}else if(employerDao.findAllByEmail(employer.getEmail()).stream().count() !=0) {
			return new ErrorResult("Bu email zaten kayıtlı");
		}else {
			employerDao.save(employer);
			return new SuccessResult("Eklendi");
		}
		
	}

}
