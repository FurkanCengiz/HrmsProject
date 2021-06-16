package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_links")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "link")
	private String link;

	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@ManyToOne()
	@JoinColumn(name = "link_id")
	private LinkType linkType;

}
