package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers_activation_by_system_users")
public class EmployerActivationBySystemUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private int employerId;
	
	private int systemUserId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	

}*/
