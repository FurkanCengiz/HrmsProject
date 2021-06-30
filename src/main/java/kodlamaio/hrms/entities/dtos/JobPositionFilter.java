package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionFilter {
	private int cityId;
	private int jobId;
	private int workTypeId;
	private int wayOfWorkingId;
	
}
