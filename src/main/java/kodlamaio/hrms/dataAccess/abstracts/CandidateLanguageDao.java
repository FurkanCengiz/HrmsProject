package kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
@Repository
public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

	 CandidateLanguage getByCandidateId(int candidateId);
}
