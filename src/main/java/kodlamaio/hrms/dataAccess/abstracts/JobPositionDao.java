package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;
@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	List<JobPosition> getByisActiveTrue();
	

	List<JobPosition> getByisActiveTrueAndEmployer_companyName(String companyName);

	List<JobPosition> getByisActiveTrueOrderByCreatedDate();
	
	/*@Query("select new kodlamaio.hrms.entities.dtos.JobPositionDto(e.companyName,t.position,j.quota,c.cityName,j.description,j.createdDate,p.wayOfWorkingName,n.workTypeName) "
			+"from JobPosition j inner join j.employer e inner join j.job t inner join j.city c inner join j.wayOfWorking p inner join j.workType n")
	List<JobPositionDto> getJobPositionWithEmployerDetails();*/
	
	
}
