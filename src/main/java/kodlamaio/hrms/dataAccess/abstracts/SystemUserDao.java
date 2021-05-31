package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.SystemUser;
@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {

}
