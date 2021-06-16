package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateTechnology;
@Repository
public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology, Integer> {
  List<CandidateTechnology> getAllByCandidateId(int candidateId);
}
