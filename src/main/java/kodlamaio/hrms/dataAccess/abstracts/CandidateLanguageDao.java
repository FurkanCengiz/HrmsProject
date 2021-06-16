package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
@Repository
public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

	 List<CandidateLanguage> getAllByCandidateId(int candidateId);
}
