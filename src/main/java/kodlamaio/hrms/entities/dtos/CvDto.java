package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import kodlamaio.hrms.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateAcademy;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;
import kodlamaio.hrms.entities.concretes.WorkExperiences;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {
	
	private Candidate candidate;
	private List<CandidateAcademy> candidateAcademies;
	private List<CandidateLanguage> candidateLanguages;
	private List<CandidateTechnology> candidateTechnologies;
	private List<WorkExperiences> workExperiences;
	
	
	
}
