package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageService {
 DataResult<?> save(MultipartFile multipartFile);
}
