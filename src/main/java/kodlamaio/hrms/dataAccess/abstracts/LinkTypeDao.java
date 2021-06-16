package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.LinkType;
@Repository
public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {

}
