package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionFilter;



@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	List<JobPosition> getByisActiveTrue();

	List<JobPosition> getByisActiveFalse();

	List<JobPosition> getByisActiveTrueAndEmployer_companyName(String companyName);

	List<JobPosition> getByisActiveTrueOrderByCreatedDate();
	
	List<JobPosition> getByisActiveTrue(Pageable pageable);
	
	List<JobPosition> getByisActiveTrueAndWorkType_IdAndWayOfWorking_Id(Integer workTypeId,Integer wayOfWorkingId,Pageable pageable );
	
	List<JobPosition> getByIsActive(boolean isActive, Pageable pageable);
	
	@Query("Select j from kodlamaio.hrms.entities.concretes.JobPosition j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.jobId}) IS NULL OR j.job.id IN (:#{#filter.jobId}))"
			+ " and ((:#{#filter.wayOfWorkingId}) IS NULL OR j.wayOfWorking.id IN (:#{#filter.wayOfWorkingId}))"
			+ " and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
			+ " and ((:#{#isActive}) IS NULL OR j.isActive = (:#{#isActive}))")
	List<JobPosition> getByFilter(@Param("isActive") boolean isActive,
			@Param("filter") JobPositionFilter jobPositionFilter, Pageable pageable);
			
			
	
	/*private int cityId;
	private int jobId;
	private int workTypeId;
	private int wayOfWorkingId;
	 * @Query("select new kodlamaio.hrms.entities.dtos.JobPositionDto(e.companyName,t.position,j.quota,c.cityName,j.description,j.createdDate,p.wayOfWorkingName,n.workTypeName) "
	 * +"from JobPosition j inner join j.employer e inner join j.job t inner join j.city c inner join j.wayOfWorking p inner join j.workType n"
	 * ) List<JobPositionDto> getJobPositionWithEmployerDetails();
	 */

}
