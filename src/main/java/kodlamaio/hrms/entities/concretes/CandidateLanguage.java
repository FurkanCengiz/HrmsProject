package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_languages")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Min(1)
	@Max(5)
	@NotNull
	@Column(name = "language_level")
	private short langugeLevel;

	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
