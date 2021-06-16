package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.WorkExperiences;
@Repository
public interface WorkExperiencesDao extends JpaRepository<WorkExperiences, Integer> {

	 List<WorkExperiences> getByCandidateIdOrderByStartedYear(int id);
	 
	
}
