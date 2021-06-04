package kodlamaio.hrms.core.utilities.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

public class ImageManager implements ImageService{

	private Cloudinary cloudinary;
	
	
	public ImageManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}


	@Override
	public DataResult<?> save(MultipartFile multipartFile) {
		try {
			Map uploadMap = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(uploadMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}
	

}
