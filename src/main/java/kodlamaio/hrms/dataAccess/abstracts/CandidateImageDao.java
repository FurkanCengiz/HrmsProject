package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateImage;
@Repository
public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer>{
 List<CandidateImage> getAllByCandidateId(int candidateId);
}
