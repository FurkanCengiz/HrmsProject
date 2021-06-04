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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_academies")
public class CandidateAcademy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "department_name")
	private String departmentName;
	@NotNull
	@NotBlank
	@Column(name = "school_name")
	private String schoolName;
	@NotNull
	@Column(name = "started_year")
	private LocalDate startedYear;
	
	@Column(name = "finished_year")
	private LocalDate finishedYear;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
}
