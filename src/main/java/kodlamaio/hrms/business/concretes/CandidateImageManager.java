package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.adapters.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;

public class CandidateImageManager implements CandidateImageService{

	private CandidateImageDao candidateImageDao;
	private ImageService imageService;
	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}
	@Override
	public Result add(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<CandidateImage>> getAll() {
	
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll());
	}
	
	
	
	
	
}
