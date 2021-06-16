package kodlamaio.hrms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.Image.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.Image.concretes.ImageManager;



@Configuration
public class AppConfiguration {
	  @Bean
	    public Cloudinary cloudinaryService(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "dqzlpw7ba",
	                "api_key", "129737976144648",
	                "api_secret", "EbOD_GlcYdKliHsToAtAMW7p7iE"));
	    }
	  
	  public ImageService imageService() {
		  return new ImageManager(cloudinaryService());
	  }
	
}
