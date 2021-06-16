package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateAcademy;
@Repository
public interface CandidateAcademyDao extends JpaRepository<CandidateAcademy, Integer> {

	List<CandidateAcademy> getAllByCandidateIdOrderByFinishedYear(int candidateId);
}
