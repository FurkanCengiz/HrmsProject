package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User {
	public Employer(String email, String password, String companyName, String webSite, String phoneNumber) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		
	}
	
	@Column(name = "company_name")
	private String companyName;

	
	@Column(name = "web_site")
	private String webSite;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_active_update")
	private boolean isActiveUpdate;
	
	@JsonIgnore
	@OneToMany(mappedBy="employer")
	private List<JobPosition> jobPositions;
	
	

}
