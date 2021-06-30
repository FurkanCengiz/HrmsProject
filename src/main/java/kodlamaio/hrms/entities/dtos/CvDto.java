package kodlamaio.hrms.entities.dtos;

import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateLink;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;
import kodlamaio.hrms.entities.concretes.LinkType;
import kodlamaio.hrms.entities.concretes.WorkExperiences;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {

	@JsonIgnore
	private Candidate candidate;

	private List<@Valid CandidateLanguage> candidateLanguages;

	private List<@Valid CandidateTechnology> candidateTechnologies;

	private List<@Valid WorkExperiences> workExperiences;

	private List<@Valid CandidateAcademy> candidateAcademies;
	
	private List<@Valid CandidateImage> candidateImages;
	
	private List<@Valid CandidateLink> candidateLinks;
	
	private List<@Valid LinkType> linkTypes;

}
