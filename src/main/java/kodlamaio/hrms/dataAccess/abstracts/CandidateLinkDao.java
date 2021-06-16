package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateLink;
@Repository
public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer>{
	
	List<CandidateLink> getAllByCandidateId(int candidateId);
	
	
}
