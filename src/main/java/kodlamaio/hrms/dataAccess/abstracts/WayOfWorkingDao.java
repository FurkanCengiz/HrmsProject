package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.WayOfWorking;
@Repository
public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer>{

}
