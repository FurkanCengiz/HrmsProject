package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateAcademy;
@Repository
public interface CandidateAcademyDao extends JpaRepository<CandidateAcademy, Integer> {

}
