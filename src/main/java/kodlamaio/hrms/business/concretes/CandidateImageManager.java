package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.Image.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;
@Service
public class CandidateImageManager implements CandidateImageService{
	
	private CandidateImageDao candidateImageDao;
	private ImageService imageService;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}
	@Override
	public Result add(CandidateImage candidateImage,MultipartFile multipartFile) {
		Map<String, String> resMap =(Map<String,String>) imageService.save(multipartFile).getData();
		//Map<String, String> resMap = this.imageService.save(multipartFile).getData();

		String image =resMap.get("image");
		candidateImage.setImage(image);
		
		return add(candidateImage);
	}
	@Override
	public DataResult<List<CandidateImage>> getAll() {
	
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll());
	}
	@Override
	public Result addAll(List<CandidateImage> candidateImages) {
		candidateImageDao.saveAll(candidateImages);
		return new SuccessResult("eklendi");
	}
	@Override
	public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.getAllByCandidateId(candidateId));
	}
	@Override
	public Result add(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Eklendi");
	}
	
	
	
	
	
}
