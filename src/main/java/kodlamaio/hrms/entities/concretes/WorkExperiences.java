package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="work_experiences")
public class WorkExperiences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull
	@NotBlank
	@Column(name = "workplace_name")
	private String workplaceName;
	@NotNull
	@NotBlank
	@Column(name ="position")
	private String position;
	@NotNull
	@Column(name ="started_year")
	private LocalDate startedYear;
	
	@Column(name = "finished_year")
	private LocalDate finishedYear;
	
	@JsonIgnore()
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
