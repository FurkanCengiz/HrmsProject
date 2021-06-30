package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<Employer> getByisActiveUpdateTrue();
	List<Employer> getByisActiveUpdateFalse();

	Employer getByEmail(String email);
	
}
