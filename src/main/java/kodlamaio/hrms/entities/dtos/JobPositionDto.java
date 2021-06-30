package kodlamaio.hrms.entities.dtos;
import java.sql.Date;
import java.time.LocalDateTime;
import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionDto implements Dto{
	private int cityId;
	private int employerId;
	private int jobId;
	   //private String companyName;
	  // private String position;
	private int quota;
	  // private String cityName;
	private Date deadline;
	private String description;
	private Double maxSalary;
	private Double minSalary;
	private LocalDateTime createdDate;
	private int wayOfWorkingId;
	private int workTypeId;
	
	
	
}
