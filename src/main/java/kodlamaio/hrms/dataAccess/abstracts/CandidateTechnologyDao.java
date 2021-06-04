package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology, Integer> {

}
