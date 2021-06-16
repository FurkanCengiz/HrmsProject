package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
public class Candidate extends User {
	public Candidate(String email, String password, String firstName, String lastName, String nationalityId,
			Date birtDate) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birtDate = birtDate;
	}
	//@NotBlank(message ="İsim boş bırakılamaz")
	@Column(name = "first_name")
	private String firstName;

	//@NotBlank(message ="Soyisim boş bırakılamaz")
	@Column(name = "last_name")
	private String lastName;

	//@NotBlank(message ="TC Kimlik numarası boş bırakılamaz")
	//@Size(min=11,max=11, message="TC Kimlik numaranız 11 haneli olmalıdır.")
	@Column(name = "nationality_id")
	private String nationalityId;
	//@NotBlank(message ="Doğum tarihi boş bırakılamaz")
	@Column(name = "birth_date")
	private Date birtDate;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateAcademy> candidateAcademy;

	@OneToMany(mappedBy = "candidate")
	private List<WorkExperiences> workExperiences;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> candidateLanguages;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateTechnology> candidateTechnologies;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateImage> candidateImages;
	

}
