package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "wayof_working_id")
	private WayOfWorking wayOfWorking;
	
	@ManyToOne()
	@JoinColumn(name = "work_type_id")
	private WorkType workType;

	@Column(name = "description")
	private String description;
	
	@Column(name = "quota")
	private int quota;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "max_salary")
	private Double maxSalary;
	
	@Column(name = "min_salary")
	private Double minSalary;
	
	@Column(name = "is_active")
	private boolean isActive;

}
