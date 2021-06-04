package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkExperiences;

public interface WorkExperiencesDao extends JpaRepository<WorkExperiences, Integer> {

}
